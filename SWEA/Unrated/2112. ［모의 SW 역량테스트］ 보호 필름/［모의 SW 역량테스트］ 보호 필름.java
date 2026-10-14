import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int D, W, K;
	static int[] bits;
	static int fullBit;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			D = Integer.parseInt(tk.nextToken());
			W = Integer.parseInt(tk.nextToken());
			K = Integer.parseInt(tk.nextToken());

			bits = new int[D];
			answer = D;

			fullBit = (1 << W) - 1;

			for (int r = 0; r < D; r++) {
				String lineStr = br.readLine();
				for (int c = 0; c < W * 2 - 1; c += 2) {
					switch (lineStr.charAt(c)) {
					case '1':
						bits[r] |= 1 << c / 2;
						break;
					}
				}
			}
			dfs(0, 0);
			sb.append("#" + test_case + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}

	static void dfs(int depth, int injectCnt) {
		if (depth >= D) {
			boolean isPass = true;
			for (int c = 0; c < W; c++) {
				int cnt = 1;
				int before = bits[0] & 1 << c;
				for (int r = 1; r < D; r++) {
					if (before != (bits[r] & 1 << c)) {
						before = (bits[r] & 1 << c);
						cnt = 1;
					} else {
						cnt++;
					}
					if (cnt >= K) {
						break;
					}
				}
				if (cnt < K) {
					isPass = false;
					break;
				}
			}
			if (isPass) {
				answer = Math.min(answer, injectCnt);
			}

			return;
		}

		if (injectCnt >= answer)
			return;
		int b = bits[depth];
		bits[depth] = fullBit;
		dfs(depth + 1, injectCnt + 1);
		bits[depth] = 0;
		dfs(depth + 1, injectCnt + 1);
		bits[depth] = b;
		dfs(depth + 1, injectCnt);
	}
}