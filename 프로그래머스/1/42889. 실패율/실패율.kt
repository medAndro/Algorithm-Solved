class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {
        var answer = mutableListOf<Pair<Int, Double>>()
        val stageCnt = IntArray(N+1)
        
        for(i in stages.indices){
            stageCnt[stages[i]-1]++
        }
        
        var clear = 0
        var people = stages.size.toDouble()
        for(i in 0 until N){
            answer.add(i+1 to stageCnt[i]/people)
            people -= stageCnt[i]
        }
        
        answer.sortWith(
        compareBy({-it.second}, {it.first})
        )

        return answer.map{it.first}.toIntArray()
    }
}