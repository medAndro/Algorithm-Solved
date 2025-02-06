fun main() {
    val n = readln().toInt()
    val extMap = mutableMapOf<String, Int>()

    for (i in 1..n) {
        val (_, extension) = readln().split(".")
        extMap[extension] = extMap.getOrDefault(extension, 0) + 1
    }

    val sortedExtension = extMap.keys.sorted()
    for (ext in sortedExtension) {
        println("$ext ${extMap[ext]}")
    }
}