class Solution {
    int ans = 0; // Initialize to 0 instead of -1
    
    private int ok(TreeNode root) {
        if (root == null) return 0;
        
        // Get the height of left and right subtrees
        int l = ok(root.left);
        int r = ok(root.right);
        
        // Update the maximum diameter found so far
        ans = Math.max(ans, l + r);
        
        // Return the height of the current node
        return Math.max(l, r) + 1;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
         ok(root);
         return ans;
    }
}