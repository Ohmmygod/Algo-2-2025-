import java.util.*;

public class DungeonGame_670764 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the dimensions of map (m n): ");
		int m = sc.nextInt();
		System.out.print("Enter map values (seperated by space): ");
		int n = sc.nextInt();

		int[][] dungeon = new int[m][n];

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				dungeon[i][j] = sc.nextInt();

		int[][] dp = new int[m][n];

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {

				if (i == m - 1 && j == n - 1)
					dp[i][j] = Math.max(1, 1 - dungeon[i][j]);
				else if (i == m - 1)
					dp[i][j] = Math.max(1, dp[i][j + 1] - dungeon[i][j]);
				else if (j == n - 1)
					dp[i][j] = Math.max(1, dp[i + 1][j] - dungeon[i][j]);
				else {
					int need = Math.min(dp[i + 1][j], dp[i][j + 1]);
					dp[i][j] = Math.max(1, need - dungeon[i][j]);
				}
			}
		}
		System.out.println(dp[0][0]);
		sc.close();
	}
}