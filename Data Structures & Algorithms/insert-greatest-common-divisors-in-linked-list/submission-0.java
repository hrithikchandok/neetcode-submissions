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
    int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode p1=head;
        while(p1!=null&&p1.next!=null){
            ListNode t1=p1;
            ListNode t2=p1.next;
            int no=gcd(t1.val,t2.val);
            ListNode temp =new ListNode(no);
            temp.next=t2;
            t1.next=temp;
            p1=temp.next;
        }
        return head;
    }
}