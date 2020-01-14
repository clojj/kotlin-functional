
val xMemoized: Int by lazy { expensiveOp() }
val xNotMemoized = { expensiveOp() }

fun useitMemoized() =
    when {
        xMemoized > 10 -> "hi"
        xMemoized == 0 -> "zero"
        else -> ("lo")
    }

fun useitNotMemoized() =
    when {
        xNotMemoized() > 10 -> "hi"
        xNotMemoized() == 0 -> "zero"
        else -> ("lo")
    }

fun expensiveOp(): Int {
    println("very costly...")
    return 0
}

useitMemoized()
useitNotMemoized()

