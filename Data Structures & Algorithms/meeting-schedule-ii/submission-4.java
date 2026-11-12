/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size()==0)return 0;
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->a-b);
        Collections.sort(intervals,(a,b)->a.start-b.start);
        // pq.add(intervals.get(0).end);
        for(Interval interval:intervals){
            if(pq.size()>0){
            Integer min_ending=pq.peek();
            if(interval.start>=min_ending){
                pq.poll();
                
            }}
            pq.offer(interval.end);
        }
        return pq.size();
    }
}
