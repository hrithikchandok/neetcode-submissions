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

public class Codec {

    // Encodes a tree to a single string.

    public String serialize(TreeNode root) {
        if(root==null) return "N";
        StringBuilder s1=new StringBuilder();
        Queue<TreeNode>q1=new LinkedList<>();
        q1.add(root);
        while(q1.size()>0){
            TreeNode temp=q1.poll();
            if(temp==null){
                s1.append("N,");
            }else{
                s1.append(temp.val);
                s1.append(",");
                q1.add(temp.left);
                q1.add(temp.right);
            }
        }
        return s1.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("N"))return null;
        TreeNode root;
        // System.out.println("DATAis", data);
        String arr[]=  data.split(",");
        root=new TreeNode(Integer.parseInt(arr[0]));
        int index=1;
        Queue<TreeNode>q1=new LinkedList<>();
        q1.add(root);
        while(q1.size()>0){
            TreeNode temp=q1.poll();
            if(!arr[index].equals("N")){
                temp.left=new TreeNode(Integer.parseInt(arr[index]));
                q1.add(temp.left); 
            }
            index++;
            if(index<arr.length&& !arr[index].equals("N")){
                temp.right=new TreeNode(Integer.parseInt(arr[index]));
                q1.add(temp.right);
            }
            index++;
        }
        return root;
    }
}
