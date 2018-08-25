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

        setEditable(false);

        addTextToField();
    }

    public int getDigit() { return digit; }

    public void setDigit(int digit) {

        this.digit = digit;
        addTextToField();
    }

    public boolean isCanEdit() {
        return canEdit;
    }

    public void setCanEdit(boolean edit) {
        canEdit = edit;
    }

    public boolean isValueHidden() {
        return valueHidden;
    }

    public void setValueHidden(boolean hidden) {
        this.valueHidden = true;
    }

    public void setActualValue(int value) {
        this.actualValue = value;
        this.canEdit = false;
    }

    private void getValueFromBoard(SudokuSolver sudoku) {
        this.actualValue = sudoku.getDigitFromBoard(row, col);
    }

    private void addTextToField() {

        if (digit == actualValue) {
           displayText(actualValue);
        } else {
            displayText(digit);
        }
    }

    public void addTextToField(int digit) {

            displayText(digit);

            if (digit != actualValue && actualValue != 0) {
                setBackground(Color.RED);
            }
    }

    private void displayText(int digit) {
        if (digit == 0) {
            setText("   ");
        } else {
            setText("  " + digit);
        }
    }
}
