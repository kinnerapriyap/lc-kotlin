fun levelOrder(root: TreeNode?): List<List<Int>> {
    val output = mutableListOf<List<Int>>()
    if (root == null)
        return output

    val stack = mutableListOf<TreeNode>()
    stack.add(root)
    while (stack.isNotEmpty()) {
        val stackSize = stack.size
        val insideOutput = mutableListOf<Int>()
        for (i in 0 until  stackSize) {
            val currentNode = stack.removeFirst()
            insideOutput.add(currentNode.`val`)
            currentNode.left?.let { stack.add(it) }
            currentNode.right?.let { stack.add(it) }
        }

        output.add(insideOutput)
    }

    return output
}