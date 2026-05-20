/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null) return new ArrayList<>();

        List<List<Integer>> allNodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        // first add the first node to the queue
        queue.add(root);


        // then while the queue is not empty
            // pop the node
            // check children
            // create a local list of nodes 

        while (!queue.isEmpty()){
            int queueSize = queue.size();

            List<Integer> currentLevel = new ArrayList<>();


            // iterate over this level
            for (int i = 0; i < queueSize; i++){
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if (currentNode.left!=null) queue.add(currentNode.left);
                if (currentNode.right!=null) queue.add(currentNode.right);
            }

            if (currentLevel.size()>0){
                allNodes.add(currentLevel);
            }

        }

        return allNodes;
    }
}
