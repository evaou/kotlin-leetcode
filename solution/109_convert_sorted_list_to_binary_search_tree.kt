class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
}

class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    var curNode: ListNode? = null

    fun sortedListToBST(head: ListNode?): TreeNode? {
        var nodeNum = 0
        var node = head
        val result: TreeNode?

        while (node != null) {
            nodeNum++
            node = node.next
        }

        curNode = head

        result = buildBST(nodeNum)

        return result
    }

    fun buildBST(len: Int): TreeNode? {
        if (len == 0) {
            return null
        }

        val leftNode = buildBST(len/2)

        val rootNode = TreeNode(curNode?.`val`!!)
        curNode = curNode?.next

        val rightNode = buildBST(len - len/2 - 1)

        rootNode.left = leftNode
        rootNode.right = rightNode

        return rootNode
    }

    fun printNode(head: ListNode?) {
        var tmpNode = head

        while (tmpNode != null) {
            print("%d, ".format(tmpNode.`val`))
            tmpNode = tmpNode.next
        }
        println()
    }

    fun buildList(input: IntArray): ListNode? {
        var head: ListNode? = null
        var tmp: ListNode?

        for (i in input.lastIndex downTo 0) {
            tmp = ListNode(input[i])
            tmp.next = head
            head = tmp
        }

        return head
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val input = intArrayOf(-10, -3, 0, 5, 9)
    val head: ListNode?

    head = sol.buildList(input)
    sol.sortedListToBST(head)
}

