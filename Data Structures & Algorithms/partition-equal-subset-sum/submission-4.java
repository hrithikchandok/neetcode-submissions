class Solution {
    Boolean ok(int index,int nums[],int target,Boolean dp[][]){
        if(index==nums.length&&target!=0)return false;
        if(target==0)return true;
        if(dp[index][target]!=null)return dp[index][target];
        Boolean take=false,not_take=false;
        if(nums[index]<=target){
            take=ok(index+1,nums,target-nums[index],dp);
        }
        not_take=ok(index+1,nums,target,dp);
        dp[index][target]= take||not_take;
        return dp[index][target];
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int ele:nums){sum+=ele;}
        int target=sum/2;
        if(sum%2==1)return false;
        Boolean dp[][]=new Boolean[nums.length][target+1];
        // for(int arr[]:dp){Arrays.fill(arr,-1);};

        return ok(0,nums,target,dp);
    }
}
