package leetCode;


//Given a string s, return the longest palindromic substring in s.
//
//Example 1:
//
//Input: s = "babad"
//Output: "bab"
//Explanation: "aba" is also a valid answer.
//Example 2:
//
//Input: s = "cbbd"
//Output: "bb"
//
//Constraints:
//
//1 <= s.length <= 1000
//s consist of only digits and English letters.


public class LongestPalindrome {

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {

            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);

            int maxLen = Math.max(len1, len2);

            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("rfvtmdqjppztlvotnstyqeildrnevqkcoiqndxxncftlhdychrutvzkcxjnduhssfiatzisxioyuqmxqpdiouixfhyjlnfsjupwjztuyklrweuqmkuygndrqfhhcxrxcwdwcwgsknxxmxiwqxjbbljnckdgofehoarikioabmisfuzraxcaryjzsjetrvvpavbhbajrsnvrfjorjzpcjmkoekaipinfzhuaegaxzzvlwclbzhqzbtvxtgfhojqhcnokzqbedusoywsfsgbwxbvrqgmzojdmhlmzwtcvvmhnytqqlkpwyesbztabhyfukhpbchhvtzoegykvbzrywjcntrmsyokklsnzwkpjdcdcayfauuxcydiubnonpumcogiwqsqzagxhwbvkcxojfvewzqjdbbwbudxndyvubbumrktckrgxtbanatsfsxtckueqqtldfnxeznozegxnzntynlfavlmdfgpwgebylkromwrwxflgylbrtbyjblvgrxlkuhwnjmzqkngdghjvrsgtppkgsmpxrsahxlakadliwxmnbztfadwoglocbvwvhgcmgnkdtlbnqbfepbupfticejjxjoogutfvckdvztgjuklczwiimstpstbreffkvcmvofanuxndahhftbvsbfgoagwptvszptjatyoemevxnpqxboiycubeoqfenopwcbzbfnqtixtqrpzatq"));
    }
}
