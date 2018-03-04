class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val result = IntArray(2)
        val compTable = HashMap<Int, Int>()
        var compValue: Int

        for (i in 0 until nums.size) {
            compValue = target - nums[i]
            if (compTable.containsKey(compValue)) {
                result[0] = compTable.getValue(compValue)
                result[1] = i
            } else {
                compTable.put(nums[i], i)
            }
        }

        return result
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val nums = intArrayOf(3, 2, 4)
    val target = 6
    val result: IntArray

    result = sol.twoSum(nums, target)
    println(result.toList().toString())
}


