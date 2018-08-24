package test;

import main.solver.SudokuBoard;
import org.junit.jupiter.api.*;

public class SudokuBoardTest {

    private SudokuBoard testBoard;

    @BeforeEach
    void setup() {
        testBoard = new SudokuBoard(9, 9);
    }

    @Test
    void testGetDigitAtSquare() {
        Assertions.assertEquals(0, testBoard.getDigitAtSquare(0, 0));

        testBoard.setDigitAtSquare(8, 8, 5);

        Assertions.assertEquals(5, testBoard.getDigitAtSquare(8, 8));
    }

    @Test
    void testSetDigitAtSquare() {
        testBoard.setDigitAtSquare(5, 5, 7);
        testBoard.setDigitAtSquare(7, 7, 3);

        Assertions.assertEquals(7, testBoard.getDigitAtSquare(5, 5));
        Assertions.assertEquals(3, testBoard.getDigitAtSquare(7, 7));
    }
}
