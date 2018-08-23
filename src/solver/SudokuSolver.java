package solver;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SudokuSolver {
    private SudokuBoard board;

    public SudokuSolver(int rows, int cols) {

        this.board = new SudokuBoard(rows, cols);
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

    public void makeBoard() {
        int row = 0;
        int col = 0;
        int val;
        Scanner scan = new Scanner(System.in);

        System.out.println("Numbers should be entered row by row, left to right, starting at the top left row.");
        System.out.println("If the space is blank, enter a 0.");
        System.out.println("Starting at row 1.");
        while(col < 9 && row < 9) {
            val = -1;

            while (val < 0 || val > 9) {
                System.out.printf("Please enter the number in spot %d of row %d.\n", col+1, row+1);
                val = scan.nextInt();
            }
            board.setDigitAtSquare(row, col, val);
            col++;

            if (col == 9) {
                row++;
                col = 0;
                System.out.printf("Onto row %d.\n", row+1);
            }
        }
    }

    public void printBoard() {
        for (int row = 0; row < 9; row++) {
            if (row % 3 == 0) {
                System.out.println("  ---------------------  ");
            }

            for (int col = 0; col < 9; col++) {
                if (col % 3 == 0) {
                    System.out.print("| ");
                }
                if (board.getDigitAtSquare(row, col) == 0) {
                    System.out.print(". ");
                } else {
                    System.out.print(board.getDigitAtSquare(row, col) + " ");
                }
            }
            System.out.println("|");
        }
        System.out.println("  ---------------------  ");
    }
}
