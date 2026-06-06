class Pair{
    Integer val;
    Integer index;
     Pair(Integer val,Integer index){
        this.val=val;
        this.index=index;
    }
}
class Solution {
    PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->Integer.compare(b.val,a.val));
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int size=n%k==0?n:n+1;
        int index=0;
        int[] ans = new int[n - k + 1];
        for(int i=0;i<k;i++){
            pq.add(new Pair(nums[i],i));
        }
        ans[index++]=pq.peek().val;
        for(int i=k;i<n;i++){
// 3. Changed polling logic to check window boundaries
            while (pq.size() > 0 && pq.peek().index <= i - k) {
                pq.poll();
            }
            pq.add(new Pair(nums[i],i));
            ans[index++]=pq.peek().val;
        }
        return ans;

    }
}
