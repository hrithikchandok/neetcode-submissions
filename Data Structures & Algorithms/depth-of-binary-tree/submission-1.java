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
    int maxi=0;
    int ok(TreeNode root,int dep){
        if(root==null){
            maxi=Math.max(maxi,dep);
            return dep;
        }
        int l=ok(root.left,dep+1);
        int r=ok(root.right,dep+1);
        return Math.max(l,r);

    }
    public int maxDepth(TreeNode root) {
       return  ok(root,0);
    }
}
