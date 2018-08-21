package sudokuGUI;

import solver.SudokuSolver;

import javax.swing.*;
import java.awt.*;

public class SudokuSquare extends JTextField {
    private int digit;  // number in sudoku board
    private int x;      // x position in sudoku board
    private int y;      // y position in sudoku board

    public SudokuSquare(int x, int y) {
        super();

        this.x = x;
        this.y = y;
        this.digit = x;

        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setPreferredSize(new Dimension(50, 50));

        Font font = new Font("sanserif", Font.BOLD, 24);
        this.setFont(font);

        this.setEditable(false);

        addTextToField();
    }

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
