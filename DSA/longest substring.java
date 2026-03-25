class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> se = new HashSet<>();
        int res = 0;
        int l  = 0;
        for(int r = 0;r<s.length();r++) {
            char c= s.charAt(r);
        while(se.contains(c)) {
            se.remove(s.charAt(l));
            l++;
        }
        se.add(c);
        res = Math.max(res,r-l+1);
        }
        return res;
    }
}