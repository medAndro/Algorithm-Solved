import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> pMap = new HashMap();
        HashMap<String, Integer> cMap = new HashMap();
        
        for(String p : participant){
            Integer i = pMap.get(p);
            if(i == null){
                pMap.put(p, 1);
            }else{
                pMap.put(p, i + 1);
            }
        }
    
        
        for(String c : completion){
            Integer i = cMap.get(c);
            if(i == null){
                cMap.put(c, 1);
            }else{
                cMap.put(c, i + 1);
            }
        }
        
        for(String p : participant){
            Integer getP = pMap.get(p);
            Integer getC = cMap.get(p);
            
            if(getC == null || getP == getC+1){
                return p;
            }
        }
        return "";
    }
}