
class Solution {
    private var result: List<List<Int>> = listOf()

    fun permute(nums: IntArray): List<List<Int>> {
        val visited = ArrayList<Int>()
        val pos = 0

        findPermute(visited, nums, pos)

        return result
    }

    fun findPermute(visited: ArrayList<Int>, nums: IntArray, pos: Int) {
        if (pos == nums.size) {
            result += listOf(visited.toList())
            return
        }

        for (i in 0 until nums.size) {
            if (visited.contains(nums[i])) {
                continue
            }

            visited.add(nums[i])
            findPermute(visited, nums, pos+1)
            visited.remove(nums[i])
        }
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val nums = intArrayOf(1, 2, 3)
    val result: List<List<Int>>

    result = sol.permute(nums)
    println(result)
}


