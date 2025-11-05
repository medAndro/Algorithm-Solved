class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = intArrayOf()
        for(i in 1..yellow){
            if (yellow%i!=0) continue
            
            if((i*2)+(yellow/i*2)+4 == brown){
                return listOf(i+2, yellow/i+2).sortedDescending().toIntArray()
                break
            }
        }
        return answer
    }
}