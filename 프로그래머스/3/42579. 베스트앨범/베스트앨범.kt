class Solution {
    fun solution(
        genres: Array<String>,
        plays: IntArray,
    ): IntArray {
        val grouped: Map<String, List<Pair<Int, Int>>> =
            genres.indices.groupBy { genres[it] }.mapValues { (genre, indices) ->
                indices.map { plays[it] to it }
            }
        val sortedGenres =
            grouped
                .mapValues { (_, values) -> values.sumOf { it.first } }
                .entries
                .sortedByDescending { it.value }
                .map { it.key }

        val answer =
            sortedGenres.flatMap {
                grouped[it]!!
                    .sortedByDescending { it.first }
                    .take(2)
                    .map { it.second }
            }

        return answer.toIntArray()
    }
}