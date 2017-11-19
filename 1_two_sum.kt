class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val hasMap = HashMap<Int, Int>()
        var result = IntArray(2)

        for (i in nums.indices) {
            val complement = target - nums[i]

            if (hasMap.containsKey(complement)) {
                result = intArrayOf(i, hasMap.getValue(complement))
                break
            }

            hasMap.put(nums[i], i)
        }

        return result
    }
}

fun main(args: Array<String>) {
    val nums = intArrayOf(2, 7, 11, 15)
    val target = 9
    val sol = Solution()

    val result = sol.twoSum(nums, target)

    print("[")
    for (i in result.indices) {
        print("${result[i]}")
        if (i != result.lastIndex) {
            print(", ")
        }
    }
    println("]")
}
