class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]>merged=new ArrayList<>();

        int currentInterval[]=intervals[0];
        merged.add(currentInterval);

        for(int[] interval:intervals){
            int nextStart=interval[0];
            int nextEnd=interval[1];
            int currentEnd=currentInterval[1];

            // overlapping 
            if(nextStart<=currentEnd){
                currentInterval[1]=Math.max(currentInterval[1],nextEnd);
            }else{
                merged.add(interval);
                currentInterval=interval;
            }
        }

        return merged.toArray(new int[merged.size()][]);



    }
}
