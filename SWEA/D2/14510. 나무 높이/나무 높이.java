import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 나무 높이 시뮬레이션 풀이
public class Solution {
	static int N;
	static int trees[];
	// "남은 나무의 길이"를 "홀수만" 저장, "짝수만" 저장하는 "내림차순" 우선순위 큐
	static PriorityQueue<Integer> oddPq;
	static PriorityQueue<Integer> evenPq;
	static int maxTreeLen;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			trees = new int[N];
			oddPq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
			evenPq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
			maxTreeLen = 0;

			// 원본 나무 높이와 최대 높이 초기화
			StringTokenizer tk = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				trees[i] = Integer.parseInt(tk.nextToken());
				maxTreeLen = Math.max(trees[i], maxTreeLen);
			}

			// 우선순위 큐 초기화
			for (int i = 0; i < N; i++) {
				if (trees[i] == maxTreeLen) {
					continue;
				}

				int remainLen = maxTreeLen - trees[i];

				if (isOdd(remainLen)) {
					oddPq.offer(remainLen);
				} else {
					evenPq.offer(remainLen);
				}

			}

			// 시뮬레이션
			int day = 0;
			while (!oddPq.isEmpty() || !evenPq.isEmpty()) {
				day++;
				if (isOdd(day)) {
					// 1 자라는 날
					if (oddPq.isEmpty()) {
						// 짝수큐의 사이즈가 2 이상이거나(합이 최소 4이상) 4이상의 나무들만 남은 경우
						if (!evenPq.isEmpty() && (evenPq.size() >= 2 || evenPq.peek() >= 4)) {
							oddPq.offer(evenPq.poll() - 1);
						}

					} else {
						int pollOddTree = oddPq.poll() - 1;
						if (pollOddTree > 0) {
							evenPq.offer(pollOddTree);
						}
					}

				} else {
					// 2 자라는 날
					if (evenPq.isEmpty()) {
						// 홀수큐에 3이상인 값이 남아있는경우
						if (!oddPq.isEmpty() && oddPq.peek() >= 3) {
							oddPq.offer(oddPq.poll() - 2);
						}

					} else {
						int pollEvenTree = evenPq.poll() - 2;
						if (pollEvenTree > 0) {
							evenPq.offer(pollEvenTree);
						}
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(day).append("\n");
		}
		System.out.print(sb);
	}

	static boolean isOdd(int val) {
		return val % 2 != 0;
	}
}