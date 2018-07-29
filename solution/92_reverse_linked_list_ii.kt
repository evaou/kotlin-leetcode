class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
}

class Solution {
    fun reverseBetween(head: ListNode?, m: Int, n: Int): ListNode? {
        if (m >= n) {
            return head
        }

        var startNode: ListNode?
        var endNode = head
        var preStartNode: ListNode? = ListNode(-1)
        var nextNode: ListNode?
        var count = 1
        var result: ListNode? = head

        preStartNode?.next = head

        while (count <= n) {
            if (count < m) {
                preStartNode = preStartNode?.next
            }

            endNode = endNode?.next
            count++
        }

        startNode = preStartNode?.next
        count = m
        while (count <= n) {
            nextNode = startNode?.next
            startNode?.next = endNode
            endNode = startNode
            startNode = nextNode
            count++
        }

        preStartNode?.next = endNode

        if (m == 1) {
            result = preStartNode?.next
        }

        return result
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
    val m = 2
    val n = 4
    var head: ListNode?

    head = sol.buildList(input)
    head = sol.reverseBetween(head, m, n)
    sol.printNode(head)
}

