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
    // left, right, root
    // List<Integer> nodes;
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     nodes = new ArrayList<>();
    //     dfs(root);
    //     return nodes;
    // }

    // public void dfs(TreeNode root){
    //     if (root==null){
    //         return;
    //     }

    //     dfs(root.left);
    //     dfs(root.right);
    //     nodes.add(root.val);
    // }

    List<Integer> nodes;
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root==null) return new ArrayList<>();
        nodes = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current!=null || !stack.isEmpty()){
            if (current!=null){
                nodes.add(current.val);
                stack.push(current);
                current = current.right;
            } else {
                current = stack.pop();
                current = current.left;
            }
        }

        Collections.reverse(nodes);
        return nodes; 
    }














}