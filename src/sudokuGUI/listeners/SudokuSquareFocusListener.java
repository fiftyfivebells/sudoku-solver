package sudokuGUI.listeners;

import sudokuGUI.SudokuSquare;

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
        square.setBackground(Color.YELLOW);
    }

    @Override
    public void focusLost(FocusEvent focusEvent) {
        square.setBackground(Color.WHITE);
    }
}
