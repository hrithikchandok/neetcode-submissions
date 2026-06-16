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

// left all small 
// right all greater 
class Solution {
    boolean ok(TreeNode root,int mini,int maxi){
        if(root==null)return true;
        if(root.val>mini&&root.val<maxi){
            return ok(root.left,mini,root.val)&&ok(root.right,root.val,maxi);
        }
        return false;
    }
    public boolean isValidBST(TreeNode root) {
        return ok(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
}
