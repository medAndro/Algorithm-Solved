import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static final long prime = 1234567891;
	static long[] f = new long[1000001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		f[0] = 1L;
		for (int i = 1; i <= 1000000; i++) {
			f[i] = f[i - 1] * i % prime;
		}

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(tk.nextToken());
			int r = Integer.parseInt(tk.nextToken());

			// nCr == (nPr / r!) == (n! / r!(n-r)!)
			// (n! / r!(n-r)!) % prime == (n! * (r!(n-r)!) ^ (prime-2) ) % prime
			// == ((n! % prime) * (r! %prime * (n-r)!% prime) ^ (prime-2) ) % prime
			long answer = (f[n] * powerMod((f[r] * f[(n - r)] % prime), prime - 2)) % prime;
			sb.append("#" + test_case + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}

	public static long powerMod(long c, long n) {
		if (n == 0)
			return 1L;
		if (n == 1)
			return c % prime;
		long x = powerMod(c, n / 2) % prime;

		if (n % 2 == 0) {
			return (x * x) % prime;
		} else {
			return ((x * x) % prime * (c % prime)) % prime;
		}
	}
}