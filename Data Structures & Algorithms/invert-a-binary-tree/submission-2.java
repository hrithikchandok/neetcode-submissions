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
    void ok(TreeNode root){
        Queue<TreeNode>q1=new LinkedList<>();
        q1.add(root);
        while(!q1.isEmpty()){
            int k=q1.size();
            for(int i=0;i<k;i++){
                TreeNode curr=q1.poll();
                if(curr!=null){
                    
                TreeNode temp=curr.right;
                curr.right=curr.left;
                curr.left=temp;
                if(curr.left!=null)q1.add(curr.left);
                if(curr.right!=null)q1.add(curr.right);
                }
            }
        }
    }
    public TreeNode invertTree(TreeNode root) {
        ok(root);
        return root; 
    }
}
