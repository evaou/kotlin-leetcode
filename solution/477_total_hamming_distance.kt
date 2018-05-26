class Solution {
    fun totalHammingDistance(nums: IntArray): Int {
        var totalDist = 0
        var tmpCount = 0
        val numLen = nums.size

        for (i in 0 until 32) {
            tmpCount = 0
            for (j in 0 until numLen) {
                tmpCount += nums[j] and 1
                nums[j] = nums[j].shr(1)
            }

            totalDist += tmpCount * (numLen - tmpCount)
        }

        return totalDist
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val nums = intArrayOf(4, 14, 2)
    val result: Int

    result = sol.totalHammingDistance(nums)
    println(result)
}

