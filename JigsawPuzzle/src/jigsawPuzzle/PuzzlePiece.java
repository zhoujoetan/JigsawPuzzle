package jigsawPuzzle;

import java.util.Random;

/**
 * @author Aaron Hobson
 * @author Zhou Tan
 *
 */
public class PuzzlePiece {
	final long RANDOM = -1;
	Random rand;
	long top;
	long left;
	long right;
	long bottom;
	/*
	This is a constructor for puzzle pieces. For each of the four sides, 
	it will do the following: If any parameter is exactly -1, it will choose a
	random long number for that side. If the parameter is any other number, it 
	will use the parameter value for that side. (We can do this because, although 
	it is possible for the random number generator to return -1, that will only 
	happen about once every ten billion billion tries.)

	Note: In order to avoid passing in -1 as a "magic number" (a number whose 
	meaning is not obvious from context), give it a name in your class; define 
	the variable final long RANDOM = -1;
	*/
	public PuzzlePiece(long top, long left, long right, long bottom) {
		rand = new Random();
		if (top == RANDOM)
		{
			this.top = rand.nextLong();
		}
		else
		{
			this.top = top;
		}
		if (left == RANDOM)
		{
			this.left = rand.nextLong();
		}
		else
		{
			this.left = left;
		}		
		if (right == RANDOM)
		{
			this.right = rand.nextLong();
		}
		else
		{
			this.right = right;
		}		
		if (bottom == RANDOM)
		{
			this.bottom = rand.nextLong();
		}
		else
		{
			this.bottom = bottom;
		}		

		
	}
	
	public long getTop() {
		return top;
	
	}
	public long getLeft() {
		return left;
	}
	public long getRight() {
		return right;
		
	}
	public long getBottom() {
		return bottom;
		
	}
	
	public static int lastThreeDigits(long longNumber) {
		return (int) Math.abs(longNumber % 1000);
	}
	
	public String toString() {
		String val1 = String.format("%03d", PuzzlePiece.lastThreeDigits(top));
		String val2 = String.format("%03d", PuzzlePiece.lastThreeDigits(left));
		String val3 = String.format("%03d", PuzzlePiece.lastThreeDigits(right));
		String val4 = String.format("%03d", PuzzlePiece.lastThreeDigits(bottom));
		return "[" + val1 + " " + val2 + " "  + val3 + " "  + val4 + "]";
	}

}
