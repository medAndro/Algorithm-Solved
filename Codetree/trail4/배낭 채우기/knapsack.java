import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());
        int[][] dias = new int[n][2];

        for (int i = 0; i < n; i++) {
            tk = new StringTokenizer(br.readLine());
            dias[i][0] = Integer.parseInt(tk.nextToken());
            dias[i][1] = Integer.parseInt(tk.nextToken());
        }
        Arrays.sort(dias, (a, b) -> Integer.compare(a[0], b[0]));

        long[] dp = new long[m + 1];

        for (int[] dia : dias) {
            int diaSize = dia[0];
            int diaCost = dia[1];
            for (int dpNo = m; dpNo >= 0; dpNo--) {
                if (dpNo == diaSize) {
                    if (diaCost > dp[dpNo]) {
                        dp[dpNo] = diaCost;
                    }
                } else if (dpNo > diaSize) {
                    int knapSackCapacity = dpNo - diaSize;
                    if ((dp[knapSackCapacity] + diaCost) > dp[dpNo])
                        dp[dpNo] = dp[knapSackCapacity] + diaCost;
                }
            }
        }
        System.out.println(dp[m]);
    }
}