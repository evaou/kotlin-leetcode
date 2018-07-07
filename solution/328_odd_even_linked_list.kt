class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
}

class Solution {
    fun oddEvenList(head: ListNode?): ListNode? {
        var nextEvenNode = head?.next
        var oddNode = head
        val startEvenNode = head?.next

        while (nextEvenNode?.next != null) {
            oddNode?.next = nextEvenNode.next
            oddNode = oddNode?.next
            nextEvenNode.next = oddNode?.next
            nextEvenNode = nextEvenNode.next
        }

        oddNode?.next = startEvenNode

        return head
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
    val input = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8)
    val head: ListNode?
    val result: ListNode?

    head = sol.buildList(input)
    result = sol.oddEvenList(head)
    sol.printNode(result)
}

