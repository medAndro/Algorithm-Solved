class Solution {
	final int MAX_STONE = 200_000_000;
	int[] stones;
	int k;

	public int solution(int[] stones, int k) {
		this.stones = stones;
		this.k = k;
		int left = 1;
		int right = MAX_STONE + 1;

		while (left < right) {
			int mid = left + (right - left) / 2;

			if (isCanAcross(mid)) {
				left = mid + 1;
			} else {
				right = mid;
			}

		}

		return left - 1;
	}

	boolean isCanAcross(int chk) {
		int chain = 0;

		for (int stone : stones) {
			if (stone < chk) {
				chain++;
				if (chain == k) {
					return false;
				}
			} else {
				chain = 0;
			}
		}
		return true;
	}
}