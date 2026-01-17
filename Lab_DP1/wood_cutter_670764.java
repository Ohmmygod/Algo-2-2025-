class wood_cutter_670764 {

	static int[] price = {
		0,
		1, 5, 8, 9, 10,
		17, 17, 20, 24, 30
	};

	static int[] memo;

	static int solve(int n) {
		if (n == 0)
			return 0;

		if (memo[n] != -1)
			return memo[n];

		int best = 0;

		for (int k = 1; k <= 10 && k <= n; k++) {
			int value = price[k] + solve(n - k);
			if (value > best)
				best = value;
		}

		memo[n] = best;
		return best;
	}

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Please provide exactly one argument.");
			return ; 
		}
		int N = Integer.parseInt(args[0]);

		memo = new int[N + 1];
		for (int i = 0; i <= N; i++)
			memo[i] = -1;

		int result = solve(N);
		System.out.printf("Highest Price: %d\n", result);
	}
}