/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int = 0) {
 *     var next: ListNode? = null
 * }
 */

class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
}

class Solution {
    // iterative
    /*
    fun reverseList(head: ListNode?): ListNode? {
        var curNode = head
        var preNode: ListNode? = null
        var nextNode: ListNode?

        while (curNode != null) {
            nextNode = curNode.next
            curNode.next = preNode
            preNode = curNode
            curNode = nextNode
        }

        return preNode
    }*/

    // recursive
    fun reverseList(head: ListNode?): ListNode? {
        return getReverse(head, null)
    }

    fun getReverse(curNode: ListNode?, preNode: ListNode?): ListNode? {
        if (curNode?.next == null) {
            curNode?.next = preNode
            return curNode
        }

        val nextNode = curNode.next
        curNode.next = preNode

        return getReverse(nextNode, curNode)
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
    val input = intArrayOf(1, 2, 3, 4, 5)
    val head: ListNode?
    val result: ListNode?

    head = sol.buildList(input)
    result = sol.reverseList(head)
    sol.printNode(result)
}

