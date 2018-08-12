class Solution {
    fun nthUglyNumber(n: Int): Int {
        val uglyNums = IntArray(n){0}
        var twoIdx = 0
        var threeIdx = 0
        var fiveIdx = 0
        var twoUgly: Int
        var threeUgly: Int
        var fiveUgly: Int
        var minUgly: Int
        var idx = 0

        uglyNums[0] = 1

        while (idx < n-1) {
            twoUgly = uglyNums[twoIdx] * 2
            threeUgly = uglyNums[threeIdx] * 3
            fiveUgly = uglyNums[fiveIdx] * 5

            minUgly = Math.min(twoUgly, Math.min(threeUgly, fiveUgly))

            when (minUgly) {
                twoUgly -> twoIdx++
                threeUgly -> threeIdx++
                fiveUgly -> fiveIdx++
            }

            if (minUgly > uglyNums[idx]) {
                uglyNums[++idx] = minUgly
            }
        }

        return uglyNums[n-1]
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val n = 11
    val result: Int

    result = sol.nthUglyNumber(n)
    println(result)
}

