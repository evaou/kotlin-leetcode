// Kadane's algorithm

class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var maxSum = Int.MIN_VALUE
        var localMaxSum = 0
        var leftIdx = 0
        var rightIdx = 0

        for (i in 0 until nums.size) {

            if (nums[i] > localMaxSum + nums[i]) {
                leftIdx = i
                localMaxSum = nums[i]
            } else {
                localMaxSum = localMaxSum + nums[i]
            }

            if (localMaxSum > maxSum) {
                maxSum = localMaxSum
                rightIdx = i
            }
        }

        //println("subarry is [%s]".format(nums.copyOfRange(leftIdx, rightIdx+1).joinToString()))

        return maxSum
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val nums = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
    val result: Int

    result = sol.maxSubArray(nums)
    println(result)
}



