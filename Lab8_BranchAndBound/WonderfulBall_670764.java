import java.util.*;

public class WonderfulBall_670764 {

	static long count = 0;

	public static void main(String[] args) {
		System.out.print("Enter the input as one string: ");
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		char [] box = new char[input.length()];

		for (int i = 0; i < input.length(); i++)
			box[i] = input.charAt(i);

		int [] points = transformBallToPoint(box);

		backtrack(points, 0, 0, 0);
		System.out.println(count);
		sc.close();
	}

	static void backtrack(int [] points, int idx, int currentSum, int currentSize) {
		if (idx == points.length)
		{
			if ((currentSize > 0) && (currentSum > currentSize) && (currentSum >= 0) && (hasSameParity(currentSum, currentSize)))
				count++;
			return ;
		}

		backtrack(points, idx + 1, currentSum + points[idx], currentSize + 1);
		backtrack(points, idx + 1, currentSum, currentSize);
	}

	static int[] transformBallToPoint(char [] balls) {
		int [] box = new int[balls.length];
		for (int i = 0; i < balls.length; i++)
		{
			if (balls[i] == 'R')
				box[i] = 3;
			else if (balls[i] == 'G')
				box[i] = 2;
			else if (balls[i] == 'B')
				box[i] = -1;
			else if (balls[i] == 'W')
				box[i] = -2;
		}
		return box;
	}

	static boolean hasSameParity(int num1, int num2) {
		return ((num1 % 2) == (num2 % 2));
	}

}
