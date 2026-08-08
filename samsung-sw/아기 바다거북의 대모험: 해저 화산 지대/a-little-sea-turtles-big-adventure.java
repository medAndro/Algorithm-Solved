import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 바다의 한 점
class SeaPoint {
    private SeaObj obj;
    private Turtle turtle;

    public SeaObj getObj() {
        return obj;
    }

    public void setObj(SeaObj obj) {
        this.obj = obj;
    }

    public Turtle getTurtle() {
        return turtle;
    }

    public void setTurtle(Turtle t) {
        this.turtle = t;
    }

    public void removeTurtle() {
        this.turtle = null;
    }

    public boolean isObstacle() {
        if (obj != null && obj.isObstacle) {
            return true;
        }
        if (turtle != null && turtle.isObstacle) {
            return true;
        }
        return false;
    }

    public void addHeat(int extraHeat) {

        if (obj != null && obj instanceof Volcano) {
            ((Volcano) obj).addHeat(extraHeat);
        }
        if (turtle != null) {
            turtle.addHeat(extraHeat);
        }

    }

    @Override
    public String toString() {
        return "SeaPoint [obj=" + obj + ", turtle=" + turtle + "]";
    }

}

//바다의 무언가 
class SeaObj {
    protected int rowIdx;
    protected int colIdx;
    protected Boolean isObstacle;
    protected SeaPoint[][] sea;

    // 우 하 좌 상 순서
    protected int[] dr = { 0, 1, 0, -1 };
    protected int[] dc = { 1, 0, -1, 0 };

    public SeaObj(int rowIdx, int colIdx, SeaPoint[][] sea) {
        super();
        this.rowIdx = rowIdx;
        this.colIdx = colIdx;
        this.isObstacle = false;
        this.sea = sea;
    }

}

//산호
class Coral extends SeaObj {
    public Coral(int rowIdx, int colIdx, SeaPoint[][] sea) {
        super(rowIdx, colIdx, sea);
        super.isObstacle = true;
        sea[rowIdx][colIdx].setObj(this);
    }

}

//거북
class Turtle extends SeaObj {
    private boolean isDead = false;
    private int heat;
    private int turn;
    private int clearTurnNo;

    public Turtle(int rowIdx, int colIdx, SeaPoint[][] sea) {
        super(rowIdx, colIdx, sea);
        super.isObstacle = true;
        heat = 0;
        turn = 0;
        clearTurnNo = -1;
        sea[rowIdx][colIdx].setTurtle(this);
    }

    public boolean isFinish() {
        return isDead || clearTurnNo > -1;
    }

    public void move() {
        if (isDead || clearTurnNo > -1) {
            return;
        }

        turn++;
        // 최단거리 방향탐색
        int[] bfsCount = new int[4];
        for (int i = 0; i < 4; i++) {
            int startR = rowIdx + dr[i];
            int startC = colIdx + dc[i];

            if (startR >= 0 && startC >= 0 && startR < sea.length && startC < sea.length) {
                if (sea[startR][startC].isObstacle()) {
                    continue;
                }

                bfsCount[i] = getMinimumMoveCnt(startR, startC);
            }

        }

        // 최단거리의 방향결정
        int minCount = Integer.MAX_VALUE;
        int minIdx = 0;
        for (int i = 0; i < 4; i++) {
            if (bfsCount[i] != 0) {
                if (bfsCount[i] < minCount) {
                    minIdx = i;
                    minCount = bfsCount[i];
                    continue;
                }
            }
        }

        // 거북이 최단거리 방향 1칸이동
        if (minCount != Integer.MAX_VALUE && minCount > 0) {
            sea[rowIdx][colIdx].removeTurtle();
            rowIdx += dr[minIdx];
            colIdx += dc[minIdx];
            sea[rowIdx][colIdx].setTurtle(this);
        }

        // 안식처 도착
        if (rowIdx + 1 == sea.length && colIdx + 1 == sea.length) {
            clearTurnNo = turn;
            sea[rowIdx][colIdx].removeTurtle();
            return;
        }
        return;
    }

    // 특정 위치에서 최단거리찾기, 0이면 도착 불
    private int getMinimumMoveCnt(int startR, int startC) {
        if ((startR + 1) == sea.length && (startC + 1) == sea.length) {
            return 1;
        }
        int[][] visited = new int[sea.length][sea.length];

        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] { startR, startC });
        visited[startR][startC] = 1;
        while (dq.size() > 0) {
            int[] poll = dq.poll();
            int r = poll[0];
            int c = poll[1];

            for (int i = 0; i < 4; i++) {
                int newR = dr[i] + r;
                int newC = dc[i] + c;

                if (newR >= 0 && newC >= 0 && newR < sea.length && newC < sea.length && visited[newR][newC] == 0) {
                    if (!sea[newR][newC].isObstacle()) {
                        visited[newR][newC] = visited[r][c] + 1;
                        dq.offer(new int[] { newR, newC });

                        if ((newR + 1) == sea.length && (newC + 1) == sea.length) {
                            return visited[newR][newC];
                        }
                    }
                }

            }
        }
        return 0;

    }

    public void addHeat(int extraHeat) {

        if (isDead) {
            return;
        }

        heat += extraHeat;

        if (heat >= 20) {
            isDead = true;
        }
    }

    public int getClearTurnNo() {
        return clearTurnNo;
    }

    public void clearTurn() {
        heat = 0;
    }

    @Override
    public String toString() {
        return "Turtle [isDead=" + isDead + ", turn=" + turn + ", clearTurn=" + clearTurnNo + ", rowIdx=" + rowIdx
                + ", colIdx=" + colIdx + "]";
    }

}

