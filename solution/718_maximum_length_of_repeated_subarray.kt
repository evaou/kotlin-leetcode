/*

hashMap
maxLen = 0

go thru each num (i) in array A
    if hashMap contains num and (A size -i) <= maxLen
        continue

    isFound = false
    tmpMaxLen = 0
    go thru each num2 (j) in array B
        tmpLen = 0
        if num2 == num
            for k = 0 until min(BSize-j, ASize-i)
                if B[j+k] == A[i+k]
                    tmpLen++
                 else
                    break

            isFound = true
        tmpMaxLen = max(tmpMaxLen, tmpLen)

    hashMap(num) = tmpMaxLen
    maxLen = max(maxLen, hashMap(num))

    if (!isFound)
        hasMap(num) = tempLen

 */

class Solution {
    fun findLength(A: IntArray, B: IntArray): Int {
        val lenMap = HashMap<Int, Int>()
        var maxLen = 0
        var isFound: Boolean
        var tmpLen: Int
        var tmpSize: Int
        var tmpMaxLen: Int

        for (i in 0 until A.size) {
            if (lenMap.containsKey(A[i]) &&
                (A.size-i) <= maxLen) {
                continue
            }

            isFound = false
            tmpMaxLen = 0
            for (j in 0 until B.size) {
                tmpLen = 0
                if (A[i] == B[j]) {
                    tmpSize = Math.min(B.size-j, A.size-i)
                    for (k in 0 until tmpSize) {
                        if (B[j+k] == A[i+k]) {
                            tmpLen++
                        } else {
                            break
                        }
                    }
                    isFound = true
                }
                tmpMaxLen = Math.max(tmpMaxLen, tmpLen)
            }

            lenMap.put(A[i], tmpMaxLen)
            maxLen = Math.max(maxLen, lenMap.getValue(A[i]))

            if (!isFound) {
                lenMap.put(A[i], tmpMaxLen)
            }
        }

        return maxLen
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val A = intArrayOf(1,2,3,2,1)
    val B = intArrayOf(3,2,1,4,7)
    val result: Int

    result = sol.findLength(A, B)
    println(result)
}