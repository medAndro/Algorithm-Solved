import java.util.ArrayList;

class Solution {
	public int solution(String s) {
		int answer = s.length();
		int len = s.length();

		for (int i = 1; i <= (int) len / 2; i++) {
			ArrayList<String> split = new ArrayList<>();

			int idx = 0;
			while (idx < len) {
				split.add(s.substring(idx, Math.min(len, idx + i)));
				idx += i;
			}

			ArrayList<Integer> compressedLen = new ArrayList<>();
			int compressedCnt = 0;
			for (int j = 0; j < split.size(); j++) {
				if (j != 0) {
					if (split.get(j - 1).equals(split.get(j))) {
						compressedCnt++;
					} else {
						if (compressedCnt > 0) {
							compressedLen.add(++compressedCnt);
							compressedCnt = 0;
						}

					}
				}
			}
			if (compressedCnt > 0) {
				compressedLen.add(++compressedCnt);
				compressedCnt = 0;
			}

			int compressedLength = s.length();

			for (int comp : compressedLen) {
				compressedLength -= (i * comp);
				compressedLength += (Integer.toString(comp).length() + i);
			}

			answer = Math.min(answer, compressedLength);

		}

		return answer;
	}
}