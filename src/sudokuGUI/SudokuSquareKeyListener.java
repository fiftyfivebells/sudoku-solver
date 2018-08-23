package sudokuGUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SudokuSquareKeyListener implements KeyListener {

    private SudokuSquare square;

    public SudokuSquareKeyListener(SudokuSquare square) {
        this.square = square;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        char c = keyEvent.getKeyChar();

        switch(c) {
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                square.setText("  " + Character.toString(c));
        }
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {}

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
