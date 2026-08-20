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
    public List<Integer> postorderTraversal(TreeNode root) {
        java.util.List<Integer> postorder = new java.util.ArrayList<>();  // List to store the postorder traversal
        
        // If the tree is empty, return an empty traversal
        if (root == null) {
            return postorder;
        }

        java.util.Stack<TreeNode> st1 = new java.util.Stack<>();  // First stack for iterative traversal
        java.util.Stack<TreeNode> st2 = new java.util.Stack<>();  // Second stack to store the nodes in postorder

        // Push the root node onto the first stack
        st1.push(root);

        // Iterative traversal to populate st2 with nodes in postorder
        while (!st1.isEmpty()) {
            root = st1.pop();  // Get the top node from st1
            st2.push(root);  // Push the node onto st2

            // Push left child onto st1 if exists
            if (root.left != null) {
                st1.push(root.left);
            }

            // Push right child onto st1 if exists
            if (root.right != null) {
                st1.push(root.right);
            }
        }

        // Populate the postorder traversal list by popping st2
        while (!st2.isEmpty()) {
            postorder.add(st2.pop().val);  // Add the node's value to the postorder result
        }

        // Return the postorder traversal result
        return postorder;
    } 
    
}