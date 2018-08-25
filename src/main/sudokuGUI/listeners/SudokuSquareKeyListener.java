package main.sudokuGUI.listeners;

import main.sudokuGUI.SudokuSquare;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SudokuSquareKeyListener implements KeyListener {

    private SudokuSquare square;

    public SudokuSquareKeyListener(SudokuSquare square) {
        this.square = square;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        int digit = keyEvent.getKeyChar() - 48;

        if (digit >= 0 && digit < 10) {
            if (square.isCanEdit()) {
                square.addTextToField(digit);
                square.setDigit(digit);
            }

            if (square.getDigit() == 0) {
                square.setBackground(Color.YELLOW);
            }

            if (square.getDigit() == square.getActualValue()) {
                square.setCanEdit(false);
                square.setValueHidden(false);
                square.setBackground(Color.WHITE);
            }
        }


    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {}

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
