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
    private int ok(TreeNode root,int prev){
        if(root==null)return 0;
        int l=ok(root.left,Math.max(root.val,prev));
        int r=ok(root.right,Math.max(root.val,prev));
        int ans=l+r;
        if(root.val>=prev)
          ans++;
        return ans;  
    }
    public int goodNodes(TreeNode root) {
        return ok(root,Integer.MIN_VALUE);
    }
}
