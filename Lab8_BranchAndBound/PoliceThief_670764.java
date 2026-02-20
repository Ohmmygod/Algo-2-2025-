import java.util.*;

public class PoliceThief_670764 {

	static boolean policeFreeze = false;

	public static void main(String[] args) {
		System.out.println("Enter each number (0-100) seperated by 'space': ");
		Scanner sc = new Scanner(System.in);
		int [] nums = new int[20];
		for (int i = 0; i < nums.length; i++)
			nums[i] = sc.nextInt();

		backtrack(nums, 0, 0, new ArrayList<>());

		if (policeFreeze)
		{
			System.out.println("Police Freeze");
			return ;
		}
		else
			System.out.println("Free");
		sc.close();
	}

	static void backtrack(int [] nums, int idx, int currentSum, List<Integer> currentSet) {
			
		if (currentSum > 191)
			return;

		if (currentSum == 191)
		{
			if (checkPattern(currentSet))
				policeFreeze = true;
			return ;
		}

		if (idx == nums.length)
			return ; 
		
		currentSet.add(nums[idx]);
		backtrack(nums, idx + 1, currentSum + nums[idx], currentSet);
		currentSet.remove(currentSet.size() - 1);
		backtrack(nums, idx + 1, currentSum, currentSet);
	}

	static boolean checkPattern(List<Integer> set) {
	
		if (set.size() < 3)
			return false;

		for (int i = 1; i < set.size() - 1; i++)
		{
			int left = set.get(i-1);
			int mid = set.get(i);
			int right = set.get(i+1);

			if (isEven(left) && !isEven(mid) && isEven(right))
				return true;
		}
		return false;
	}

	static boolean isEven(int n) {
		return (n % 2 == 0);
	}
}
