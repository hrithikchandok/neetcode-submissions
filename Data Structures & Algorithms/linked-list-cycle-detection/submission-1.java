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
    public boolean hasCycle(ListNode head) {
        if(head==null)return false;
        ListNode f=head.next,s=head;
        while(f!=null&&f.next!=null){
            if(f==s){
                return true;
            }
            f=f.next.next;
            s=s.next;
        }
        return false;
    }
}
