class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0;
        int windowSize = 0;
        int maxFreq = 0;
        int ans = 0;
        HashMap<Character, Integer> mp = new HashMap<>();
        while (right < s.length()) {
            char ch = s.charAt(right);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, mp.get(ch));
            while (((right - left + 1) - maxFreq) > k) {
                int val = mp.get(s.charAt(left));
                mp.put(s.charAt(left), --val);
                left++;
            }
            if((right-left+1)-maxFreq<=k)
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
