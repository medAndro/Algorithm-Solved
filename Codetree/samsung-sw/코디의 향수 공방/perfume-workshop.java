
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int[] perfumes = new int[1101];
    static int[] pValCnt = new int[3001];
    static int lastPerfumeNo;
    static int n;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        StringTokenizer tk;
        StringBuilder sb = new StringBuilder();
        for (int qIdx = 0; q > qIdx; qIdx++) {
            tk = new StringTokenizer(br.readLine());

            switch (Integer.parseInt(tk.nextToken())) {
            case 1:
                n = Integer.parseInt(tk.nextToken());
                for (int pNo = 1; pNo <= n; pNo++) {
                    int val = Integer.parseInt(tk.nextToken());
                    perfumes[pNo] = val;
                    pValCnt[val]++;
                }
                lastPerfumeNo = n;

                break;
            case 2:
                lastPerfumeNo++;
                int newPerfumeVal = Integer.parseInt(tk.nextToken());
                perfumes[lastPerfumeNo] = newPerfumeVal;
                pValCnt[newPerfumeVal]++;

                break;
            case 3:
                int removeIdx = Integer.parseInt(tk.nextToken());

                if (removeIdx > lastPerfumeNo || removeIdx <= 0 || perfumes[removeIdx] <= 0) {
                    sb.append("-1\n");
                } else {
                    int removeValue = perfumes[removeIdx];
                    sb.append(removeValue + "\n");
                    perfumes[removeIdx] = -1;
                    pValCnt[removeValue]--;
                }

                break;
            case 4:
                int target = Integer.parseInt(tk.nextToken());

                int[] knapSacks = new int[target + 1];

                for (int pValue = 1; pValue <= 3000; pValue++) {
                    if (pValCnt[pValue] == 0) {
                        continue;
                    }

                    for (int dpNo = 0; dpNo <= target; dpNo++) {
                        if (dpNo == pValue) {
                            knapSacks[dpNo] = 1;
                        } else if (dpNo > pValue) {
                            int capacity = dpNo - pValue;
                            if (knapSacks[capacity] != 0
                                    && ((knapSacks[dpNo] > knapSacks[capacity] + 1) || knapSacks[dpNo] == 0)) {
                                knapSacks[dpNo] = knapSacks[capacity] + 1;
                            }
                        }
                    }
                }
                if (knapSacks[target] == 0) {
                    knapSacks[target] = -1;
                }
                sb.append(knapSacks[target] + "\n");

                break;
            case 5:
                target = Integer.parseInt(tk.nextToken());
                Long perfumeCnt = 0L;

                long[] t_m_ValCnt = new long[6001]; // idx가 탑 미들 합친 향도, value가 해당 향도를 가진 조합
                for (int topIdx = 1; topIdx <= 3000; topIdx++) {
                    if (pValCnt[topIdx] <= 0) {
                        continue;
                    }

                    for (int middleIdx = 1; middleIdx <= 3000; middleIdx++) {
                        if (pValCnt[middleIdx] <= 0) {
                            continue;
                        }

                        t_m_ValCnt[topIdx + middleIdx] += pValCnt[topIdx] * pValCnt[middleIdx];
                    }
                }

                long[] suffixSum = new long[6002];

                for (int sum = 6000; sum >= 1; sum--) {
                    suffixSum[sum] = suffixSum[sum + 1] + t_m_ValCnt[sum];
                }

                for (int bottomIdx = 1; bottomIdx <= 3000; bottomIdx++) {
                    if (pValCnt[bottomIdx] <= 0) {
                        continue;
                    }

                    int needed = Math.max(1, target - bottomIdx);

                    if (needed <= 6000) {
                        perfumeCnt += (long) pValCnt[bottomIdx] * suffixSum[needed];
                    }

                }
                sb.append(perfumeCnt + "\n");
                break;
            }
        }
        System.out.println(sb.toString());

    }
}
