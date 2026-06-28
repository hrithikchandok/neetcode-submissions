/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node>old_new=new HashMap<>();
        Node p=head;
        Node head2=null;
        while(p!=null){
            if(!old_new.containsKey(p)){
                Node newNode=new Node(p.val);
                old_new.put(p,newNode);
            }
            p=p.next;
        }
        p=head;
        while(p!=null){
            if(p.next==null)
            old_new.get(p).next=null;
            else 
            old_new.get(p).next=old_new.get(p.next);
            if(p.random==null)
            old_new.get(p).random=null;
            else
            old_new.get(p).random=old_new.get(p.random);
            p=p.next;
        }
        // if(p.random==null){
        //         old_new.get(p).random=null;
        //         p=p.next;
        //         continue;}
        //     if(!old_new.containsKey(p.random)){
        //         Node newNode=new Node(p.random.val);
        //         old_new.put(p.random,newNode);
        //     }
        //     old_new.get(p).random=old_new.get(p.random);
        //     p=p.next;
        return old_new.get(head);
    }
}
