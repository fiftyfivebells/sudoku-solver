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

    public void clearBoard() {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                setSquareToDefault(row, col);
            }
        }
    }
}