//화산
//10씩 압력 증가, (압력+누적 외부열기)가 임계치 P 이상시 분출
//4방향으로 임계치만큼 분출, 한칸 지날수록 이전칸의 절반의 내림만큼
//분출된 화산이 없을 때까지 반복
//분출 종료후 거북이칸의 열기가 20 이상이면 화석되어 장애물
//매 턴마다 열기 사라짐, 분출된 마그마 압력 0 다른 화산은 유지
class Volcano extends SeaObj {
    private int pressure;
    private final int maxPressure;
    private int heat;
    private boolean isErupted;

    public Volcano(int rowIdx, int colIdx, int maxPressure, SeaPoint[][] sea) {
        super(rowIdx, colIdx, sea);
        this.pressure = 0;
        this.maxPressure = maxPressure;
        this.heat = 0;
        this.isErupted = false;

        sea[rowIdx][colIdx].setObj(this);
    }

    public void addPressure() {
        if (!isErupted) {
            pressure += 10;
            boomIfOverLimit();
        }

    }

    public void addHeat(int extraHeat) {
        if (!isErupted) {
            heat += extraHeat;
            boomIfOverLimit();
        }
    }

    // 화산 분출시에만 작동
    private void boomIfOverLimit() {
        if ((pressure + heat) >= maxPressure) {
            this.isErupted = true;
            int heat = maxPressure;
            sea[rowIdx][colIdx].addHeat(heat);
            for (int i = 0; i < 4; i++) {
                int reducedHeat = heat;
                int r = rowIdx;
                int c = colIdx;

                while (true) {
                    reducedHeat = Math.floorDiv(reducedHeat, 2);

                    r += dr[i];
                    c += dc[i];
                    // 마그마를 특정방향으로 한칸 늘렸을 떄, 바다를 넘어가거나 열기가 식었거나 산호이면 중단.
                    if (r < 0 || c < 0 || r >= sea.length || c >= sea.length || reducedHeat == 0
                            || (sea[r][c].getObj() != null && sea[r][c].getObj() instanceof Coral)) {
                        break;
                    }
                    sea[r][c].addHeat(reducedHeat);
                }

            }

        }
    }

    public void clearTurn() {
        if (isErupted) {
            this.pressure = 0;

        }
        this.heat = 0;
        this.isErupted = false;
    }
}

//m 거북이 수
//n * n 바다의 크기 
//[n-1][n-1] 목표 위치
//최대 100턴이나 모두 화석시 -1

//1. 이동
//1번부터 m번까지 거북이가 최단경로 탐색
//장애물 산호(지도의 1), 거북, 굳은거북
//중복 최단경로시 -> 우, 하, 좌, 상순으로 우선하기
//최단경로 없으면 아예 이동 안함
//목표 도착시 거북이 제거
//거북이는 화산 들어갈 수 있음

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());
        int k = Integer.parseInt(tk.nextToken());

        SeaPoint[][] sea = new SeaPoint[n][n];

        // 포인트 초기화
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                sea[r][c] = new SeaPoint();
            }
        }

        List<Turtle> turtles = new ArrayList<>(m);
        List<Volcano> volcanos = new ArrayList<>(k);

        // 산호초 초기 추가
        for (int r = 0; r < n; r++) {
            tk = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                if (tk.nextToken().equals("1")) {
                    sea[r][c].setObj(new Coral(r, c, sea));
                }
            }
        }

        // 초기 거북이 추가
        for (int i = 0; i < m; i++) {
            tk = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(tk.nextToken());
            int c = Integer.parseInt(tk.nextToken());
            Turtle turtle = new Turtle(r, c, sea);
            turtles.add(turtle);
            sea[r][c].setTurtle(turtle);
        }

        // 초기 화산 추가
        for (int i = 0; i < k; i++) {
            tk = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(tk.nextToken());
            int c = Integer.parseInt(tk.nextToken());
            int p = Integer.parseInt(tk.nextToken());
            Volcano volcano = new Volcano(r, c, p, sea);
            volcanos.add(volcano);
            sea[r][c].setObj(volcano);
        }

        for (int turn = 1; turn <= 100; turn++) {
            turtles.forEach(turtle -> turtle.move());
            volcanos.forEach(volcano -> volcano.addPressure());
            volcanos.forEach(volcano -> volcano.clearTurn());
            turtles.forEach(turtle -> turtle.clearTurn());

            int finishCnt = turtles.stream().mapToInt(turtle -> turtle.isFinish() ? 1 : 0).sum();

            if (finishCnt == turtles.size()) {
                break;
            }
//            System.out.println(turtles);

        }
        turtles.forEach(turtle -> System.out.println(turtle.getClearTurnNo()));
    }
}
