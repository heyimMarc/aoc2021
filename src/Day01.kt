import java.util.concurrent.atomic.AtomicInteger

private const val DAY_01_TXT = "Day01"

fun main() {
    val input = readInput(DAY_01_TXT)
    val amountOfIncreased = AtomicInteger(0)
    var prevVal: Int? = null

    input.forEach { line ->
        if (prevVal != null && isIncreased(prevVal!!, line.toInt())) {
            amountOfIncreased.incrementAndGet()
        }
        prevVal = line.toInt()

    }
    println(amountOfIncreased)
}

fun isIncreased(prev: Int, current: Int): Boolean {
    return prev < current
}
