package test;

import org.junit.jupiter.api.*;
import main.solver.SudokuSolver;

public class SudokuSolverTest {

    private SudokuSolver testSolver;

    @BeforeEach
    void setup() {
        int[][] sampleBoard = { {0, 0, 7, 0, 3, 0, 8, 0, 0},
                                {0, 0, 0, 2, 0, 5, 0, 0, 0},
                                {4, 0, 0, 9, 0, 6, 0, 0, 1},
                                {0, 4, 3, 0, 0, 0, 2, 1, 0},
                                {1, 0, 0, 0, 0, 0, 0, 0, 5},
                                {0, 5, 8, 0, 0, 0, 6, 7, 0},
                                {5, 0, 0, 1, 0, 8, 0, 0, 9},
                                {0, 0, 0, 5, 0, 3, 0, 0, 0},
                                {0, 0, 2, 0, 9, 0, 5, 0, 0} };

        testSolver = new SudokuSolver(9, 9);
        testSolver.fillBoard(sampleBoard);
    }

    @Test
    void testGetDigitFromBoard() {
        Assertions.assertEquals(0, testSolver.getDigitFromBoard(0, 0));
        Assertions.assertEquals(7, testSolver.getDigitFromBoard(0, 2));
        Assertions.assertEquals(9, testSolver.getDigitFromBoard(6, 8));
    }

    @Test
    void testSolve() {
        testSolver.solve();

        Assertions.assertEquals(2, testSolver.getDigitFromBoard(0, 0));
        Assertions.assertEquals(3, testSolver.getDigitFromBoard(8, 8));
    }
}
