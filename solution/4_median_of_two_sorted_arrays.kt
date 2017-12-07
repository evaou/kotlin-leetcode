class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        var median = 0.0
        val isSingleMedian = (nums1.size + nums2.size) % 2
        val medianOrder = (nums1.size + nums2.size) / 2 + isSingleMedian
        var curOrder = 0
        var tmpMedia = 0
        var idx1 = 0
        var idx2 = 0

        while (curOrder <= medianOrder) {
            if (curOrder == medianOrder) {
                median = tmpMedia.toDouble()
                if (isSingleMedian == 1) {
                    break
                }
            }

            if (idx1 >= nums1.size) {
                tmpMedia = nums2[idx2]
                idx2++
            } else if (idx2 >= nums2.size) {
                tmpMedia = nums1[idx1]
                idx1++
            } else {
                if (nums1[idx1] < nums2[idx2]) {
                    tmpMedia = nums1[idx1]
                    idx1++
                } else {
                    tmpMedia = nums2[idx2]
                    idx2++
                }
            }

            curOrder++
        }

        median = (median + tmpMedia) / 2

        return median
    }
}

fun main(args: Array<String>) {
    val array1 = intArrayOf(3, 4) // intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(3, 4)
    val array2 = intArrayOf() // intArrayOf(3, 4), intArrayOf(2), intArrayOf()
    val output: Double
    val sol = Solution()

    output = sol.findMedianSortedArrays(array1, array2)

    println(output)
}
