import java.util.*;
import java.util.HashMap;

class Solution {
	public int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		HashMap<String, ArrayList<Integer>> map = new HashMap<>();

		for (String s : info) {
			StringTokenizer tk = new StringTokenizer(s);
			String[] cond = new String[4];
			for (int i = 0; i < 4; i++) {
				cond[i] = tk.nextToken();
			}
			int score = Integer.parseInt(tk.nextToken());

			for (int mask = 0; mask < 16; mask++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < 4; j++) {
					if ((mask & (1 << j)) != 0) {
						sb.append("-|");
					} else {
						sb.append(cond[j] + "|");
					}
				}
				String key = sb.toString();

				if (!map.containsKey(key)) {
					map.put(key, new ArrayList<Integer>());
				}
				map.get(key).add(score);
			}
		}

		for (ArrayList<Integer> scores : map.values()) {
			Collections.sort(scores);
		}

		int idx = 0;
		for (String s : query) {
			StringTokenizer tk = new StringTokenizer(s);
			StringBuilder sb = new StringBuilder();

			int cnt = 0;
			while (cnt < 4) {
				String cond = tk.nextToken();
				if (!cond.equals("and")) {
					sb.append(cond + "|");
					cnt++;
				}
			}
			String qKey = sb.toString();
			int qVal = Integer.parseInt(tk.nextToken());

			ArrayList<Integer> appiler = map.get(qKey);

			if (appiler == null) {
				idx++;
				continue;

			}

			answer[idx] = appiler.size() - lowerBound(appiler, qVal); // 점수 이상이 처음 나오는 인덱
			idx++;

		}

		return answer;
	}

	int lowerBound(ArrayList<Integer> scores, int target) {
		int lo = 0;
		int hi = scores.size();

		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (scores.get(mid) >= target) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		return lo;
	}

}