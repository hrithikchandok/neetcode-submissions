class Pair{
    Integer val;
    Integer min;
    Pair(Integer val,Integer min){
        this.val=val;
        this.min=min;
    }
}
class MinStack {
    Stack<Pair>st;
    public MinStack() {
        st=new Stack<>();
    }
    
    public void push(int val) {
        if(st.size()==0)st.push(new Pair(val,val));
        else{
            int min=st.peek().min;
            st.push(new Pair(val,Math.min(min,val)));
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().val;
    }
    
    public int getMin() {
        return st.peek().min;
    }
}
