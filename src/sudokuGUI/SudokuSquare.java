package sudokuGUI;

import solver.SudokuSolver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SudokuSquare extends JTextField {
    private int digit;      // number in sudoku board
    private int x;          // x position in sudoku board
    private int y;          // y position in sudoku board

    private boolean focus;  // is the square the focus?

    public SudokuSquare(int x, int y) {
        super();

        this.x = x;
        this.y = y;

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
