import java.util.concurrent.atomic.AtomicInteger

private const val DAY_01_TXT = "Day01"

fun main() {
    val input = readInput(DAY_01_TXT).map { it.toInt() }
    println("Value for part one: " + partOne(input))
    println("Value for part two: " + partTwo(input))
}

fun partTwo(input: List<Int>): Int {
    val windowed = input.windowed(3).map { it.sum() }
    return partOne(windowed)
}

fun partOne(input: List<Int>): Int {
    val amountOfIncreased = AtomicInteger(0)
    var prevVal: Int? = null

    input.forEach { line ->
        if (prevVal != null && isIncreased(prevVal!!, line)) {
            amountOfIncreased.incrementAndGet()
        }
        prevVal = line
    }
    return amountOfIncreased.get()
}

fun isIncreased(prev: Int, current: Int): Boolean {
    return prev < current
}
