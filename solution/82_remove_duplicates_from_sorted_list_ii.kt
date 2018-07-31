class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
}

class Solution {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        val dummyHead: ListNode? = ListNode(-1)
        var preNode: ListNode? = dummyHead
        var curNode = head
        var duplicateValue = head?.`val`

        dummyHead?.next = head

        while (curNode?.next != null) {
            if (curNode.next!!.`val` != duplicateValue) {
                preNode = curNode
            } else {
                do {
                    curNode = curNode?.next
                } while (curNode?.next?.`val` == duplicateValue)
                preNode?.next = curNode?.next
            }

            duplicateValue = curNode?.next?.`val`
            curNode = curNode?.next
        }

        return dummyHead?.next
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
    val input = intArrayOf(1, 1)
    var head: ListNode?

    head = sol.buildList(input)
    head = sol.deleteDuplicates(head)
    sol.printNode(head)
}

