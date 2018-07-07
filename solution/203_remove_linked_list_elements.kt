class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
}

class Solution {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        val newNode = ListNode(0)
        var preNode  = newNode
        var curNode = head

        newNode.next = head

        while (curNode != null) {
            if (curNode.`val` == `val`) {
                preNode.next = curNode.next

            } else {
                preNode = curNode
            }

            curNode = curNode.next
        }

        return newNode.next
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
    val input = intArrayOf(1, 2, 2, 1)
    val `val` = 2
    val head: ListNode?
    val result: ListNode?

    head = sol.buildList(input)
    result = sol.removeElements(head, `val`)
    sol.printNode(result)
}

