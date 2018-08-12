
class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val eqList = mutableListOf<Int>()
        val ltList = mutableListOf<Int>()
        val gtList = mutableListOf<Int>()
        val midIdx: Int = nums.size / 2
        val result: Int

        for (i in 0 until nums.size) {
            if (nums[i] < nums[midIdx]) {
                ltList.add(nums[i])
            } else if (nums[i] == nums[midIdx]) {
                eqList.add(nums[i])
            } else {
                gtList.add(nums[i])
            }
        }

        if (k <= gtList.size) {
            result = findKthLargest(gtList.toIntArray(), k)
        } else if (k <=  (gtList.size + eqList.size)) {
            result = eqList[0]
        } else {
            result = findKthLargest(ltList.toIntArray(), k - gtList.size - eqList.size)
        }

        return result
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val nums = intArrayOf(3,2,3,1,2,4,5,5,6)
    val k = 4
    val result: Int

    result = sol.findKthLargest(nums, k)
    println(result)
}

