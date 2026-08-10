import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tk.nextToken());
        m = Integer.parseInt(tk.nextToken());

        int[][] map = new int[n][n];

        for (int r = 0; r < n; r++) {
            tk = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                map[r][c] = Integer.parseInt(tk.nextToken());
            }
        }
        int happyArrCnt = 0;
        for (int r = 0; r < n; r++) {
            if (isHappy(map[r])) {
                happyArrCnt++;
            }
        }

        int[] colArr = new int[n];
        for (int c = 0; c < n; c++) {
            for (int i = 0; i < n; i++) {
                colArr[i] = map[i][c];
            }
            if (isHappy(colArr)) {
                happyArrCnt++;
            }
        }
        System.out.println(happyArrCnt);
    }

    public static boolean isHappy(int[] arr) {
        int dupCnt = 0;
        int prev = -1;
        for (int a : arr) {
            if (prev == a) {
                dupCnt++;
            } else {
                prev = a;
                dupCnt = 1;
            }
            if (dupCnt == m) {
                return true;
            }
        }
        return false;
    }
}