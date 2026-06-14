class Solution {
    public int[] findOrder(int n, int[][] nums) {

        int indegree[]=new int[n];
        List<Integer>li=new ArrayList<>();
        HashMap<Integer,List<Integer>>mp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int f=nums[i][0];
            int s=nums[i][1];
            mp.putIfAbsent(f,new ArrayList<>());
            mp.putIfAbsent(s,new ArrayList<>());
            mp.get(f).add(s);
            indegree[s]++;
        }
        Queue<Integer>q1=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q1.add(i);
            }
        }
        while(q1.size()>0){
            int curr=q1.poll();
            li.add(curr);
            List<Integer>neg=mp.getOrDefault(curr,new ArrayList<>());
            for(int ele:neg){
                indegree[ele]--;
                if(indegree[ele]==0)q1.add(ele);
            }
        }
        if(li.size()!=n)return new int[]{};
        int index=0;
        int ans[]=new int[li.size()];
        Collections.reverse(li);
        for(int ele:li){
            ans[index++]=ele;
        }
        return ans;
    }
}




