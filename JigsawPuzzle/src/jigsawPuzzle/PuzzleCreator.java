package jigsawPuzzle;

import java.util.Random;

public class PuzzleCreator {
	final long RANDOM = -1;
	// For each i and j, the top [i][j] == bottom [i-1][j]
	// The left [i][j] == right [i][j-1] 
	public PuzzlePiece[] create(int rows, int columns) {
		long top;
		long right;
		long left;
		long bottom;

		PuzzlePiece[] retPuzzle = new PuzzlePiece[rows * columns];
		PuzzlePiece[][] puzzlePiece = new PuzzlePiece[rows][columns];
		for(int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (i == 0)	//first row
					top = 0;
				else top = puzzlePiece[i - 1][j].getBottom();
				if (i == rows - 1) //last row
					bottom = 0;
				else bottom = RANDOM;
				if (j == 0)
					left = 0;
				else left = puzzlePiece[i][j-1].getRight();
				if(j == columns - 1)
					right = 0;
				else
					right = RANDOM;
			puzzlePiece[i][j] = new PuzzlePiece(top, left, right, bottom);
			retPuzzle[i * columns + j] = puzzlePiece[i][j];
			}
		}
		return retPuzzle;
	}
	
	public static void shuffle(Object[] objects) {
		Random rand = new Random();
		int random;
		Object temp;
		for(int n = objects.length - 1; n >= 1; n--) {
			random = rand.nextInt(n); // choose a random number R, where 0 <= R < N
			temp = objects[n];
			objects[n] = objects[random];
			objects[random] = temp; //swap array locations N and R
			
		}
	}
	
}
