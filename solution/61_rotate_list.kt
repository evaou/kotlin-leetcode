//86
class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
}

class Solution {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head?.next == null || k < 1) {
            return head
        }

        var nodeNum = 1
        var curNode = head
        val newLastOrder: Int
        val lastNode: ListNode?
        val newHead: ListNode?

        while (curNode?.next != null) {
            nodeNum++
            curNode = curNode.next
        }
        lastNode = curNode

        if (k % nodeNum == 0) {
            return head
        }

        newLastOrder = nodeNum - k % nodeNum
        curNode = head
        for (i in 1 until newLastOrder) {
            curNode = curNode?.next
        }

        newHead = curNode?.next
        curNode?.next = null
        lastNode?.next = head

        return newHead
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
    val input = intArrayOf(1, 2)
    val x = 2
    var head: ListNode?

    head = sol.buildList(input)
    head = sol.rotateRight(head, x)
    sol.printNode(head)
}

