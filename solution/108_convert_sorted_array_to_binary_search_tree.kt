class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    var curIdx = 0

    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return buildBST(nums, nums.size)
    }

    fun buildBST(nums: IntArray, len: Int): TreeNode? {
        if (len <= 0) {
            return null
        }

        val midLen = len/2
        val leftNode = buildBST(nums, midLen)
        val rootNode = TreeNode(nums[curIdx++])
        val rightNode = buildBST(nums, len - midLen - 1)

        rootNode.left = leftNode
        rootNode.right = rightNode

        return rootNode
    }

/*
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        val result: TreeNode?

        result = buildBST(nums, 0, nums.size-1)

        return result
    }

    fun buildBST(nums: IntArray, start: Int, end: Int): TreeNode? {
        if (start > end ) {
            return null
        }

        val mid = (start + end)/2
        val root = TreeNode(nums[mid])
        root.left = buildBST(nums, start, mid-1)
        root.right = buildBST(nums, mid+1, end)

        return root
    }
*/
}

fun main(args: Array<String>) {
    val sol = Solution()
    val input = intArrayOf(-10, -3, 0, 5, 9)

    sol.sortedArrayToBST(input)
}
