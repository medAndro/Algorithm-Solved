fun main() {
    val input = mutableListOf<String>()
    var targetNumber: Int? = null
    for (i in 1..3) {
        input.add(readln())
    }
    input.forEachIndexed { index, s ->
        if (s.toIntOrNull() != null) {
            targetNumber = s.toInt() + (4 - (index + 1))
        }
    }
    if (targetNumber == null) {
        targetNumber = getTargetNumber(input)
    }
    println(getFizzBuzz(targetNumber!!))
}

fun getFizzBuzz(i: Int): String {
    if (i % 3 == 0 && i % 5 == 0) {
        return "FizzBuzz"
    }
    if (i % 3 == 0) {
        return "Fizz"
    }
    if (i % 5 == 0) {
        return "Buzz"
    }
    return i.toString()
}

// 3개중 하나는 정수라 잉여 메소드였다는...
fun getTargetNumber(input: MutableList<String>): Int {
    var index = 0
    while (true) {
        index += 1
        if (input[0] == getFizzBuzz(index)) {
            if (input[1] == getFizzBuzz(index + 1) && input[2] == getFizzBuzz(index + 2)) {
                return index + 3
            }
        }
    }
}