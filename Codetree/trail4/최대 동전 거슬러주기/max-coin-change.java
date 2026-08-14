import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());
        int[] coins = new int[n];
        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(tk.nextToken());
        }
        Arrays.sort(coins);

        long[] dp = new long[m + 1];

        for (int coin : coins) {
            for (int dpNo = 0; dpNo <= m; dpNo++) {

                if (dpNo == coin && dp[dpNo] == 0) {
                    dp[dpNo] = 1;
                } else if (dpNo > coin) {
                    int pocketCapacity = dpNo - coin;
                    if (dp[pocketCapacity] != 0 && ((dp[pocketCapacity] + 1) > dp[dpNo])) {
                        dp[dpNo] = dp[pocketCapacity] + 1;
                    }
                }
            }
        }
        if (dp[m] == 0) {
            dp[m] = -1;
        }
        System.out.println(dp[m]);
    }
}