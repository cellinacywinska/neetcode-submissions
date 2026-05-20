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
    // left, root, right
    // List<Integer> nodes;
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     nodes = new ArrayList<>();
    //     dfs(root);
    //     return nodes;
    // }

    // public void dfs(TreeNode root){
    //     if (root==null) return;
    //     dfs(root.left);
    //     nodes.add(root.val);
    //     dfs(root.right);
    // }

    List<Integer> nodes;
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root==null) return new ArrayList<>();
        nodes = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;

        while (currentNode!=null || !stack.isEmpty()){
            while (currentNode!=null){
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            currentNode = stack.pop();
            nodes.add(currentNode.val);
            currentNode = currentNode.right;
        }


        return nodes;
    }
}