class Solution {
    boolean bal = true;
    
    int ok(TreeNode root) {
        if (root == null) return 0; // Fixed: null height is 0
        
        int l = ok(root.left);
        int r = ok(root.right);
        
        if (Math.abs(l - r) > 1) bal = false;
        
        return Math.max(l, r) + 1; // Fixed: calculate height, not node count
    }
    
    public boolean isBalanced(TreeNode root) {
        ok(root);
        return bal;
    }
}