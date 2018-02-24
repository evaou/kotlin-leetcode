/*

    resultList: List<IntArray()>

    fun countArrangement
        visitedList = List<Int>()
        nums = (1..N)
        order = 1

        findArrangement(visitedList, nums, order)

    fun findArrangement
        if order == N+1
            resultList.add(visitedList)
            return

        for i in nums
            if visitedList has i or !(i%(order) == 0 or (order)%i == 0)
                continue

            visitedList.add(i)
            findArrangement(visitedList, nums, order+1)
            visitedList.remove(i)

 */

class Solution {
    private val result = ArrayList<IntArray>()

    fun countArrangement(N: Int): Int {
        val visited = ArrayList<Int>()
        val nums = IntArray(N){it+1}
        val order = 1

        findArrangement(visited, nums, order)

        return result.size
    }

    fun findArrangement(visited: ArrayList<Int>, nums: IntArray, order: Int) {
        if (order > nums.size) {
            result.add(visited.toIntArray())
            return
        }

        for (i in nums) {
            if (visited.contains(i) ||
                !((i%order == 0) || (order%i == 0))) {
                continue
            }

            visited.add(i)
            findArrangement(visited, nums, order+1)
            visited.remove(i)
        }
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val N = 3
    val result: Int

    result = sol.countArrangement(N)
    println(result)
}


