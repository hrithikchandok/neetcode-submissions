class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zero_count=0;
        int product=1;
        int ans[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                zero_count++;
            else
                product*=nums[i];
            if(zero_count>1)return ans;
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)ans[i]=product;
            else if(zero_count>=1)
            ans[i]=0;
            else 
            ans[i]=product/nums[i];
        }
        return ans;
    }
}  
