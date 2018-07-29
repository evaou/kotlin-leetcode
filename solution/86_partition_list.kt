//86
class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
}

class Solution {
    fun partition(head: ListNode?, x: Int): ListNode? {
        if (head?.next == null || x < 1) {
            return head
        }

        val dummyHead: ListNode? = ListNode(-1)
        var curNode = dummyHead
        var preFirstLargeNode: ListNode? = null
        var tmpNode: ListNode?

        dummyHead?.next = head

        while (curNode?.next != null) {
            if (curNode.next!!.`val` >= x) {
                if (preFirstLargeNode == null) {
                    preFirstLargeNode = curNode
                }
            } else {
                if (preFirstLargeNode != null) {
                    tmpNode = curNode.next
                    curNode.next = tmpNode?.next
                    tmpNode?.next = preFirstLargeNode.next
                    preFirstLargeNode.next = tmpNode
                    preFirstLargeNode = tmpNode
                }
            }

            curNode = curNode.next
        }

        if (curNode != null && preFirstLargeNode != null) {
            curNode.next = preFirstLargeNode.next
            preFirstLargeNode.next = curNode
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
    val input = intArrayOf(1, 1) //intArrayOf(1, 4, 3, 2, 5, 2)
    val x = 0//
    var head: ListNode?

    head = sol.buildList(input)
    head = sol.partition(head, x)
    sol.printNode(head)
}

