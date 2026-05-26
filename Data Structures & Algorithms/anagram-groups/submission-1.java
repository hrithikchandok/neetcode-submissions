class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>res=new HashMap<>();
        // sorting each string 
        // tc O(n*mlogm)
        // sc O(n)
        // for(String curr:strs){
        //     char temp[]=curr.toCharArray();
        //     Arrays.sort(temp);
        //     String sorted_string=new String(temp);
        //     res.putIfAbsent(sorted_string,new ArrayList<>());
        //     res.get(sorted_string).add(curr);
        // }
        // return new ArrayList<>(res.values());


        // without sorting 
        for(String curr:strs){
            int count[]=new int[26];
            for(char ch:curr.toCharArray()){
                count[ch-'a']++;
            }
            String sorted_string=Arrays.toString(count);
            res.putIfAbsent(sorted_string,new ArrayList<>());
            res.get(sorted_string).add(curr);
        }
        return new ArrayList<>(res.values());

        
    }
}
