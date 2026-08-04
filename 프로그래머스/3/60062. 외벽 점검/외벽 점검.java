
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	public int solution(int n, int[] weak, int[] dist) {
		dist = Arrays.stream(dist).map(i -> -i).sorted().map(i -> -i).toArray();

		int[] weakDist = new int[weak.length];
		for (int i = 0; i < weak.length - 1; i++) {
			weakDist[i] = weak[(i + 1) % weak.length] - weak[i];
		}
		weakDist[weak.length - 1] = n - weak[weak.length - 1] + weak[0];

		int max = 0;
		int maxIdx = 0;

		for (int i = 0; i < weakDist.length; i++) {
			if (weakDist[i] > max) {
				maxIdx = i;
				max = weakDist[i];

			}
		}

		int[] flatWeakDist = new int[weak.length - 1];

		int nextIdx = 0;
		for (int i = maxIdx + 1, idx = 0; i < weak.length; i++, idx++) {
			flatWeakDist[idx] = weakDist[i];
			nextIdx++;
		}

		for (int i = 0, idx = nextIdx; i < maxIdx; i++, idx++) {
			flatWeakDist[idx] = weakDist[i];
		}

		int answer = 1;

		while (true) {
			List<Integer> weaks = new ArrayList<>();
			int sum = 0;
			for (int f : flatWeakDist) {
				if (f == 0 && sum > 0) {
					weaks.add(sum);
					sum = 0;
				} else {
					sum += f;
				}
			}
			weaks.add(sum);
			weaks.sort((i, j) -> Integer.compare(j, i));

			boolean isFail = false;
			for (int i = 0; i < weaks.size(); i++) {
				if (weaks.get(i) > dist[i]) {
					isFail = true;
					break;
				}
			}
			if (isFail) {
				int nextRemoveIdx = 0;
				int weakMax = 0;
				for (int i = 0; i < flatWeakDist.length; i++) {
					if (flatWeakDist[i] > weakMax) {
						weakMax = flatWeakDist[i];
						nextRemoveIdx = i;
					}
				}
				flatWeakDist[nextRemoveIdx] = 0;
				answer++;

			} else {
				break;
			}
		}

		return answer;
	}
}
