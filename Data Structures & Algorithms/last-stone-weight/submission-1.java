class Solution {
    public int lastStoneWeight(int[] nums) {
        PriorityQueue<Integer>pq=new PriorityQueue<>((Integer a ,Integer b)->(b-a));
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        while(pq.size()>1){
            int f=pq.poll();
            int s=pq.poll();
            if(f!=s) {
                int temp=Math.abs(f-s);
                pq.add(temp);
            }
        }
        if(pq.size()==0)return 0;
        return pq.peek();
    }
}
