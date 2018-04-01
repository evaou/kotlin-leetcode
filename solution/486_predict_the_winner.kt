class Solution {
    fun PredictTheWinner(nums: IntArray): Boolean {
        val scores = Array(nums.size, {IntArray(nums.size, {-1})})

        return calcScore(nums, 0, nums.size-1, scores) >= 0
    }

    fun calcScore(nums: IntArray, startIdx: Int, endIdx: Int, scores: Array<IntArray>): Int {
        if (scores[startIdx][endIdx] != -1) {
            return scores[startIdx][endIdx]
        }

        if (startIdx == endIdx) {
            scores[startIdx][endIdx] = nums[startIdx]
            return scores[startIdx][endIdx]
        }

        val value1 = nums[startIdx] - calcScore(nums, startIdx+1, endIdx, scores)
        val value2 = nums[endIdx] - calcScore(nums, startIdx, endIdx-1, scores)

        return Math.max(value1, value2)
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    //val nums = intArrayOf(1, 5, 2)
    //val nums = intArrayOf(1, 5, 233, 7)
    val nums = intArrayOf(2, 4, 55, 6, 8)
    val result: Boolean

    result = sol.PredictTheWinner(nums)
    println(result)
}


