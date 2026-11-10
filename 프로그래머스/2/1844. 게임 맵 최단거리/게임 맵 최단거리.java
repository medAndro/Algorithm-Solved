import java.util.*;
import java.io.*;

class Solution {
    int[][] maps;
    int nR,nC;
    public int solution(int[][] maps) {
        this.maps = maps;
        nR = maps.length;
        nC = maps[0].length;
        return bfs();
    }
    
    int[] dr = new int[] {1,-1,0,0};
    int[] dc = new int[] {0,0,1,-1};
    
    int bfs(){
        int[][] visit = new int[nR][nC];
        visit[0][0] = 1;
        ArrayDeque<int[]> dq = new ArrayDeque();
        dq.offer(new int[]{0,0});
        
        while(!dq.isEmpty()){
            int[] p = dq.poll();
            int pr = p[0];
            int pc = p[1];
            
            for(int di = 0; di<4; di++){
                int nr = pr+dr[di];
                int nc = pc+dc[di];
                if(!isSafePos(nr, nc) || visit[nr][nc] != 0){
                    continue;
                }
                if(maps[nr][nc] == 0){
                    continue;
                }
                
                visit[nr][nc] = visit[pr][pc]+1;
                if(nr+1 == nR && nc+1 == nC){
                    return visit[nr][nc];
                }
                dq.offer(new int[]{nr,nc});
            
            }
        }
        return -1;
    }
    boolean isSafePos(int r, int c){
        if(r<0 || c<0 || r>=nR || c>=nC){
            return false;
        }
        return true;
    }
}