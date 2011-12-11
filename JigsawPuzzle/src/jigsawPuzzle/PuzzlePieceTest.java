package jigsawPuzzle;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class PuzzlePieceTest {
	
	PuzzlePiece p;
	Random rand;

	@Before
	public void setUp() throws Exception {
		//top, left, right, bottom
		rand =  new Random();
	}
	
	@Test
	public void testGetTop() {
		p = new PuzzlePiece(21, 22, 23, 24);
		assertEquals(21, p.getTop());
	}

	@Test
	public void testGetLeft() {
		p = new PuzzlePiece(21, 22, 23, 24);
		assertEquals(22, p.getLeft());
	}

	@Test
	public void testGetRight() {
		p = new PuzzlePiece(21, 22, 23, 24);
		assertEquals(23, p.getRight());
	}

	@Test
	public void testGetBottom() {
		p = new PuzzlePiece(21, 22, 23, 24);
		assertEquals(24, p.getBottom());
	}

	@Test
	public void testLastThreeDigits() {
		long r1;
		long r2;
		long r3;
		long r4;
		for(int i = 0; i < 100; i++) {
			r1 = rand.nextLong();
			r2 = rand.nextLong();
			r3 = rand.nextLong();
			r4 = rand.nextLong();
			p = new PuzzlePiece(r1, r2, r3, r4);
			assertEquals(Math.abs(r1 % 1000), PuzzlePiece.lastThreeDigits(p.getTop()));
			assertEquals(Math.abs(r2 % 1000), PuzzlePiece.lastThreeDigits(p.getLeft()));
			assertEquals(Math.abs(r3 % 1000), PuzzlePiece.lastThreeDigits(p.getRight()));
			assertEquals(Math.abs(r4 % 1000), PuzzlePiece.lastThreeDigits(p.getBottom()));
		}
			assertEquals(999, PuzzlePiece.lastThreeDigits(999999));
			assertEquals(999, PuzzlePiece.lastThreeDigits(-999999));
			assertEquals(999, PuzzlePiece.lastThreeDigits(999));
			assertEquals(999, PuzzlePiece.lastThreeDigits(-999));
			assertEquals(0, PuzzlePiece.lastThreeDigits(1000));
			assertEquals(2, PuzzlePiece.lastThreeDigits(2));
	}

	@Test
	public void testToString() {
		String val1;
		String val2;
		String val3;
		String val4;
		String together;
		long r1;
		long r2;
		long r3;
		long r4;
		for(int i = 0; i < 100; i++) {
			r1 = rand.nextLong();
			r2 = rand.nextLong();
			r3 = rand.nextLong();
			r4 = rand.nextLong();
			p = new PuzzlePiece(r1, r2, r3, r4);

			val1 = String.format("%03d", PuzzlePiece.lastThreeDigits(r1));
			val2 = String.format("%03d", PuzzlePiece.lastThreeDigits(r2));
			val3 = String.format("%03d", PuzzlePiece.lastThreeDigits(r3));
			val4 = String.format("%03d", PuzzlePiece.lastThreeDigits(r4));

			together = "[" + val1 + " " + val2 + " "  + val3 + " "  + val4 + "]";
			assertEquals(together, p.toString());
		}
		p = new PuzzlePiece(1000, 2001, 3010, 333);
		val1 = String.format("%03d", 0);
		val2 = String.format("%03d", 1);
		val3 = String.format("%03d", 10);
		val4 = String.format("%03d", 333);

		together = "[" + val1 + " " + val2 + " "  + val3 + " "  + val4 + "]";
		assertEquals(together, p.toString());
	}

}
