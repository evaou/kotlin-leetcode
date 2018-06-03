class Solution {
    fun fibo1(n: Int): Int {
        if (n <= 2) {
            return 1
        }

        return fibo1(n-1) + fibo1(n-2)
    }

    fun fibo2(n: Int): Int {
        if (n <= 2) {
            return 1
        }

        var first = 1
        var second = 1
        var num = n
        var result = 0

        while (num > 2) {
            result = first + second
            first = second
            second = result
            num--
        }

        return result
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val n = 9
    var result: Int

    result = sol.fibo1(n)
    println("recursive: %d".format(result))

    result = sol.fibo2(n)
    println("iterative: %d".format(result))
}

