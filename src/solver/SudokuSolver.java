package solver;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SudokuSolver {
    private int[][] board;

    public SudokuSolver(int x, int y) {
        this.board = new int[x][y];
    }

    public int getDigitFromBoard(int x, int y) { return board[x][y]; }

    public boolean solve() {
        int[] coords = nextEmptyCell();

        int row = coords[0];
        int col = coords[1];

        if (row == -1) {
            return (!isValidBoard()) ? false : true;
        }

        for (int test = 1; test < 10; test++) {
            if (validLocation(row, col, test)) {
                board[row][col] = test;

                if (solve()) { return true; }

                board[row][col] = 0;
            }
        }

        return false;
    }

    private int[] nextEmptyCell() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    return new int[] { i, j };
                }
            }
        }

        return new int[] { -1, -1 };
    }

    private boolean validLocation(int row, int col, int testVal) {
        return notInRow(row, testVal) && notInCol(col, testVal) && notInGrid(row, col, testVal);
    }

    private boolean notInRow(int row, int testVal) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == testVal) { return false; }
        }
        return true;
    }

    private boolean notInCol(int col, int testVal) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == testVal) { return false; }
        }
        return true;
    }

    private boolean notInGrid(int row, int col, int testVal) {
        int beginningRow = (row / 3) * 3;
        int beginningCol = (col / 3) * 3;

        for (int i = beginningRow; i < beginningRow + 3; i++) {
            for (int j = beginningCol; j < beginningCol + 3; j++) {
                if (board[i][j] == testVal) { return false; }
            }
        }
        return true;
    }

    private boolean isValidBoard() {
        Set<Integer> checker = new HashSet<Integer>();

        // check rows
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (checker.contains(board[i][j])) { return false; }
            }
            checker.clear();
        }

        // check columns
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (checker.contains(board[j][i])) { return false; }
            }
            checker.clear();
        }

        // check boxes
        // check rows
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!checkSquare(i, j)) { return false; }
            }
        }
        checker.clear();

        return true;
    }

    private boolean checkSquare(int row, int col) {
        int beginningRow = (row / 3) * 3;
        int beginningCol = (col / 3) * 3;

        Set<Integer> checker = new HashSet<Integer>();

        for (int i = beginningRow; i < beginningRow + 3; i++) {
            for (int j = beginningCol; j < beginningCol + 3; j++) {
                int val = board[i][j];

                if (checker.contains(val)) { return false; }

                if (val != 0) {
                    checker.add(val);
                }
            }
        }
        return true;
    }

    public int[][] makeBoard() {
        int i = 0;
        int j = 0;
        int val;
        int[][] board = new int[9][9];
        Scanner scan = new Scanner(System.in);

        System.out.println("Numbers should be entered row by row, left to right, starting at the top left row.");
        System.out.println("If the space is blank, enter a 0.");
        System.out.println("Starting at row 1.");
        while(j < 9 && i < 9) {
            val = -1;

            while (val < 0 || val > 9) {
                System.out.printf("Please enter the number in spot %d of row %d.\n", j+1, i+1);
                val = scan.nextInt();
            }
            board[i][j] = val;
            j++;

            if (j == 9) {
                i++;
                j = 0;
                System.out.printf("Onto row %d.\n", i+1);
            }
        }

        return board;
    }

    public void printBoard() {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0) {
                System.out.println("  ---------------------  ");
            }

            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0) {
                    System.out.print("| ");
                }
                if (board[i][j] == 0) {
                    System.out.print(". ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println("|");
        }
        System.out.println("  ---------------------  ");
    }
}
