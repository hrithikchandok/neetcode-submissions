class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>res=new HashMap<>();
        // sorting each string 
        for(String curr:strs){
            char temp[]=curr.toCharArray();
            Arrays.sort(temp);
            String sorted_string=new String(temp);
            res.putIfAbsent(sorted_string,new ArrayList<>());
            res.get(sorted_string).add(curr);
        }
        return new ArrayList<>(res.values());
        
    }
}
