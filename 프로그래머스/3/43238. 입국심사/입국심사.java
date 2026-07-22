import java.util.Arrays;

class Solution {
	public long solution(int n, int[] times) {
		Arrays.sort(times);
		long loTime = 0;
		long hiTime = (long) times[0] * n;

		while (loTime < hiTime) {
			long midTime = loTime + (hiTime - loTime) / 2;

			long peopleCnt = 0;
			for (int waitTime : times) {
				peopleCnt += midTime / waitTime;
				if (peopleCnt >= n)
					break;
			}

			if (peopleCnt >= n) {
				hiTime = midTime;
			} else {
				loTime = midTime + 1;
			}
		}

		return loTime;
	}
}
