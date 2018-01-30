/*

if array size is 0
    return 0

length is 0
go through array index from 0
    if array value is not equal to value
        switch array[index] and array[length]
        length++

return length

 */

class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var length = 0
        var tmpValue: Int

        if (nums.isEmpty()) {
            return 0
        }

        for (i in 0 until nums.size) {
            if (nums[i] != `val`) {
                tmpValue = nums[i]
                nums[i] = nums[length]
                nums[length] = tmpValue
                length++
            }
        }

        return length
    }
}

fun main(args: Array<String>) {
    val inputArray = intArrayOf(3, 2, 2, 3) // [3, 2, 2, 3]
    val value = 3
    val sol = Solution()
    val len: Int

    len = sol.removeElement(inputArray, value)
    println(len)
    for (i in 0 until len) {
        print("%d ".format(inputArray[i]))
    }
}