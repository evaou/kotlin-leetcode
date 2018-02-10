/*

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

    fun printTree() {
        var tmpNode = root
        val queue = Queue()
        var list: List<String> = listOf()

        if (root == null) {
            list += listOf("null")
        } else {
            list += listOf("%d".format(root?.`val`))
        }

        while (tmpNode != null) {
            if (tmpNode.left == null && tmpNode.right == null) {
                tmpNode = queue.dequeue()
                continue
            }

            if (tmpNode.left == null) {
                list += listOf("null")
            } else {
                list += listOf("%d".format((tmpNode.left)?.`val`))
                queue.enqueue(tmpNode.left)
            }

            if (tmpNode.right == null) {
                list += listOf("null")
            } else {
                list += listOf("%d".format((tmpNode.right)?.`val`))
                queue.enqueue(tmpNode.right)
            }

            tmpNode = queue.dequeue()
        }

        println(list.toString())
    }
}

class Solution {
    fun findUniValuePath(node: TreeNode?, maxLenArray: IntArray): Int {
        val leftChildLen: Int
        val rightChildLen: Int
        val leftMaxLen: Int
        val rightMaxLen: Int

        if (node?.left != null) {
            leftChildLen = findUniValuePath(node.left, maxLenArray)
        } else {
            leftChildLen = 0
        }

        if (node?.right != null) {
            rightChildLen = findUniValuePath(node.right, maxLenArray)
        } else {
            rightChildLen = 0
        }

        if (node?.left != null && (node.left)?.`val` == node.`val`) {
            leftMaxLen = 1 + leftChildLen
        } else {
            leftMaxLen = 0
        }

        if (node?.right != null && (node.right)?.`val` == node.`val`) {
            rightMaxLen = 1 + rightChildLen
        } else {
            rightMaxLen = 0
        }

        maxLenArray[0] = Math.max(maxLenArray[0], leftMaxLen+rightMaxLen)

        return Math.max(leftMaxLen, rightMaxLen)
    }

    fun longestUnivaluePath(root: TreeNode?): Int {
        val maxLenArray = intArrayOf(0)

        if (root != null) {
            findUniValuePath(root, maxLenArray)
        }

        return maxLenArray[0]
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val tree = Tree()
    val treeValueList: List<Int?> = listOf(5, 4, 5, 1, 1, null, 5)//listOf(1, 4, 5, 4, 4, null, 5)
    val length: Int

    tree.create(treeValueList)
    tree.printTree()

    length = sol.longestUnivaluePath(tree.root)
    println("longest univalue path: %d".format(length))
}