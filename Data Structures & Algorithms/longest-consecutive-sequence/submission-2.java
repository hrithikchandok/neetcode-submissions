class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer>s1=new HashSet<>();
        
        int n=nums.length;
        if(n==0)return 0;
        for(int i=0;i<n;i++){
            s1.add(nums[i]);
        }
        int max_length=1;
        for(int i=0;i<n;i++){
            int len=1;
            int ele=nums[i];
            if(s1.contains(ele-1)){continue;}
            while(s1.contains(ele+1)){
                len++;
                ele++;
                max_length=Math.max(max_length,len);
            }
        }
        return max_length;
    }
}
