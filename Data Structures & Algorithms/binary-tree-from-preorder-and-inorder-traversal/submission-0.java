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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
        // preorder --> root, left, right
        // inorder -> left, root, right
        
        // the first element of the preorder array is the root of the tree
        // the in order array divides the subtree in two halves
        // -- on the left of the root is the left side of the tree
        // -- on the right side of the root is the right side of the tree
        return dfs(preorder, inorder);
        
    }

    public TreeNode dfs(int[] preorder, int[] inorder){
        if (preorder.length==0 || inorder.length==0){
            return null;
        }

        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);

        int split = -1;
        for (int i =0; i < inorder.length; i++){
            if (inorder[i]==rootVal){
                split = i;
                break;
            }
        }

        int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, split+1);
        int[] leftInOrder = Arrays.copyOfRange(inorder,0, split);
        root.left=dfs(leftPreOrder, leftInOrder);

        int[] rightPreOrder = Arrays.copyOfRange(preorder, split+1, preorder.length);
        int[] rightInOrder = Arrays.copyOfRange(inorder, split+1, preorder.length);
        root.right=dfs(rightPreOrder, rightInOrder);

        return root;
    }
}
