/*

costMap: HashMap<index, minCost>

fun getMinCost(index): minCost

    if costMap doesn't contains index key

        firstStepCost = secondStepCost = 0

        if index+1 < costSize
            firstStepCost = getMinCost(index+1)

        if index+2 < costSize
            secondStepCost = getMinCost(index+2)

        costMap[index] = cost[index] + min(firstStepCost, secondStepCost)

    return costMap[index]

 fun minCostClimbingStairs(cost)
    return min(getMinCost(0), getMinCost(1))

 */

class Solution {
    val costMap = HashMap<Int, Int>()

    fun getMinCost(cost: IntArray, index: Int): Int {
        var firstStepCost = 0
        var secondStepCost = 0

        if (!costMap.containsKey(index)) {

            if (index+1 < cost.size) {
                firstStepCost = getMinCost(cost, index+1)
            }

            if (index+2 < cost.size) {
                secondStepCost = getMinCost(cost, index+2)
            }

            costMap[index] = cost[index] + Math.min(firstStepCost, secondStepCost)
        }

        return costMap.getValue(index)
    }

    fun minCostClimbingStairs(cost: IntArray): Int {
        return Math.min(getMinCost(cost, 0), getMinCost(cost, 1))
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val cost = intArrayOf(1, 100, 1, 1, 1, 100, 1, 1, 100, 1) //intArrayOf(10, 15, 20)
    val resultCost: Int

    resultCost = sol.minCostClimbingStairs(cost)
    println(resultCost)
}