fun main() {
    val n = readln().toInt()
    val point = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        point.add(Pair(x, y))
    }
    point.sortWith(compareBy({ it.first }, { it.second }))
    println(point.joinToString("\n") { "${it.first} ${it.second}" })
}