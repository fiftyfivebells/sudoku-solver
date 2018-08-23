package sudokuGUI;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SudokuSquareMouseListener implements MouseListener {

    private SudokuSquare square;

    public SudokuSquareMouseListener(SudokuSquare square) {
        this.square = square;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {}

    @Override
    public void mousePressed(MouseEvent mouseEvent) {}

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        if (square.getFocus()) {
            square.requestFocusInWindow();
            square.setFocus(false);
        }
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {}

    @Override
    public void mouseExited(MouseEvent mouseEvent) {}
}
