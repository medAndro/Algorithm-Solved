import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, S;
	static int[] arr;
	static int answer = (int) 1e9;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tk.nextToken());
		S = Integer.parseInt(tk.nextToken());

		tk = new StringTokenizer(br.readLine());
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(tk.nextToken());
		}
		int l = 0;
		int r = 0;

		int sum = 0;
		int len = 0;
		for (; r < N; r++) {
			sum += arr[r];
			len++;
			for (; l <= r; l++) {
				if (sum < S) {
					break;
				} else {
					answer = Math.min(len, answer);
					sum -= arr[l];
					len--;
				}
			}
		}

		if (answer == (int) 1e9) {
			System.out.println(0);
		} else {
			System.out.println(answer);
		}
	}
}
