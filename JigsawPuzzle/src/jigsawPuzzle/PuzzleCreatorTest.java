package jigsawPuzzle;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PuzzleCreatorTest {
	PuzzleCreator pc;
	Object[] obj;
	Object[] objRef;

	@Before
	public void setUp() throws Exception {
		pc = new PuzzleCreator();
	}

	@Test
	public void testShuffle() {
		for (int size = 2; size <= 100; size++) {
			obj = new Object[size];
			objRef = new Object[size];
			for (int j = 0; j < size; j++) {
				obj[j] = new Object();
				objRef[j] = obj[j];
			}
			PuzzleCreator.shuffle(obj);
			for (int j = 0; j < size; j++) {
				assertTrue(obj[j] != objRef[j]); 
			}
			assertEquals(obj.length, objRef.length);
		}
	}

}
