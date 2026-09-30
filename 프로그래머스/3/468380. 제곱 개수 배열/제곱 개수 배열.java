import java.util.Arrays;

class Solution {
	static int[] arr;
	static long l;
	static long r;
	static long winLen;
	static long k;

	public long[] solution(int[] arr, long l, long r) {
		Solution.arr = arr;
		Solution.l = l;
		Solution.r = r;
		Solution.winLen = r - l + 1;

		k = Q1();
		long c = Q2();
		long[] answer = { k, c };
		return answer;
	}

	static long Q1() {
		long curIdx = 0;
		long lPrefixSum = 0;
		boolean isLPrefixEnd = false;
		long rPrefixSum = 0;

		for (int i = 0; i < arr.length; i++) {
			long num = arr[i];
			curIdx += num;
			if (!isLPrefixEnd) {
				lPrefixSum += (num * num);
			}
			rPrefixSum += (num * num);

			if (!isLPrefixEnd && curIdx >= (l - 1)) {
				long gap = curIdx - (l - 1);
				lPrefixSum -= gap * num;
				isLPrefixEnd = true;
			}
			if (curIdx >= r) {
				long gap = curIdx - r;
				rPrefixSum -= gap * num;
				break;
			}
		}
		return rPrefixSum - lPrefixSum;
	}

	static long Q2() {
		int sIdx = 0;
		int sInnerIdx = 0;
		int eIdx = 0;
		int eInnerIdx = 0;

		long windowSum = 0;
		long windowCnt = 0;

		long ans = 0;

		// 초기 윈도우 설정
		while (true) {
			if ((arr[(int) eIdx] + windowCnt) <= winLen) {
//				System.out.println(arr[eIdx]);
				windowCnt += arr[eIdx];
				windowSum += (long) arr[eIdx] * (long) arr[eIdx];
				eIdx++;
			} else {
				long gap = winLen - windowCnt;
				windowCnt += gap;
				windowSum += arr[(int) eIdx] * gap;
				eInnerIdx = (int) gap;
				break;
			}
			if(windowCnt == winLen) {
				break;
			}
		}
		
		if(windowSum == k) {
			ans++;
		}
//		System.out.println(windowSum + " " + windowCnt);
//
//		System.out.println(arr.length + " " + arr[arr.length - 1]);
		// 윈도우 순회
		while (eIdx < arr.length ) {
			int moveDelta = Math.min(arr[sIdx] - sInnerIdx, arr[eIdx] - eInnerIdx);
//			System.out.println("md :" + moveDelta);

			if (arr[sIdx] == arr[eIdx] && windowSum == k) {
				ans += moveDelta;
			} else if (arr[sIdx] != arr[eIdx]) {
				int valDelta = -arr[sIdx] + arr[eIdx];
				long remain = k - windowSum;

				if (remain % valDelta == 0 && (remain / valDelta) <= moveDelta && (remain / valDelta) > 0) {
					ans++;
				}

				windowSum -= (long) arr[sIdx] * (long) moveDelta;
				windowSum += (long) arr[eIdx] * (long) moveDelta;
			}

			sInnerIdx += moveDelta;
			eInnerIdx += moveDelta;

			if (sInnerIdx == arr[sIdx]) {
				sInnerIdx = 0;
				sIdx++;
			}

			if (eInnerIdx == arr[eIdx]) {
				eInnerIdx = 0;
				eIdx++;
			}
		}

		return ans;
	}
}
