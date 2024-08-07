// https://leetcode.com/problems/clone-graph

import java.util.HashMap

fun cloneGraph(node: Node?, visited: HashMap<Int, Node> = hashMapOf()): Node? {
   if (node == null) return null
   if (visited.contains(node.`val`)) return visited[node.`val`]
   val newNode = Node(node.`val`)
   visited[newNode.`val`] = newNode
   node.neighbors.forEach { neighbor ->
      newNode.neighbors.add(cloneGraph(neighbor, visited))
   }
   return newNode
}