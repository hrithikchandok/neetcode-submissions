class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int [][]ans=new int[k][2];
        PriorityQueue<int[]>pq=new PriorityQueue<>((int a[] , int b[])->Integer.compare(b[0],a[0]));
        for(int i[]:points){
            int f=i[0];
            int s=i[1];
            int dis=(int)(Math.pow(f,2)+Math.pow(s,2));
            pq.add(new int[]{dis,f,s});
            if(pq.size()>k){
                pq.poll();
            }
        }
        for(int i=0;i<k;i++){
            int tmep[]=pq.poll();
            ans[i][0]=tmep[1];
            ans[i][1]=tmep[2];
        }
        return ans;
    }
}
