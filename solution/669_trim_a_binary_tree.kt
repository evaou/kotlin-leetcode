/*

rootNode = root

while rootNode is NOT null
    if rootNode >= L && rootNode <= R
        break
    if rootNode < L
        rootNode = rootNode.right
        continue
    if rootNode > R
        rootNode = rootNode.left

// find LeftThresholdNode
node = rootNode
while (node is NOT null)
    if node.left is null
        break
    else if node.left < L
        node.left =  node.left.right
        continue

    node = node.left

// find rightThresholdNode
node = rootNode
while (node is NOT null)
    if node.right is null
        break
    else if node.right > R
        node.right = node.right.left
        continue

    node = node.right
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
    fun trimBST(root: TreeNode?, L: Int, R: Int): TreeNode? {
        var rootNode = root
        var node: TreeNode?
        var tmpNode: TreeNode?

        while (rootNode != null) {
            if (rootNode.`val` >= L && rootNode.`val` <= R) {
                break
            }

            if (rootNode.`val` < L) {
                rootNode = rootNode.right
                continue
            }

            if (rootNode.`val` > R) {
                rootNode = rootNode.left
            }
        }

        node = rootNode
        while (node != null) {
            tmpNode = node.left
            if (tmpNode == null) {
                break
            } else if (tmpNode.`val` < L) {
                node.left = tmpNode.right
                continue
            }

            node = node.left
        }

        node = rootNode
        while (node != null) {
            tmpNode = node.right
            if (tmpNode == null) {
                break
            } else if (tmpNode.`val` > R) {
                node.right = tmpNode.left
                continue
            }

            node = node.right
        }

        return rootNode
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val tree = Tree()
    val treeValueList: List<Int?> = listOf(3, 1, 4, null, 2) //listOf(1, 0, 2) // listOf(3, 0, 4, null, 2, null, null, 1)
    val L = 3
    val R = 4 //3

    tree.create(treeValueList)

    sol.trimBST(tree.root, L, R)

}