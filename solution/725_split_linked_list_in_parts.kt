class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
}

class Solution {
    fun splitListToParts(root: ListNode?, k: Int): Array<ListNode?> {
        val result = Array<ListNode?>(k){null}
        var nodeNum = 0
        var tmpNode = root
        var preNode: ListNode? = null
        val avgNodeNum: Int
        var extraPartNum: Int

        while (tmpNode != null) {
            nodeNum++
            tmpNode = tmpNode.next
        }

        avgNodeNum = nodeNum / k
        extraPartNum = nodeNum % k

        tmpNode = root
        for (i in 0 until k) {
            result[i] = tmpNode

            for (j in 0 until avgNodeNum) {
                preNode = tmpNode
                tmpNode = tmpNode?.next
            }

            if (extraPartNum > 0) {
                preNode = tmpNode
                tmpNode = tmpNode?.next
                extraPartNum--
            }

            preNode?.next = null
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
    val input = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val k = 3
    val head: ListNode?
    val result: Array<ListNode?>

    head = sol.buildList(input)
    result = sol.splitListToParts(head, k)
    for (i in 0 until k) {
        sol.printNode(result[i])
    }
}

