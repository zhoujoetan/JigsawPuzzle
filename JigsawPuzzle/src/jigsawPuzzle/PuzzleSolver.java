package jigsawPuzzle;

public class PuzzleSolver {
	
	/* Given the one dimensional array of PuzzlePieces, and the number of rows and 
	 * columns the result should have, assembles the puzzle by creating a two-dimensional 
	 * array of the right size, and placing all the pieces into it. (Hint: Find the piece 
	 * that goes in [0][0] and put it there; then work across and down, finding each piece as needed.).
	 */
	
	public PuzzlePiece[][] solve(int rows, int columns, PuzzlePiece[] pieces){
		long newTopWanted;
		long newLeftWanted;
		PuzzlePiece[][] pp = new PuzzlePiece[rows][columns];
		PuzzleSolver ps = new PuzzleSolver();
		for(int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (i == 0)	//first row
					newTopWanted = 0;
				else newTopWanted = pp[i - 1][j].getBottom();
				if (j == 0)
					newLeftWanted = 0;
				else newLeftWanted = pp[i][j-1].getRight();
				pp[i][j] = ps.findPiece(newTopWanted, newLeftWanted, pieces);
			}
		}
		return pp;
		
	}
	
    /* Searches the one-dimensional array of pieces for a piece whose top edge is topWanted and whose 
     * left edge is leftWanted. This method can be used by the solve method.

     * If a piece cannot be found, the method should create and throw a RuntimeException(message). 
     * The message should include information about the piece being searched for. Of course, if 
     * the PuzzleCreator did its job properly, this should never happen.
     */
	
	public PuzzlePiece findPiece(long topWanted, long leftWanted, PuzzlePiece[] pieces) {
		RuntimeException up = new RuntimeException();
		for(int i = 0; i < pieces.length; i++) {
			if(pieces[i].getTop() == topWanted && pieces[i].getLeft() == leftWanted) {
				return pieces[i];
			}
		}
			throw up;
		}

}
