class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int ans=0;
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));
        int []currentIntervals=intervals[0];
        int n=intervals.length;
        // [1,100][1,11][2,12][11,12]
        for(int i=1;i<n;i++){
            //overlapping 
            // [1,2][1,4]
            if(currentIntervals[1]>intervals[i][0]){
                if(intervals[i][1]<currentIntervals[1]){
                    currentIntervals=intervals[i];
                }
                ans++;
            }
            else {
                currentIntervals=intervals[i];
            }
            // non overlapping 
        }
        return ans;
    }
}
