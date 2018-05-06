// cumulative sum
// https://segmentfault.com/a/1190000008380613

import java.util.TreeSet
class Solution {
    fun maxSumSubmatrix(matrix: Array<IntArray>, k: Int): Int {
        var globalMax = Int.MIN_VALUE
        val colNum = matrix[0].size
        val rowNum = matrix.size
        var colArray: IntArray
        var localMax: Int
        var preSum: Int
        var curSum: Int?
        var set: TreeSet<Int>

        for (i in 0 until colNum) {

            colArray = IntArray(rowNum, {0})
            for (j in i until colNum) {

                for (k in 0 until rowNum) {
                    colArray[k] += matrix[k][j]
                }

                localMax = Int.MIN_VALUE
                preSum = 0
                set = TreeSet()
                set.add(0)
                for (sum in colArray) {
                    preSum += sum
                    curSum = set.ceiling(preSum - k)
                    if (curSum != null) {
                        localMax = Math.max(localMax, preSum - curSum)
                    }
                    set.add(preSum)
                }

                globalMax = Math.max(globalMax, localMax)
            }
        }


        return globalMax
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val matrix = arrayOf(intArrayOf(5, -4, -3, 4), intArrayOf(-3, -4, 4, 5), intArrayOf(5, 1, 5, -4))
    val k = 3
    val result: Int

    result = sol.maxSumSubmatrix(matrix, k)
    println(result)
}



