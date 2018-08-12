class Solution {
    fun nthSuperUglyNumber(n: Int, primes: IntArray): Int {
        val uglyNums = IntArray(n){0}
        val primeIdx = IntArray(primes.size){0}
        var minUgly: Int
        var tmpUgly: Int
        var tmpIdx = 0
        var curIdx = 0

        uglyNums[0] = 1

        while (curIdx < n-1) {
            minUgly = Int.MAX_VALUE
            for (i in 0 until primes.size) {
                tmpUgly = uglyNums[primeIdx[i]] * primes[i]
                if (tmpUgly < minUgly) {
                    minUgly = tmpUgly
                    tmpIdx = i
                }
            }

            primeIdx[tmpIdx] += 1

            if (minUgly > uglyNums[curIdx]) {
                uglyNums[++curIdx] = minUgly
            }
        }

        return uglyNums[n-1]
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val n = 12
    val primes = intArrayOf(2, 7, 13, 19)
    val result: Int

    result = sol.nthSuperUglyNumber(n, primes)
    println(result)
}

