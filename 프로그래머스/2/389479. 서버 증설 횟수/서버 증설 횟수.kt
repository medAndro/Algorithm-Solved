import java.util.*

class Solution {
    fun solution(
        players: IntArray,
        m: Int,
        k: Int,
    ): Int {
        var answer: Int = 0
        val extraServers: Queue<Int> = LinkedList()
        repeat(k) { extraServers.offer(0) }

        players.forEach { player: Int ->
            extraServers.poll()
            val currentServerCount = extraServers.sum()

            val needServerCount = getCurrentExtraServerCount(player, m) - currentServerCount
            if (needServerCount > 0) {
                extraServers.offer(needServerCount)
                answer += needServerCount
            } else {
                extraServers.offer(0)
            }
        }
        return answer
    }

    // 특정 시간의 필요한 전체 증설서버수 반환
    private fun getCurrentExtraServerCount(
        player: Int,
        m: Int,
    ): Int {
        val n = player / m
        return n
    }
}