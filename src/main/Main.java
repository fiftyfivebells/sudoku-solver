package main;

import main.solver.SudokuSolver;

public class Main {
    public static void main(String[] args) {

        SudokuSolver game = new SudokuSolver(9, 9);

        game.makeBoard();
        game.printBoard();
        game.solve();
        game.printBoard();
    }
}
