import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    // GCD를 활용한 최소공배수(LCM) 계산
    static long lcm(BigInteger n, BigInteger m) {
        return (n.multiply(m)).divide(n.gcd(m)).longValue();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        BigInteger n = new BigInteger(tk.nextToken());
        BigInteger m = new BigInteger(tk.nextToken());

        System.out.println(lcm(n, m));

    }
}