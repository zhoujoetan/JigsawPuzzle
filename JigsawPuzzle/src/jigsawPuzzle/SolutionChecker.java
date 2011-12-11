package jigsawPuzzle;

public class SolutionChecker {
	
	public boolean isCorrectlyAssembled(PuzzlePiece[][] solution) {
		long newTopWanted;
		long newLeftWanted;
		for(int i = 0; i < solution.length; i++) {
			for (int j = 0; j < solution[0].length; j++) {
				if (i == 0)	//first row
					newTopWanted = 0;
				else newTopWanted = solution[i - 1][j].getBottom();
				if (j == 0) //first column
					newLeftWanted = 0;
				else newLeftWanted = solution[i][j-1].getRight();
				if(newTopWanted != solution[i][j].getTop())
					return false;
				if(newLeftWanted != solution[i][j].getLeft())
					return false;
				if(j == solution[0].length - 1)
					if(0 != solution[i][j].getRight())
						return false;
				if(i == solution.length - 1)
					if(0 != solution[i][j].getBottom())
						return false;

			}
		}
		return true;
	}

}
