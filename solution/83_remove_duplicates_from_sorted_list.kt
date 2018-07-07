class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
}

class Solution {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        var curNode = head

        while (curNode != null) {
            while (curNode.`val` == curNode.next?.`val`) {
                curNode.next = curNode.next?.next
            }

            curNode = curNode.next
        }

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
    val input = intArrayOf(1, 1, 1)//intArrayOf(1, 1, 2, 3, 3)
    val head: ListNode?
    val result: ListNode?

    head = sol.buildList(input)
    result = sol.deleteDuplicates(head)
    sol.printNode(result)
}

