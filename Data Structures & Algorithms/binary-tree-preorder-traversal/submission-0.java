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
    // root, left, right
    // List<Integer> nodes;
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     nodes = new ArrayList<>();
    //     dfs(root);
    //     return nodes;
    // }

    // public void dfs(TreeNode root){
    //     if (root==null) return;

    //     nodes.add(root.val);
    //     dfs(root.left);
    //     dfs(root.right);
    // }

    // root, left, righ
    List<Integer> nodes;
    public List<Integer> preorderTraversal(TreeNode root) {
        nodes = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current!=null ||!stack.isEmpty()){
            if (current!=null){
                nodes.add(current.val);
                stack.push(current.right);
                current = current.left;
            } else {
                current = stack.pop();
            }
        }

        return nodes;
    }

}









