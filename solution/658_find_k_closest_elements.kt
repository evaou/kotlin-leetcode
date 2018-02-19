/*

find the index which value i is equal or closest to x
count = 1
j = i
leftValue = rightValue = arr[i]

while (count < k)

    if (i-1) >= 0
        leftValue = arr[i-1]

    if (j+1) <= len-1
        rightValue = arr[j+1]

    if (i-1) >= 0 and (x-leftValue) <= (rightValue-x)
          i = i-1
    else
          j = j+1

    count++


return [i..j]

 */

class Solution {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        var count = 1
        var i: Int
        var j: Int
        var leftValue: Int
        var rightValue: Int
        val newArr: List<Int>

        i = binarySearchTarget(arr, 0, arr.size-1, x)
        j = i

        while (count < k) {

            if (i <= 0) {
                j = j + 1
            } else if (j >= (arr.size-1)) {
                i = i - 1
            } else {
                leftValue = arr[i-1]
                rightValue = arr[j+1]

                if ((x-leftValue) <= (rightValue-x)) {
                    i = i - 1
                } else {
                    j = j + 1
                }
            }

            count++

        }

        newArr = arr.copyOfRange(i, j+1).toList()

        return newArr
    }

    fun binarySearchTarget(arr: IntArray, startIdx: Int, endIdx: Int, target: Int): Int {
        val middleIdx: Int = (startIdx+endIdx)/2
        var resultIdx = middleIdx

        if (target == arr[middleIdx] || startIdx >= endIdx) {
            return resultIdx
        }

        if (target > arr[middleIdx]) {
            resultIdx = binarySearchTarget(arr, middleIdx+1, endIdx, target)
        } else {
            resultIdx = binarySearchTarget(arr, startIdx, middleIdx-1, target)
        }

        return resultIdx
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val arr = intArrayOf(1, 2, 3, 4, 5) //intArrayOf(0, 0, 0, 1, 3, 5, 6, 7, 8, 8)
    val k = 4
    val x = -1
    val result: List<Int> // [1, 3]

    result = sol.findClosestElements(arr, k, x)
    println(result.toString())
}


