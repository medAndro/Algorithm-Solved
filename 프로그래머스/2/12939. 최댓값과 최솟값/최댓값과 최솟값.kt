class Solution {
    fun solution(s: String): String {
        val nums = s.split(' ').map { c -> c.toInt() }

        return "${nums.minOrNull()} ${nums.maxOrNull()}"
    }
}
