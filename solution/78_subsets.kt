class Solution {
    private var result: List<List<Int>> = listOf()

    fun subsets(nums: IntArray): List<List<Int>> {
        val visited = ArrayList<Int>()
        val pos = 0
        val startIdx = 0

        findSubset(visited, nums, pos, startIdx)

        return result
    }

    fun findSubset(visited: ArrayList<Int>, nums: IntArray, pos: Int, startIdx: Int) {
        result += listOf(visited.toList())

        if (pos == nums.size) {
            return
        }

        for (i in startIdx until nums.size) {
            if (visited.contains(nums[i])) {
                continue
            }

            visited.add(nums[i])
            findSubset(visited, nums, pos+1, i+1)
            visited.remove(nums[i])
        }

    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val nums = intArrayOf(1, 2, 3)
    val result: List<List<Int>>

    result = sol.subsets(nums)
    println(result)
}


