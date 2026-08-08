import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static public Knight[][] knightMap;
    static public int[][] objMap;
    static public ArrayList<Knight> knights;

    static class Knight {
        private int[] locInfo; // 현재 좌상 꼭지점 좌표(행, 열) + 크기정보(행길이, 열길이), length == 4
        private int[][] loc; // 나의 좌표들
        public int hp;
        private int totalDamage;
        private int knightNo;

        public Knight(int[] locInfo, int hp, int knightNo) {
            super();
            this.locInfo = locInfo;
            this.hp = hp;
            this.loc = new int[locInfo[2] * locInfo[3]][2];
            this.knightNo = knightNo;
        }

        public int[][] getLoc() {
            int idx = 0;
            for (int r = 0; r < locInfo[2]; r++) {
                for (int c = 0; c < locInfo[3]; c++) {
                    loc[idx][0] = r + locInfo[0];
                    loc[idx++][1] = c + locInfo[1];
                }
            }
            return loc;
        }

        public boolean isDead() {
            return 0 >= hp;
        }

        // d : 0,1,2,3 상우하좌, 1칸이동
        public void move(int d) {
            if (this.isDead()) {
                return;
            }
            Set<Knight> affectedKnights = new HashSet<>();
            affectedKnights.add(this);
            Set<Knight> nextKnights = this.getNextKnights(d);
            if (nextKnights == null) {
                return;
            }
            while (!nextKnights.isEmpty()) {
                Set<Knight> nextNextKnights = new HashSet<>();
                for (Knight k : nextKnights) {
                    Set<Knight> nextS = k.getNextKnights(d);
                    if (nextS == null) {
                        return;
                    } else {
                        nextNextKnights.addAll(nextS);
                    }
                }
                affectedKnights.addAll(nextKnights);
                nextKnights = nextNextKnights;
            }

            for (Knight k : affectedKnights) {
                k.resetKnightMapLoc();
            }
            for (Knight k : affectedKnights) {
                k.commitMove(d);
                if(k!=this) {
                    k.damageApply();
                }
            }
        }

        public void commitMove(int d) {
            locInfo[0] = dr[d] + locInfo[0];
            locInfo[1] = dc[d] + locInfo[1];
            setKnightMapLoc();
        }

        public void setKnightMapLoc() {
            for (int[] l : this.getLoc()) {
                knightMap[l[0]][l[1]] = this;
            }
        }

        public void resetKnightMapLoc() {
            for (int[] l : this.getLoc()) {
                knightMap[l[0]][l[1]] = null;
            }
        }

        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        // 움직임에 영향받는 바로 옆 기사들
        public Set<Knight> getNextKnights(int d) {
            Set<Knight> nextKnights = new HashSet<>();

            for (int[] l : this.getLoc()) {

                int r = l[0] + dr[d];
                int c = l[1] + dc[d];

                if (r < 0 || c < 0 || r >= knightMap.length || c >= knightMap[0].length || objMap[r][c] == 2) {
                    // 벽 만남
                    return null;
                } else {
                    if (knightMap[r][c] != this && knightMap[r][c] != null) {
                        nextKnights.add(knightMap[r][c]);
                    }
                }
            }
            return nextKnights;
        }

        public void damageApply() {
            for (int[] l : this.getLoc()) {
                if (objMap[l[0]][l[1]] == 1) {
                    hp--;
                    totalDamage++;
                }
            }
            if (this.isDead()) {
                resetKnightMapLoc();
            }
        }

        public int getTotalDamage() {
            return totalDamage;
        }

        @Override
        public String toString() {
            return "K no[" + knightNo + "]";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(tk.nextToken());
        int N = Integer.parseInt(tk.nextToken());
        int Q = Integer.parseInt(tk.nextToken());

        knightMap = new Knight[L][L];
        objMap = new int[L][L];
        knights = new ArrayList<Knight>(N);

        // 벽 함정 맵(obj) 초기화
        for (int i = 0; i < L; i++) {
            tk = new StringTokenizer(br.readLine());
            for (int j = 0; j < L; j++) {
                objMap[i][j] = Integer.parseInt(tk.nextToken());
            }
        }

        // 기사 초기화, 내부 값 및 나이트맵에 위치시킴
        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(tk.nextToken());
            int c = Integer.parseInt(tk.nextToken());
            int h = Integer.parseInt(tk.nextToken());
            int w = Integer.parseInt(tk.nextToken());
            int hp = Integer.parseInt(tk.nextToken());
            int[] locInfo = new int[] { r - 1, c - 1, h, w };
            Knight knight = new Knight(locInfo, hp, i + 1);
            knights.add(knight);
            knight.setKnightMapLoc();
        }

        // 왕의 명령 i:기사인덱스, d : 0,1,2,3 상우하좌
        for (int q = 0; q < Q; q++) {
            tk = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(tk.nextToken()) - 1;
            int d = Integer.parseInt(tk.nextToken());
            knights.get(i).move(d);
        }

        int answer = 0;
        for (Knight k : knights) {
            if (!k.isDead()) {
                answer += k.totalDamage;
            }
        }
        System.out.println(answer);
    }
}
