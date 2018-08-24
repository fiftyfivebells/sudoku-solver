package main.solver;

public class SudokuBoard {
    private int[][] grid;

    public SudokuBoard(int rows, int cols) {
        grid = new int[rows][cols];
    }

    public int[][] getGrid() {
        return grid;
    }

    public int getDigitAtSquare(int row, int col) {
        return grid[row][col];
    }

    public void setDigitAtSquare(int row, int col, int val) {
        grid[row][col] = val;
    }

    public void setSquareToDefault(int row, int col) {
        grid[row][col] = 0;
    }
}
