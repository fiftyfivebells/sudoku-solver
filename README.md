# Sudoku Solver

This is a simple sudoku main.solver written in Java. It will have a basic GUI for generating a puzzle to solve, solving the current puzzle, or loading in your own puzzle from a file.

Presently, the algorithm for solving the puzzle is a straight-forward, brute-force implementation of depth-first search. Once the GUI is working like it's supposed to, I plan to read more about and try to implement the Dancing Links algorithm, which I suspect will be much more efficient.

## Usage

The puzzle has three buttons:

* Solve will solve the current puzzle
* Generate creates a new puzzle to solve
* Clear will empty the board to its initial state

The "open" option in the menu allows a user to load in a puzzle file. The file should be a CSV in the following form:

1,1,1,1,1,1,1,1,1
2,2,2,2,2,2,2,2,2
3,3,3,3,3,3,3,3,3
4,4,4,4,4,4,4,4,4
5,5,5,5,5,5,5,5,5
6,6,6,6,6,6,6,6,6
7,7,7,7,7,7,7,7,7
8,8,8,8,8,8,8,8,8
9,9,9,9,9,9,9,9,9

Blank spaces in the puzzle should be entered as zeros.

### Notes (for me)

* Should SudokuSolver have it's own way to fill the board, or is letting the openFile method in the GUI good enough? Is that tying my model and view too closely together?

* Go back and change add methods to interact with classes instead of accessing the instance variables directly. Case in point: the SudokuSquare class should have a method to set the text, rather than having other methods set the test directly on the variable itself.

* Go back and see if there are places where I can simplify the code or cut pieces out. It seems like it might be a bit too complicated at the moment.
