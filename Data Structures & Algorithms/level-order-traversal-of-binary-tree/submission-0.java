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
    void ok(List<List<Integer>>ans,TreeNode root){
        if(root==null)return ;
        Queue<TreeNode>q1=new LinkedList<>();
        q1.add(root);
        while(q1.size()>0){
            int k=q1.size();
            List<Integer>temp=new ArrayList<>();
            for(int i=0;i<k;i++){
                TreeNode curr=q1.poll();
                temp.add(curr.val);
                if(curr.left!=null)q1.add(curr.left);
                if(curr.right!=null)q1.add(curr.right);
            }
            ans.add(temp);
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();
        ok(ans,root);
        return ans;
    }
}
