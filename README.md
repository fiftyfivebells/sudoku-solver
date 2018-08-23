# Sudoku Solver

This is a simple sudoku solver written in Java. It will have a basic GUI for generating a puzzle to solve, solving the current puzzle, or loading in your own puzzle from a file.

Presently, the algorithm for solving the puzzle is a straight-forward, brute-force implementation of depth-first search. Once the GUI is working like it's supposed to, I plan to read more about and try to implement the Dancing Links algorithm, which I suspect will be much more efficient.

### Notes

* Should SudokuSolver have it's own way to fill the board, or is letting the openFile method in the GUI good enough? Is that tying my model and view too closely together?
