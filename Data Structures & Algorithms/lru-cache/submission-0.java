class LRUCache {
    class Node {
        int key;
        int value;
        Node next;
        Node prev;
        Node(int key,int value){
            this.key=key;
            this.value=value;
            next=null;
            prev=null;
        }
    }
    private int cap=0;
    private Node root;
    private Node first_dummy;
    private Node last_dummy;
    private HashMap<Integer,Node>mp;
    public LRUCache(int capacity) {
        cap=capacity;
        first_dummy=new Node(-1,-1);
        last_dummy=new Node(-1,-1);
        mp=new HashMap<>();
        root=null;
        first_dummy.next=last_dummy;
        last_dummy.prev=first_dummy;
    }
    private final void insert_first(Node temp){
         temp.next=first_dummy.next;
         temp.prev=first_dummy;
         first_dummy.next.prev=temp;
         first_dummy.next=temp;
    }
    private final void delete(Node temp){
        Node prev_node=temp.prev;
        Node next_node=temp.next;
        prev_node.next=next_node;
        next_node.prev=prev_node;
        temp.next=null;
        temp.prev=null;
    }

    public int get(int key) {
        if(!mp.containsKey(key))return -1;
        Node temp=mp.get(key);
        delete(temp);
        insert_first(temp);
        return temp.value;
    }
    
    public void put(int key, int value) {
        // new one 
        if(!mp.containsKey(key)){
            // delete least recently used 
           if(mp.size()==cap){
                mp.remove(last_dummy.prev.key);
                delete(last_dummy.prev);
           }
           if(mp.size()+1<=cap){
                Node newNode=new Node(key,value);
                mp.put(key,newNode);
                insert_first(newNode);
           }
        }else  // update 
        {
            Node toupdate=mp.get(key);
            toupdate.value=value;
            delete(toupdate);
            insert_first(toupdate);
        }
       
    }
}
