class Solution {
    fun getMoneyAmount(n: Int): Int {
        val table = Array(n, {IntArray(n, {0})})

        return DP(table, 0, n-1)
    }

    fun DP(table: Array<IntArray>, startIdx: Int, endIdx: Int): Int {
        if (startIdx >= endIdx) {
            return 0
        }

        if (table[startIdx][endIdx] > 0) {
            return table[startIdx][endIdx]
        }

        var result = Int.MAX_VALUE
        var tmpResult: Int

        for (i in startIdx..endIdx) {
            tmpResult = (i+1) + Math.max(DP(table, startIdx, i-1), DP(table, i+1, endIdx))
            result = Math.min(result, tmpResult)
        }

        table[startIdx][endIdx] = result
        return result
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val n = 3//10
    val result: Int

    result = sol.getMoneyAmount(n)
    println(result)
}


