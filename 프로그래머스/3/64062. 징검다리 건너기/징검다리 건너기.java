class Solution {
	int stones[];
	int k;

	public int solution(int[] stones, int k) {
		this.stones = stones;
		this.k = k;
		final int MAX_STONE_VAL = 200_000_000;

		int answer = 0;

		int left = 0;
		int right = MAX_STONE_VAL + 1;

		while (left < right) {
			int mid = (left + right) / 2;

			if (isCrossable(mid)) {
				left = mid + 1;
			} else {
				right = mid;
			}

		}

		return left - 1;
	}

	boolean isCrossable(int friendsNum) {
		int emptyCnt = 0;
		for (int stone : stones) {
			if (stone < friendsNum) {
				emptyCnt++;
			} else {
				emptyCnt = 0;
			}
			if (emptyCnt >= k) {
				return false;
			}
		}
		return true;

	}
}