
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			br.readLine(); // 테케 번호 버리기

			StringTokenizer tk = new StringTokenizer(br.readLine());

			ArrayDeque<Integer> dq = new ArrayDeque<>(8);

			for (int i = 0; i < 8; i++) {
				int val = Integer.parseInt(tk.nextToken());
				dq.offer(val);
			}

			int rmVal = 0;
			while (true) {
				int pollNum = dq.poll();

				int newNum = pollNum - (rmVal++) % 5 - 1;

				if (newNum < 0) {
					newNum = 0;
				}

				dq.offer(newNum);
				if (newNum == 0) {
					break;
				}

			}

			StringBuilder sb = new StringBuilder();

			sb.append("#");
			sb.append(test_case);
			sb.append(" ");
			while (!dq.isEmpty()) {
				sb.append(dq.poll());
				sb.append(" ");
			}

			System.out.println(sb.toString());
		}

	}
}
