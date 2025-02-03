fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val words = mutableMapOf<String, Int>()

    for (i in 1..n) {
        val word = readln()
        if (word.length < m) {
            continue
        }
        words[word] = words.getOrDefault(word, 0) + 1
    }
    val sortedWords = words.keys.sortedWith(
        compareByDescending<String> { words[it] }  // 등장 횟수 내림차순
            .thenByDescending { it.length }        // 단어 길이 내림차순
            .thenBy { it }                         // 알파벳 순
    )

    println(sortedWords.joinToString("\n"))
}