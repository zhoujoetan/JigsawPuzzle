package jigsawPuzzle;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PuzzleSolverTest {
	final int MAXROW = 30;
	final int MAXCOLUMN = 30;
	PuzzleSolver ps = new PuzzleSolver();
	PuzzleCreator pc = new PuzzleCreator();
	PuzzlePiece[][] pp = new PuzzlePiece[MAXROW][MAXCOLUMN];

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindPiece() {
		PuzzlePiece[] puzzle;
		long newTopWanted;
		long newLeftWanted;
		for (int row = 2; row <= MAXROW; row++) {
			for (int column = 2; column <= MAXCOLUMN; column++) {
				puzzle = pc.create(row, column);
				PuzzleCreator.shuffle(puzzle);
				
				for(int i = 0; i < row; i++) {
					for (int j = 0; j < column; j++) {
						if (i == 0)	//first row
							newTopWanted = 0;
						else newTopWanted = pp[i - 1][j].getBottom();
					
						if (j == 0)
							newLeftWanted = 0;
						else newLeftWanted = pp[i][j-1].getRight();
						pp[i][j] = ps.findPiece(newTopWanted, newLeftWanted, puzzle);
						assertEquals(newTopWanted, pp[i][j].getTop());
						assertEquals(newLeftWanted, pp[i][j].getLeft());
						if(j == column - 1)
							assertEquals(0, pp[i][j].getRight()); 
						if(i == row - 1)
							assertEquals(0, pp[i][j].getBottom());

					}
				}
			}
			
		}
	}

}
