import java.util.Arrays;

class Solution {
	static int[] nArr;
	static char[] sArr;
	static int[][] maxDp;
	static int[][] minDp;

	public int solution(String arr[]) {
		int nLen = (arr.length + 1) / 2;
		nArr = new int[nLen]; // 숫자들 int 추출

		int sLen = (arr.length) / 2;
		sArr = new char[sLen]; // 기호들 char 추출

		int idx = 0;
		for (int ai = 0; ai < arr.length; ai += 2) {
			nArr[idx++] = Integer.parseInt(arr[ai]);
		}
		idx = 0;
		for (int ai = 1; ai < arr.length; ai += 2) {
			sArr[idx++] = arr[ai].charAt(0);
		}

		maxDp = new int[nLen][nLen];
		minDp = new int[nLen][nLen];
		for (int i = 0; i < nLen; i++) {
			Arrays.fill(minDp[i], 1000000000);
			Arrays.fill(maxDp[i], -1000000000);
		}

		for (int i = 0; i < nLen; i++) {
			maxDp[i][i] = nArr[i];
			minDp[i][i] = nArr[i];
		}

		for (int i = 2; i <= nLen; i++) {
			// 2부터 숫자의 길이까지 늘려가며 dp에 추가
			for (int j = i - 1; j < nLen; j++) {
				int left = j - i + 1;
				int right = j;
				calculate(left, right);
			}
		}
		return maxDp[0][nLen - 1];
	}

	void calculate(int idxL, int idxR) {
		int len = idxR - idxL + 1;

		for (int i = 1; i < len; i++) {
			int idxCut = i + idxL - 1;
			char symbol = sArr[idxCut];

			int minLeft = minDp[idxL][idxCut];
			int maxLeft = maxDp[idxL][idxCut];
			int minRight = minDp[idxCut + 1][idxR];
			int maxRight = maxDp[idxCut + 1][idxR];

			if (symbol == '-') {
				minDp[idxL][idxR] = Math.min(minDp[idxL][idxR], minLeft - maxRight);
				maxDp[idxL][idxR] = Math.max(maxDp[idxL][idxR], maxLeft - minRight);
			} else {
				minDp[idxL][idxR] = Math.min(minDp[idxL][idxR], minLeft + minRight);
				maxDp[idxL][idxR] = Math.max(maxDp[idxL][idxR], maxLeft + maxRight);
			}
		}
	}
}