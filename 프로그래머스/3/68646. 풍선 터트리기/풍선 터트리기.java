class Solution {
	public int solution(int[] a) {
		int[] prefixMin = new int[a.length];
		int[] suffixMin = new int[a.length];
		prefixMin[0] = a[0];
		suffixMin[a.length - 1] = a[a.length - 1];
		for (int pi = 1; pi < a.length; pi++) {
			prefixMin[pi] = Math.min(prefixMin[pi - 1], a[pi]);
			int si = a.length - 1 - pi;
			suffixMin[si] = Math.min(suffixMin[si + 1], a[si]);
		}

		int answer = 0;

		for (int i = 0; i < a.length; i++) {
			int left = i == 0 ? 1_000_000_001 : prefixMin[i - 1];
			int right = i == a.length - 1 ? 1_000_000_001 : suffixMin[i + 1];

			if (left > a[i] || right > a[i])
				answer++;
		}

		return answer;
	}
}
