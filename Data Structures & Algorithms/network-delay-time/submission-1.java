class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int maxTime=0;
        // make adj list 
        Map<Integer,List<int[]>>mp=new HashMap<>();
        for(int time[]:times){
            mp.computeIfAbsent(time[0],t->new ArrayList<>()).add(new int[]{time[1],time[2]});
        }
        // add new int[]{node, time}
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        Queue<int[]>q1=new LinkedList<>();
        HashSet<Integer>visited=new HashSet<>();
        pq.add(new int[]{k,0});
        int currTime=0;
        while(!pq.isEmpty()){
            int curr[]=pq.poll();
            int node=curr[0];
            int time=curr[1];
           
            if(visited.contains(node))continue;
            maxTime=Math.max(maxTime,time);
            visited.add(node);
            List<int[]> neigh = mp.getOrDefault(node, new ArrayList<>());
            for(int ele[]:neigh){
                int newNode =ele[0];
                int newtime=ele[1];
                if(!visited.contains(newNode)){
                    pq.add(new int[]{newNode,newtime+time});
                }
            }
        }
        if(visited.size()==n)return maxTime;
        return -1;
    }
}
