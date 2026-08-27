class Solution {
    int houseRobber(int index,ArrayList<Integer>li,int dp[]){
        if(index==0)return li.get(index);
        if(index<0)return 0;
        if(dp[index]!=-1)return dp[index];
        int take,nottake;
        take=li.get(index)+houseRobber(index-2,li,dp);
        nottake=0+houseRobber(index-1,li,dp);
        return dp[index]=Math.max(take,nottake);
    }
    public int rob(int[] nums) {
        int n=nums.length;
       if (n == 1) return nums[0];
        ArrayList<Integer>li1=new ArrayList<>();
        ArrayList<Integer>li2=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i!=n-1)li1.add(nums[i]);
            if(i!=0)li2.add(nums[i]);
        }
        int d1[]=new int [li1.size()];
        int d2[]=new int[li2.size()]; 
        Arrays.fill(d1,-1);Arrays.fill(d2,-1);
        return Math.max(houseRobber(li1.size()-1,li1,d1),houseRobber(li2.size()-1,li2,d2));
    }
}
