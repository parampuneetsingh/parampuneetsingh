/*Longest Substring without repeating characters
Given "abcabcbb", the answer is "abc", which the length is 3.
Given "bbbbb", the answer is "b", with the length of 1.
Given "pwwkew", the answer is "wke", with the length of 3. 
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.*/

public class LongestSubstring_3 {
	
	public int lengthOfLongestSubstring2(String s) {
		int[] mOccur = new int[256];
        int maxL = 0;
        for(int i = 0, j = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            ++mOccur[ch];
            while(mOccur[ch] > 1){
                --mOccur[s.charAt(j++)];
            }
            maxL = Math.max(maxL, i - j + 1);
        }
        return maxL;
    }

	public static void main(String[] args) {
		String str = "abcabcbb";
		LongestSubstring_3 lols = new LongestSubstring_3();
		System.out.println(lols.lengthOfLongestSubstring2(str)); //Solution from Leetcode
	}

}
