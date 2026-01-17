	public class SubsetSum_670764 {

	static boolean subsetSum(int[] nums, int sum) {

		int n = nums.length;
		boolean[][] dp = new boolean[n + 1][sum + 1];

		for (int i = 0; i <= n; i++) {
			dp[i][0] = true;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				dp[i][j] = dp[i - 1][j];
				if (j >= nums[i - 1]) {
					dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
				}
			}
		}
		return dp[n][sum];
	}

	static void test() {

		int[] nums1 = {1, 4, 3, 2, 7};
		int sum1 = 9;
		System.out.println(subsetSum(nums1, sum1)); // true

		int[] nums2 = {3, 34, 4, 12, 5, 2};
		int sum2 = 9;
		System.out.println(subsetSum(nums2, sum2)); // true

		int[] nums3 = {3, 34, 4, 12, 5, 2};
		int sum3 = 30;
		System.out.println(subsetSum(nums3, sum3)); // false

		int[] nums4 = {30, 7, 5, 16, 4, 2, 3, 3, 10, 50};
		int sum4 = 25;
		System.out.println(subsetSum(nums4, sum4)); // true
	}

	public static void main(String[] args) {
		test();
	}
}