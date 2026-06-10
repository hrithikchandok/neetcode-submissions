class KthLargest {
    PriorityQueue<Integer>pq=new PriorityQueue<>();
    int capacity;
    public KthLargest(int k, int[] nums) {
        capacity=k;
        for(int ele:nums){
            add(ele);
        }
    }
    
    public int add(int val) {
       if(pq.size()<capacity)pq.add(val);
       else {
         if(pq.peek()<=val){
            pq.poll();
            pq.add(val);
         }
       }
       return pq.peek();
    }
}
