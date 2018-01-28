/*

len = 1
checkValue = first int

go thru each int in array
    if (value != checkValue)
        len++
        checkValue = value
        array[len-1] = checkValue

 */

class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var len = 1
        var curValue = nums.getOrNull(0)

        if (nums.isEmpty()) {
            return 0
        }

        for (i in 0 until nums.size) {
            if (curValue != nums[i]) {
                len++
                curValue = nums[i]
                nums[len-1] = curValue
            }
        }

        return len
    }
}

fun main(args: Array<String>) {
    val inputArray = intArrayOf(1, 1, 3) // [], [1, 1, 3]
    val sol = Solution()
    val len: Int

    len = sol.removeDuplicates(inputArray)
    println(len)
    for (i in 0 until len) {
        print("%d ".format(inputArray[i]))
    }
}