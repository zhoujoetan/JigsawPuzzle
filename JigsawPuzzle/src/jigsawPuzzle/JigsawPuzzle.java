package jigsawPuzzle;

public class JigsawPuzzle {

	/*
	 * Call the program with command-line arguments: args[0] as the number of rows, and 
	 * args[1] as the number of columns. Print an error message and quit if you don't get 
	 * exactly two command line arguments, or if they do not represent positive integers within a reasonable range.
	 * Use the PuzzleCreator to create a puzzle. Save the puzzle as an instance variable, 
	 * print it (as a list of puzzle pieces), then use the PuzzleSolver to solve the puzzle, 
	 * use the SolutionChecker to ensure that the puzzle was solved correctly, and print the assembled puzzle. 
	 */
	public static void main(String[] args) {
		PuzzleCreator pc = new PuzzleCreator();
		PuzzlePiece [] pp;
		PuzzlePiece [][] solvedPuzzle;
		SolutionChecker checker = new SolutionChecker();
		JigsawPuzzle puzzle = new JigsawPuzzle();
		int rows = Integer.parseInt(args[0]);
		int columns = Integer.parseInt(args[1]);
		if (rows <= 0 || columns <= 0)
		{
			System.out.println("Rows and Columns should be postive values!");
			return;
		}
		pp = pc.create(rows, columns);
		PuzzleSolver solver = new PuzzleSolver();
		try {
			solvedPuzzle = solver.solve(rows, columns, pp);
		}
		catch(RuntimeException e) {
			System.err.println("Piece not found :" + e.getMessage());
			return;
		}
		if (checker.isCorrectlyAssembled(solvedPuzzle)) {
			puzzle.print(solvedPuzzle);
		}
		return;
		
		
	}
	
	/**
	 * @param puzzle
	 */
	public void print(PuzzlePiece[][] puzzle) {
		for(int j = 0; j < puzzle[0].length; j++) {
			System.out.print("+-----------");
		}
		System.out.print("+\n");
		for(int i = 0; i < puzzle.length; i++) {
			for(int j = 0; j < puzzle[0].length; j++) {
				System.out.print("|    ");
				System.out.printf("%03d", PuzzlePiece.lastThreeDigits(puzzle[i][j].getTop()));
				System.out.print("    ");
			}
			System.out.print("|\n");
			for(int j = 0; j < puzzle[0].length; j++) {
				System.out.print("|");
				System.out.printf("%03d", PuzzlePiece.lastThreeDigits(puzzle[i][j].getLeft()));
				System.out.print("     ");
				System.out.printf("%03d", PuzzlePiece.lastThreeDigits(puzzle[i][j].getRight()));
			}
			System.out.print("|\n");
			for(int j = 0; j < puzzle[0].length; j++) {
				System.out.print("|    ");
				System.out.printf("%03d", PuzzlePiece.lastThreeDigits(puzzle[i][j].getBottom()));
				System.out.print("    ");
			}
			System.out.println("|");
			for(int j = 0; j < puzzle[0].length; j++) {
				System.out.print("+-----------");
			}
			System.out.print("+\n");
		}

	}

}
