import java.util.StringTokenizer;

class Solution {

	int playTime;
	int advTime;
	long imos[];
	long sumLogs[];

	public String solution(String play_time, String adv_time, String[] logs) {
		this.playTime = timeStrToSec(play_time);
		this.advTime = timeStrToSec(adv_time);
		this.imos = new long[playTime + 1];
		this.sumLogs = new long[playTime + 1];

		for (String log : logs) {
			StringTokenizer tk = new StringTokenizer(log, "-");
			String start = tk.nextToken();
			String end = tk.nextToken();

			imos[timeStrToSec(start)]++;
			imos[timeStrToSec(end)]--;
		}

		int sum = 0;
		for (int i = 0; i < playTime + 1; i++) {
			sum += imos[i];
			sumLogs[i] = sum;
			if (i > 0) {
				sumLogs[i] += sumLogs[i - 1];
			}
		}

		int answer = 0;
		long maxPrefixSum = sumLogs[advTime - 1];
		for (int i = 1; i <= (playTime - advTime); i++) {
			long curSum = sumLogs[i + advTime - 1] - sumLogs[i - 1];
			if (maxPrefixSum < curSum) {
				maxPrefixSum = curSum;
				answer = i;
			}

		}

		return secToTimeStr(answer);
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