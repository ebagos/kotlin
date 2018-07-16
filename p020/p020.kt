/*
n × (n - 1) × ... × 3 × 2 × 1 を n! と表す.

例えば, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800 となる.
この数の各桁の合計は 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27 である.

では, 100! の各桁の数字の和を求めよ.
*/

fun factorial(n: Long): Long {
    var rc = 1L
    for (i in n downTo 1) {
        rc *= i
        println(rc)
    }
    return rc
}

fun nsum(n: Long): Long {
    var sum = 0L
    var m = n
    while (m > 0) {
        sum += (m % 10L)
        m /= 10L
    }
    return sum
}

tailrec fun factorial(n: Long, rc: Long): Long {
    if (n == 0L) return rc
    return factorial(n - 1, rc * n)
}

tailrec fun nsum(n: Long, sum: Long): Long {
    if (n == 0L) return sum
    return nsum(n / 10L, sum + n % 10L)
}

fun main(args: Array<String>) {
    println("100 => ${factorial(100L)}")
    println("100 => ${nsum(factorial(100L))}")

    println("100 => ${factorial(100L, 1L)}")
    println("100 => ${nsum(factorial(100L, 1L), 0)}")
}