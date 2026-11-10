import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] priorities, int location) {
        ArrayDeque<int []> dq = new ArrayDeque();
        int[] pSort = new int[priorities.length];
        
        for(int i = 0; i<priorities.length; i++ ){
            pSort[i] = priorities[i];
            dq.offer(new int[]{ priorities[i], i});
        }
        Arrays.sort(pSort);
        
        
        ArrayDeque<Integer> sortQ = new ArrayDeque();
        
        for(int i = priorities.length -1; i>=0; i--){
            sortQ.offer(pSort[i]);
        }
        
    
        
        int answer = 0;
        
        while(!dq.isEmpty()){
            int[] p = dq.poll();
            if(sortQ.peek().equals(p[0])){
                answer++;
                sortQ.poll();
                if(p[1] == location){
                    break;
                }
            }else{
                dq.offer(p);
            }
        }
        
        return answer;
    }
}