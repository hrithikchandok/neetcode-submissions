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

    int find_in(int inorder[],int target){
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==target)return i;
        }
        return -1;
    }
    TreeNode ok(int []preorder,int []inorder,int l,int h,int index){
        if(l>h)return null;
        TreeNode curr;
        curr=new TreeNode(preorder[index]);
        
        int find_index=find_in(inorder,preorder[index]);
        int leftSubtreeSize = find_index - l;
       
            curr.left=ok(preorder,inorder,l,find_index-1,index+1);
            curr.right=ok(preorder,inorder,find_index+1,h,index+leftSubtreeSize+1);
        
        return curr;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // TreeNode root=new TreeNode(preorder[0]);
        int n=inorder.length-1;
        return ok(preorder,inorder,0,n,0);
       
    }
}
