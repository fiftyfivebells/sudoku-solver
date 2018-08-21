package sudokuGUI;

import javax.swing.*;

public class SudokuFrame {
    private JFrame frame = new JFrame("Sudoku Solver");

    public SudokuFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SudokuGrid(3, 3));
        createMenu();
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        JMenuItem open = new JMenuItem("Open");

        fileMenu.add(open);
        menuBar.add(fileMenu);

        frame.setJMenuBar(menuBar);
    }
}
