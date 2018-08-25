package main.sudokuGUI.listeners;

import main.sudokuGUI.SudokuSquare;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class SudokuSquareFocusListener implements FocusListener {

    private SudokuSquare square;

    public SudokuSquareFocusListener(SudokuSquare square) {
        this.square = square;
    }

    @Override
    public void focusGained(FocusEvent focusEvent) {
        if (square.isCanEdit() && square.getDigit() == 0) {
            square.setBackground(Color.YELLOW);
        }
    }

    @Override
    public void focusLost(FocusEvent focusEvent) {
        if (square.getDigit() == 0 || square.getActualValue() == 0 || square.getActualValue() == square.getDigit()) {
            square.setBackground(Color.WHITE);
        }
    }
}
