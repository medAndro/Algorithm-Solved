import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			BigInteger A = new BigInteger(tk.nextToken());
			BigInteger B = new BigInteger(tk.nextToken());

			System.out.println(String.format("#%d %s", test_case, A.add(B).toString()));
		}

	}
}