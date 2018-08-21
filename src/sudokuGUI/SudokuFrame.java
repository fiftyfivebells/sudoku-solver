package sudokuGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class SudokuFrame {
    private JFrame frame = new JFrame("Sudoku Solver");
    private JPanel buttonPanel;
    private JButton solveButton;
    private JButton clearButton;
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
        JMenuItem generate = new JMenuItem("Generate Puzzle");

        fileMenu.add(open);
        fileMenu.addSeparator();
        fileMenu.add(generate);
        menuBar.add(fileMenu);


        frame.setJMenuBar(menuBar);
    }

    private void makeButtons() {
        this.buttonPanel = new JPanel(new BorderLayout());
        this.solveButton = new JButton("Solve");
        this.clearButton = new JButton("Clear");

        Font buttonFont = new Font("sanserif", Font.CENTER_BASELINE, 20);
        solveButton.setFont(buttonFont);
        clearButton.setFont(buttonFont);

        buttonPanel.add(solveButton, BorderLayout.WEST);
        buttonPanel.add(clearButton, BorderLayout.EAST);

        clearButton.addActionListener((ActionEvent e) -> {
            clearBoard();
        });
    }

    private void clearBoard() {
        for (SudokuSquare[] row : grid.getSquares()) {
            for (SudokuSquare square : row) {
                square.setText("    ");
            }
        }
    }
}
