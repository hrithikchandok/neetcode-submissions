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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p=head;
        int len=0;
        while(p!=null){
            p=p.next;
            len++;
        }
        p=head;
        ListNode prev=null;
        int count=0;
        while(count<(len-n)){
            prev=p;
            p=p.next;
            count++;
        }
        if(prev==null)
        head=head.next;
        else
        prev.next=p.next;
        return head;
    }
}
