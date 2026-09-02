import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine()); // 정점의 수

			int answer = 1;
			for (int i = 1; i <= N; i++) {
				String readStr = br.readLine();
				if (answer == 1) {
					StringTokenizer tk = new StringTokenizer(readStr);

					tk.nextToken();
					char val = tk.nextToken().charAt(0);
					boolean isNumericVal = isNumericChar(val);

					boolean isLeaf = true;
					if (tk.hasMoreTokens()) {
						isLeaf = false;
					}

					if ((isLeaf && !isNumericVal) || (!isLeaf && isNumericVal)) {
						answer = 0;
					}
				}
			}

			sb.append("#");
			sb.append(test_case);
			sb.append(" ");
			sb.append(answer);
			sb.append("\n");

		}
		System.out.println(sb.toString());
	}

	static boolean isNumericChar(char input) {
		if ('0' <= input && input <= '9') {
			return true;
		}
		return false;
	}

}
