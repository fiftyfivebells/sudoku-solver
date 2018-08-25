package main.sudokuGUI;

import main.solver.SudokuBoard;
import main.solver.SudokuSolver;
import main.sudokuGUI.listeners.SudokuSquareFocusListener;
import main.sudokuGUI.listeners.SudokuSquareKeyListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SudokuGrid extends JPanel {

    private int width;
    private int height;
    private SudokuSquare[][] squares;
    private SudokuSolver solver;

    public SudokuGrid(int width, int height) {
        super(new GridBagLayout());

        this.width = width;
        this.height = height;
        this.solver = new SudokuSolver(9, 9);

        // make grid that holds all squares, not just 3x3
        this.squares = new SudokuSquare[width*height][width*height];

        GridBagConstraints gbc = new GridBagConstraints();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                gbc.weightx = 1.0;
                gbc.weighty = 1.0;
                gbc.fill = GridBagConstraints.BOTH;
                gbc.gridx = x;
                gbc.gridy = y;
                add(smallGrid(x, y), gbc);
            }
        }

        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public SudokuSolver getSolver() {
        return solver;
    }

    public SudokuSquare[][] getSquares() { return squares; }

    private JPanel smallGrid(int row, int col) {
        JPanel grid = new JPanel();
        grid.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                gbc.weightx = 1.0;
                gbc.weighty = 1.0;
                gbc.fill = GridBagConstraints.BOTH;
                gbc.gridx = x;
                gbc.gridy = y;

                // get (x,y) coords in 9x9 suduku grid and use
                // those for the sudoku square (x,y) values
                int gridX = x + (row * width);
                int gridY = y + (col * height);
                SudokuSquare square = new SudokuSquare(gridX, gridY);
                square.addActionListener((ActionEvent e) -> {
                    square.setBackground(Color.YELLOW);
                });

                grid.add(square, gbc);

                // add listeners to the square
                square.addKeyListener(new SudokuSquareKeyListener(square));
                square.addFocusListener(new SudokuSquareFocusListener(square));
                this.squares[gridY][gridX] = square;
            }
        }

        grid.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        grid.setPreferredSize(new Dimension(150, 150));
        return grid;
    }

    // fills the GUI board from the solved back-end board, setting
    // actual value of each square to its solved value

    public void fillGrid() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int value = solver.getDigitFromBoard(row, col);
                squares[row][col].setActualValue(value);
                squares[row][col].setDigit(value);
            }
        }
    }
}
