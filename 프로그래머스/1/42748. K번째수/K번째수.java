import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i<commands.length; i++){
            int[] c = commands[i];
            int[] arr = new int[c[1] - c[0] +1];
            int idx = 0;
            for(int j = c[0]-1; j<c[1];j++ ){
                arr[idx++] = array[j];
            }
            Arrays.sort(arr);
            // System.out.println(Arrays.toString(arr));
            answer[i] = arr[c[2]-1];
                
            
        }
        
        return answer;
    }
}