import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	static long pows[] = new long[1000001];
	int topWriteIdx = 0;

	public static void main(String args[]) throws Exception {
		for (long i = 1; i <= 1000000; i++) {
			pows[(int) i] = i * i;
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			long N = Long.parseLong(br.readLine());

			long answer = 0;
			while (N != 2L) {
				long i = (long) Math.sqrt(N);
				for (; i <= 1000000; i++) {
					long pow = pows[(int) i];
					if (pow >= N) {
						answer += pow - N + 1;
						N = (int) i;
						break;
					}
				}
			}
			sb.append("#" + test_case + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}
}