class Solution {
    private boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        Arrays.sort(s1Array);
        Arrays.sort(s2Array);
        return Arrays.equals(s1Array, s2Array);
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if(strs[i]==null){
                continue;
            }
            temp.add(strs[i]);
            for (int j = i + 1; j < strs.length; j++) {
                if(strs[j]==null){
                    continue;
                }
                if (isAnagram(strs[i], strs[j])) {
                    temp.add(strs[j]);
                    strs[j] = null;
                }
            }
            res.add(temp);
            temp = new ArrayList<>();
            strs[i] = null;
        }
        return res;
    }
}
