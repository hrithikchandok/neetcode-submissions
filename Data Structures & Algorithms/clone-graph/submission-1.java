/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null)return null;
        HashMap<Node, Node> mp = new HashMap<>();
        Queue<Node> q1 = new LinkedList<>();
        q1.add(node);
        while (q1.size() > 0) {
            Node curr = q1.poll();
            if (!mp.containsKey(curr)) {
                Node newNode = new Node(curr.val);
                mp.put(curr, newNode);
            }
            for (Node negbour : curr.neighbors) {
                if (!mp.containsKey(negbour)) {
                    q1.add(negbour);
                    Node newNode2 = new Node(negbour.val);
                    mp.put(negbour, newNode2);
                }
                mp.get(curr).neighbors.add(mp.get(negbour));
            }
        }
        return mp.get(node);
    }
}