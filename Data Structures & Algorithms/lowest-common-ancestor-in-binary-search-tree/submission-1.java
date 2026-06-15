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
    TreeNode ok(TreeNode root,TreeNode p,TreeNode q){
        if(root==null)return null;
        if(root.val==p.val||root.val==q.val)return root;
        TreeNode left=ok(root.left,p,q);
        TreeNode right=ok(root.right,p,q);
        if(left!=null&&right!=null)return root;
        if(left==null)return right;
        else return left;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return ok(root,p,q);
    }
}
