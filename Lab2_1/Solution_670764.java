import java.util.PriorityQueue;

class Solution_670764 {

	public int[][] kClosest(int[][] points, int k) {
		return pq(points, k);
	}

	private int[][] pq(int[][] points, int k) {
		/* Expected RunTime is O(n log k) */
		int[][] ans = new int[k][2];
		PriorityQueue<int[]> heap = new PriorityQueue<>((p1, p2) -> {
			int d1 = p1[0] * p1[0] + p1[1] * p1[1];
			int d2 = p2[0] * p2[0] + p2[1] * p2[1];
			return d2 - d1;
		});

		for (int[] p : points) {
			heap.add(p);
			if (heap.size() > k)
				heap.poll();
		}

		int i = 0;
		while (!heap.isEmpty()) 
			ans[i++] = heap.poll();
		return ans;
	}
}