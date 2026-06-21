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
    private ListNode reverse(ListNode root){
        ListNode p=root,q=null,r=null;
        while(p!=null){
            r=q;
            q=p;
            p=p.next;
            q.next=r;
        }
        return q;
    }
    private void Merge(ListNode root,ListNode root2){
        ListNode temp=root;
        root=root.next;
        while(root!=null&&root2!=null){
            temp.next=root2;
            root2=root2.next;
            temp=temp.next;
            temp.next=root;
            root=root.next;
            temp=temp.next;
        }
        if(root2!=null)temp.next=root2;
        if(root!=null)temp.next=root;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode temp=head;
        ListNode f,s=null;
        f=head;s=head;
        ListNode prev=null;
        while(f!=null&&f.next!=null){
            f=f.next.next;
            prev=s;
            s=s.next;
        }
        prev.next=null;
        temp=reverse(s);

        Merge(head,temp);
        
    }
}
