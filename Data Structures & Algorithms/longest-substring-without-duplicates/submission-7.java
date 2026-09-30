public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> currentChars = new HashSet<>();
        int l = 0;
        int max_size = 0;
        if(s.isEmpty())
            return 0;
        for(int r=0; r<s.length();r++){
            while(currentChars.contains(s.charAt(r))){
                currentChars.remove(s.charAt(l));
                l++;
            }
            currentChars.add(s.charAt(r));
            max_size = Math.max(max_size, r-l+1);        
        }
        return max_size;
    }
}