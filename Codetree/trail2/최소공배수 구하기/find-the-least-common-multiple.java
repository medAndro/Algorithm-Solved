import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int lcm(int n, int m) {
        int cnt = 1;
        int max = Math.max(n, m);
        int min = Math.min(n, m);
        while (true) {
            if ((max * cnt) % min == 0) {
                return max * cnt;
            }
            cnt++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());

        System.out.println(lcm(n, m));

    }
}