package leetCode;

//Given a string s, find the length of the longest substring without duplicate characters.

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        char[] cs = s.toCharArray();
        if (cs.length==0) return 0;
        int maxl = 0;
        String ans ="";
        for (int i = 0; i < cs.length; i++) {
            if(ans.indexOf(cs[i])!=-1) {
                ans = ans.substring(ans.indexOf(cs[i])+1);
            }
            ans = ans + cs[i];
            if(maxl<ans.length()){
                maxl = ans.length();
            }
        }
        return maxl;
    }
}
