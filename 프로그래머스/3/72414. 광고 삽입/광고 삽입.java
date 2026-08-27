import java.util.StringTokenizer;

class Solution {

	int playTime;
	int advTime;
	int imos[];
	int sums[];

	long tree[];

	public String solution(String play_time, String adv_time, String[] logs) {
		this.playTime = timeStrToSec(play_time);
		this.advTime = timeStrToSec(adv_time);
		this.imos = new int[playTime + 1];
		this.sums = new int[playTime + 1];
		this.tree = new long[playTime * 4];

		for (String log : logs) {
			StringTokenizer tk = new StringTokenizer(log, "-");
			String start = tk.nextToken();
			String end = tk.nextToken();

			imos[timeStrToSec(start)]++;
			imos[timeStrToSec(end)]--;
		}

		int sum = 0;
		for (int i = 0; i <= playTime; i++) {
			sum += imos[i];
			sums[i] = sum;
		}

		buildTree(1, 0, playTime - 1);

		long max = 0;
		int answer = 0;

		for (int i = 0; i <= playTime - advTime; i++) {
			long rangeSum = sumRange(i, i + advTime - 1);
			if (max < rangeSum) {
				answer = i;
				max = rangeSum;

			}

		}

		return secToTimeStr(answer);
	}

	void buildTree(int node, int start, int end) {
		if (start == end) {
			tree[node] = sums[start];
			return;
		}

		int mid = (start + end) / 2;

		buildTree(node * 2, start, mid);
		buildTree(node * 2 + 1, mid + 1, end);

		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}

	long sumRange(int start, int end) {
		return sumRangeByTree(1, 0, playTime - 1, start, end);
	}

	long sumRangeByTree(int node, int nStart, int nEnd, int targetStart, int targetEnd) {
		if (targetStart > nEnd || targetEnd < nStart) {
			return 0;
		} else if (targetStart <= nStart && nEnd <= targetEnd) {
			return tree[node];
		} else {
			int nMid = (nStart + nEnd) / 2;
			long leftSum = sumRangeByTree(node * 2, nStart, nMid, targetStart, targetEnd);
			long rightSum = sumRangeByTree(node * 2 + 1, nMid + 1, nEnd, targetStart, targetEnd);
			return leftSum + rightSum;
		}
	}

	int timeStrToSec(String time) {
		StringTokenizer tk = new StringTokenizer(time, ":");
		int hh = Integer.parseInt(tk.nextToken());
		int mm = Integer.parseInt(tk.nextToken());
		int ss = Integer.parseInt(tk.nextToken());
		return hh * 3600 + mm * 60 + ss;
	}

	String secToTimeStr(int time) {
		int hh = time / 3600;
		int mm = (time % 3600) / 60;
		int ss = (time % 3600) % 60;
		return String.format("%02d:%02d:%02d", hh, mm, ss);
	}
}
