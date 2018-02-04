/*

resultLists

fun findPath(node, curlist, lists)
    if node.left is null and node.right is null
        curList += listOf(node.value)
        if curList has sum
            resultLists += curList
        return

    if (node.left is NOT null)
        findPath(node.left, curList+listOf(node.value))

    if (node.right is NOT null)
        findPath(node.right, curList+listOf(node.value))

fun pathSum(root, sum): lists
    lists = findPath(root)

    go thru each lsit in lists
        get newLists with the required list sum

    return newLists

 */


class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Queue {
    var list: List<TreeNode?> = listOf()
    var topIndex: Int = 0

    fun enqueue(node: TreeNode?) {
        list += listOf(node)
    }

    fun dequeue(): TreeNode? {
        if (topIndex >= list.size) {
            return null
        }

        return list[topIndex++]
    }
}

class Tree {
    var root: TreeNode? = null

    fun create(list: List<Int?>) {
        var tmpNode: TreeNode?
        var value: Int?
        val nodeQueue = Queue()
        var parNode = root
        var isLeftNode = true

        for (i in list.indices) {
            value = list[i]

            if (value != null) {
                tmpNode = TreeNode(value)
                nodeQueue.enqueue(tmpNode)
            } else {
                tmpNode = null
            }

            if (parNode == null) {
                parNode = nodeQueue.dequeue()
                root = parNode
            } else {
                if (isLeftNode) {
                    parNode.left = tmpNode
                    isLeftNode = false
                } else {
                    parNode.right = tmpNode
                    parNode = nodeQueue.dequeue()
                    isLeftNode = true
                }
            }
        }

    }
}

class Solution {
    var resultLists: List<List<Int>> = listOf()

    fun isResultSum(list: List<Int>, sum: Int): Boolean {
        var resultSum = 0

        for (i in list.iterator()) {
            resultSum += i
        }

        return (resultSum == sum)
    }

    fun findPath(node: TreeNode?, curList: List<Int>, sum: Int) {
        if (node != null && node.left == null && node.right == null) {
            var newLeaveList = curList
            newLeaveList += listOf(node.`val`)
            if (isResultSum(newLeaveList, sum)) {
                resultLists += listOf(newLeaveList)
            }
            return
        }

        var newLeftList = curList
        if (node?.left != null) {
            newLeftList += listOf(node.`val`)
            findPath(node.left, newLeftList, sum)
        }

        var newRightList = curList
        if (node?.right != null) {
            newRightList += listOf(node.`val`)
            findPath(node.right, newRightList, sum)
        }
    }

    fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> {
        val curList: List<Int> = listOf()

        findPath(root, curList, sum)

        return resultLists
    }

    fun printPath(path: List<List<Int>>) {
        for (i in path.indices) {
            for (j in path[i].iterator()) {
                print("%d ".format(j))
            }
            println()
        }
    }

}

fun main(args: Array<String>) {
    val sol = Solution()
    val sum = 22
    val tree = Tree()
    val treeValueList: List<Int?> = listOf(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1)

    tree.create(treeValueList)

    sol.pathSum(tree.root, sum)
    sol.printPath(sol.resultLists)
}