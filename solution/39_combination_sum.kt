class Solution {
    private var result: List<List<Int>> = listOf()

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val startIdx = 0
        val visited = ArrayList<Int>()
        val tmpSum = 0

        findCombinationSum(visited, candidates.sortedArray(), target, startIdx, tmpSum)

        return result
    }

    fun findCombinationSum(visited: ArrayList<Int>, sortedCandidates: IntArray, target: Int, startIdx: Int, tmpSum: Int) {
        if (tmpSum >= target) {
            if (tmpSum == target) {
                result += listOf(visited.toList())
            }
            return
        }

        for (i in startIdx until sortedCandidates.size) {
            visited.add(sortedCandidates[i])
            findCombinationSum(visited, sortedCandidates, target, i, tmpSum+sortedCandidates[i])
            visited.remove(sortedCandidates[i])
        }
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val candidates = intArrayOf(2, 3, 6, 7)
    val target = 7
    val result: List<List<Int>>

    result = sol.combinationSum(candidates, target)
    println(result)
}


