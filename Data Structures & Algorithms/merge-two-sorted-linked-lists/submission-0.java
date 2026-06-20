/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode root=null;
        ListNode dummy=new ListNode();
        ListNode p1=list1,p2=list2;
        while(p1!=null&&p2!=null){
            if(p1.val<=p2.val){
                if(root==null)
                root=p1;
                dummy.next=p1;
                dummy=p1;
                p1=p1.next;            
            }else{
                if(root==null)root=p2;
                dummy.next=p2;
                dummy=p2;
                p2=p2.next;
            }
        }
        if(p1!=null){
            if(root==null)
            root=p1;
            dummy.next=p1;
        }
        if(p2!=null){
            if(root==null)
            root=p2;
            dummy.next=p2;
        }
        return root;
    }
}