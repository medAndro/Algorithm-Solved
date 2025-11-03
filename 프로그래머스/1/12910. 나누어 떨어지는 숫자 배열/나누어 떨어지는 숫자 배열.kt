class Solution {
    fun solution(arr: IntArray, divisor: Int): IntArray {
        var answer= mutableListOf<Int>()
        
        for(i in arr.indices){
            if(arr[i]%divisor == 0){
                answer.add(arr[i])
            }
        }
        
        if(answer.isEmpty()){
            answer.add(-1)
        }
        
        return answer.sorted().toIntArray()
    }
}