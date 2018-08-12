class Solution {
    fun isUgly(num: Int): Boolean {
        if (num <= 0) return false

        var n = num

        while (n % 2 == 0) {
            n /= 2
        }

        while (n % 3 == 0) {
            n /= 3
        }

        while (n % 5 == 0) {
            n /= 5
        }

        return (n == 1)
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val n = 14
    val result: Boolean

    result = sol.isUgly(n)
    println(result)
}

