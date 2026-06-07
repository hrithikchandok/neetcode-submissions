class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<int[]>li=new ArrayList<>();
        int fleet=0;
        double prevTime=0;
        int n=speed.length;
        for(int i=0;i<n;i++){
            li.add(new int[]{position[i],speed[i]});
        }
        li.sort((a,b)->Integer.compare(b[0],a[0]));
        for(int i=0;i<n;i++){
            int post=li.get(i)[0];
            int sp=li.get(i)[1];
            double currTime = (double)(target-post)/sp;
            if(prevTime==0){
                prevTime=currTime;
                fleet=1;
            }else{
                if(currTime>prevTime){
                    fleet++;
                    prevTime=currTime;
                }
            }
        }
        return fleet;
    }
}
