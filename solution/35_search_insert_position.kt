/*

targetIndex = array length
go thru index from 0 to array final index
    if target == array[index]
        targetIndex = index
        break
    else if target < array[index]
        targetIndex = index
        break

return targetIndex

 */

class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var targetIndex = nums.size

        for (i in 0 until nums.size) {
            if (target == nums[i]) {
                targetIndex = i
                break
            } else if (target < nums[i]) {
                targetIndex = i
                break
            }
        }

        return targetIndex
    }
}

fun main(args: Array<String>) {
    val nums = intArrayOf(1, 3, 5, 6)
    val target = 0 // 2, 5, 7, 0
    val sol = Solution()
    val index: Int

    index = sol.searchInsert(nums, target)
    println(index)
}