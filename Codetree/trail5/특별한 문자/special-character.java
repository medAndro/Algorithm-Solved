import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] cnt = new int[26];
        ArrayDeque<Character> candidate = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int cIdx = c - 'a';
            if (cnt[cIdx] == 0) {
                cnt[cIdx]++;
                candidate.offer(c);
            } else {
                candidate.remove(c);
            }
        }

        if (candidate.size() == 0) {
            System.out.println("None");
        } else {
            System.out.println(candidate.poll());
        }

    }
}