/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> oldNew = new HashMap<>(); // to remember what has already been copied

        return dfs(node, oldNew);
    }

    public Node dfs(Node node, Map<Node, Node> oldNew){
        if (node == null){
            return null;
        }

        if (oldNew.containsKey(node)){
            return oldNew.get(node);
        } 

        Node newNode = new Node(node.val);
        oldNew.put(node, newNode);
        
        for (Node n : node.neighbors){
            newNode.neighbors.add(dfs(n, oldNew));
        }

        return newNode;
    }
}