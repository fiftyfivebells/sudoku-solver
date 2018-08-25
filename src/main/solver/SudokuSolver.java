package main.solver;

import java.util.*;

public class SudokuSolver {
    private SudokuBoard board;

    public SudokuSolver(int rows, int cols) {

        this.board = new SudokuBoard(rows, cols);
    }

    public SudokuBoard getBoard() { return board; }

    public void clearBoard() {
        board.clearBoard();
    }

    public int getDigitFromBoard(int row, int col) { return board.getDigitAtSquare(row, col); }

    public boolean solve() {
        int[] coords = nextEmptyCell();

        int row = coords[0];
        int col = coords[1];

        if (row == -1) {
            return (!isValidBoard()) ? false : true;
        }

        for (int test = 1; test < 10; test++) {
            if (validLocation(row, col, test)) {
                board.setDigitAtSquare(row, col, test);

                if (solve()) { return true; }

                board.setSquareToDefault(row, col);
            }
        }

        return false;
    }

    public void generatePuzzle() {
       List<Integer> topRow = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            topRow.add(i);
        }

        for (int i = 0; i < 9; i++) {
            Collections.shuffle(topRow);
            board.setDigitAtSquare(0, i, topRow.remove(0));
        }

        solve();
    }

    private int[] nextEmptyCell() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board.getDigitAtSquare(row, col) == 0) {
                    return new int[] { row, col };
                }
            }
        }

        return new int[] { -1, -1 };
    }

    private boolean validLocation(int row, int col, int testVal) {
        return notInRow(row, testVal) && notInCol(col, testVal) && notInGrid(row, col, testVal);
    }

    private boolean notInRow(int row, int testVal) {
        for (int col = 0; col < 9; col++) {
            if (board.getDigitAtSquare(row, col) == testVal) { return false; }
        }
        return true;
    }

    private boolean notInCol(int col, int testVal) {
        for (int row = 0; row < 9; row++) {
            if (board.getDigitAtSquare(row, col) == testVal) { return false; }
        }
        return true;
    }

    private boolean notInGrid(int row, int col, int testVal) {
        int beginningRow = (row / 3) * 3;
        int beginningCol = (col / 3) * 3;

        for (int x = beginningRow; x < beginningRow + 3; x++) {
            for (int y = beginningCol; y < beginningCol + 3; y++) {
                if (board.getDigitAtSquare(x, y) == testVal) { return false; }
            }
        }
        return true;
    }

    private boolean isValidBoard() {
        Set<Integer> checker = new HashSet<Integer>();

        // check rows
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (checker.contains(board.getDigitAtSquare(row, col))) { return false; }
            }
            checker.clear();
        }

        // check columns
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (checker.contains(board.getDigitAtSquare(col, row))) { return false; }
            }
            checker.clear();
        }

        // check boxes
        // check rows
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                if (!checkSquare(row, col)) { return false; }
            }
        }
        checker.clear();

        return true;
    }

    private boolean checkSquare(int row, int col) {
        int beginningRow = (row / 3) * 3;
        int beginningCol = (col / 3) * 3;

        Set<Integer> checker = new HashSet<Integer>();

        for (int x = beginningRow; x < beginningRow + 3; x++) {
            for (int y = beginningCol; y < beginningCol + 3;y++) {
                int val = board.getDigitAtSquare(x, y);

                if (checker.contains(val)) { return false; }

                if (val != 0) {
                    checker.add(val);
                }
            }
        }
        return true;
    }

    public void fillBoard(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                this.board.setDigitAtSquare(x, y, board[x][y]);
            }
        }
    }


}
