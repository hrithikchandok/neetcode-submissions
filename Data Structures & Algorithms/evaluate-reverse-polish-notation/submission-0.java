class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        
        for (String token : tokens) {
            if (token.equals("+")) {
                st.push(st.pop() + st.pop());
            } else if (token.equals("-")) {
                int val2 = st.pop(); 
                int val1 = st.pop(); 
                st.push(val1 - val2);
            } else if (token.equals("*")) {
                st.push(st.pop() * st.pop());
            } else if (token.equals("/")) {
                int val2 = st.pop();
                int val1 = st.pop(); 
                st.push(val1 / val2);
            } else {
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }
}