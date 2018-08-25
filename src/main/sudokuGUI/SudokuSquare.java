package main.sudokuGUI;

import main.solver.SudokuSolver;

import javax.swing.*;
import java.awt.*;

public class SudokuSquare extends JTextField {
    private int digit;              // number shown in sudoku board
    private int actualValue;        // square's value in solved board

    private int row;                // x position in sudoku board
    private int col;                // y position in sudoku board

    private boolean canEdit;
    private boolean valueHidden;    // is the square one the user needs to guess?

    public SudokuSquare(int row, int col) {
        super();

        this.row = row;
        this.col = col;

        this.canEdit = true;
        this.valueHidden = false;

        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setPreferredSize(new Dimension(50, 50));
        setBackground(Color.WHITE);

        Font font = new Font("sanserif", Font.BOLD, 24);
        this.setFont(font);

        this.setEditable(false);

        addTextToField();
    }

    public void setFocus(boolean val) {
        this.focus = val;
    }

    public boolean getFocus() { return focus; }

    public int getDigit() { return digit; }

    public void setDigit(int digit) {
        this.digit = digit;
    }

    private void getDigitFromBoard(SudokuSolver sudoku) {
        this.digit = sudoku.getDigitFromBoard(x, y);
    }

    private void addTextToField() {
        String text = Integer.toString(digit);

        if (text.equals("0")) {
            text = " ";
        }
        this.setText("  " + text);
    }
}
