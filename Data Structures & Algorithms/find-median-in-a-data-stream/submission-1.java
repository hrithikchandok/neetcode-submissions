class MedianFinder {
    PriorityQueue<Integer>maxi;
    PriorityQueue<Integer>mini;
    public MedianFinder() {
        maxi=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        mini=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxi.add(num);
        mini.add(maxi.poll());
        if(mini.size()>(maxi.size())){
            int temp=mini.poll();
            maxi.add(temp);
        }
    }
    
    public double findMedian() {
        if(mini.size()+1==maxi.size())return maxi.peek();
        return (double)(maxi.peek()+mini.peek())/2;
    }
}
