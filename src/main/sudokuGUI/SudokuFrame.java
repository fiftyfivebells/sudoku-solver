package main.sudokuGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SudokuFrame {
    private JFrame frame = new JFrame("Sudoku Solver");
    private JPanel buttonPanel;
    private JButton solveButton;
    private JButton clearButton;
    private JButton generateButton;
    private SudokuGrid grid = new SudokuGrid(3, 3);

    public SudokuFrame() {

        frame.getContentPane().setLayout(new BorderLayout());
        makeButtons();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(grid, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        createMenu();
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        JMenuItem open = new JMenuItem("Open");
        JMenuItem about = new JMenuItem("About");

        fileMenu.add(open);
        fileMenu.addSeparator();
        fileMenu.add(about);
        menuBar.add(fileMenu);

        // open a file and fill the board with it
        open.addActionListener((ActionEvent e) -> {
            JFileChooser chooser = new JFileChooser();
            int status = chooser.showOpenDialog(frame);

            if (status == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                openFile(file);
            }
        });

        about.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(
                    null,
                    "By Stephen (fiftyfivebells) Bell " +
                            "\n Code at http://www.github.com/fiftyfivebells/sudoku-solver",
                    "About",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        frame.setJMenuBar(menuBar);
    }

    public void openFile(File file) {
        try {
            Scanner scan = new Scanner(file);
            // clearBoard();

            int lines = 9; // total number of squares in sudoku board
            int x = 0;
            int y = 0;

            while (lines > 0) {
                String row = scan.nextLine();
                String[] numsInRow = row.split(",");


                try {
                    for (String num : numsInRow) {
                        int digit = Integer.parseInt(num);

                        grid.getSolver().getBoard().setDigitAtSquare(x, y, digit);

                        if (digit != 0) {
                            grid.getSquares()[x][y].setCanEdit(false);
                        }

                        if (digit >= 0 && digit < 10) {
                            grid.getSquares()[x][y++].setDigit(digit);
                        }
                    }
                } catch(NumberFormatException e) {
                    System.out.println(e.getStackTrace());
                }
                x++;
                y = 0;
                lines--;
            }


        } catch(FileNotFoundException e) {
            System.out.println(e.getStackTrace());
        }
    }

    private void makeButtons() {
        this.buttonPanel = new JPanel(new BorderLayout());
        this.solveButton = new JButton("Solve");
        this.clearButton = new JButton("Clear");
        this.generateButton = new JButton("Generate");

        Font buttonFont = new Font("sanserif", Font.CENTER_BASELINE, 20);
        solveButton.setFont(buttonFont);
        clearButton.setFont(buttonFont);
        generateButton.setFont(buttonFont);

        buttonPanel.add(solveButton, BorderLayout.WEST);
        buttonPanel.add(generateButton, BorderLayout.CENTER);
        buttonPanel.add(clearButton, BorderLayout.EAST);

        clearButton.addActionListener((ActionEvent e) -> {
            clearBoard();
        });

        solveButton.addActionListener((ActionEvent e) -> {
            solveBoard();
        });

        generateButton.addActionListener((ActionEvent e) -> {
            generatePuzzle();
        });
    }

    private void clearBoard() {
        for (SudokuSquare[] row : grid.getSquares()) {
            for (SudokuSquare square : row) {
                square.setDigit(0);
                square.setActualValue(0);
                square.setCanEdit(true);
            }
        }
        grid.getSolver().clearBoard();
    }

    private void solveBoard() {
        grid.getSolver().solve();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int digit = grid.getSolver().getDigitFromBoard(row, col);
                grid.getSquares()[row][col].setDigit(digit);
                grid.getSquares()[row][col].setActualValue(digit);
            }
        }
    }

    public void generatePuzzle() {
        grid.getSolver().generatePuzzle();
        grid.fillGrid();
        grid.hideSquares();
    }
}
