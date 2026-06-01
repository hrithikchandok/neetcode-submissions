class Solution {
    public int maxProfit(int[] prices) {
        //o (n2)
        //o (1)
        int l=0;
        int h=1;
        int n=prices.length;
        int ans=0;
        while(h<n){
            if(prices[l]<prices[h])
            {
                ans=Math.max(prices[h]-prices[l],ans);
                h++;
            }
            else
            {
                l=h;
                h++;
            }
        }
        return ans;
    }
}
