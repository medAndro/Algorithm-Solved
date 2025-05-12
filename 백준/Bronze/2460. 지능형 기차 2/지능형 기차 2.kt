fun main() {
    val readValues = readInput()
    println(findMaxPeople(readValues))
}

private fun readInput(): List<Pair<Int, Int>> =
    (1..10).map {
        val read = readln().split(" ")
        Pair(read[0].toInt(), read[1].toInt())
    }

private fun findMaxPeople(values: List<Pair<Int, Int>>): Int {
    var max = 0
    var currentPeople = 0
    values.forEach { it ->
        currentPeople -= it.first
        currentPeople += it.second
        if (max < currentPeople) max = currentPeople
    }
    return max
}
