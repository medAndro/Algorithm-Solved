
class Solution {
    fun solution(answers: IntArray): IntArray {
        val answerCount = IntArray(3)
        val p1Answer = intArrayOf(1, 2, 3, 4, 5)
        val p2Answer = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
        val p3Answer = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        
        for(i in answers.indices){
            val ans = answers[i]
            
            if(ans == p1Answer[i%p1Answer.size]){
                answerCount[0]++
            }
            if(ans == p2Answer[i%p2Answer.size]){
                answerCount[1]++
            }
            if(ans == p3Answer[i%p3Answer.size]){
                answerCount[2]++
            }
        }
        
        val maxAnswerCnt = answerCount.maxOrNull()
        println(maxAnswerCnt)
        val answer:MutableList<Int> = mutableListOf()
         answerCount.toList().mapIndexed{ i, n ->
            if(n == maxAnswerCnt){
                 answer.add(i+1)
            }
        }
       
        
        return answer.toIntArray()
    }
}