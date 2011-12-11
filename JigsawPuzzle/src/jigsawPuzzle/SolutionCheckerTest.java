package jigsawPuzzle;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SolutionCheckerTest {
	final int MAXROW = 30;
	final int MAXCOLUMN = 30;
	PuzzleSolver ps = new PuzzleSolver();
	PuzzleCreator pc = new PuzzleCreator();
	PuzzlePiece[][] pp = new PuzzlePiece[MAXROW][MAXCOLUMN];
	SolutionChecker sc = new SolutionChecker();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIsCorrectlyAssembled() {
		PuzzlePiece[] puzzle;
		for (int row = 2; row <= MAXROW; row++) {
			for (int column = 2; column <= MAXCOLUMN; column++) {
				puzzle = pc.create(row, column);
				PuzzleCreator.shuffle(puzzle);
				pp = ps.solve(row, column, puzzle);
				assertTrue(sc.isCorrectlyAssembled(pp));
			}
		}
	}

}
