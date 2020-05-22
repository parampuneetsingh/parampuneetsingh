
public class LongestCommonPrefixImp_14 {
    public String longestCommonPrefix(String[] strs) {
        int resp = 0;
        int temp = 0;
        
        String smallString = strs[0];
        for (int i=1; i<strs.length; i++) {
            if (strs[i].length() < smallString.length() ) {
                smallString = strs[i];
            }
        }
        for (int j=0; j<smallString.length();j++) {
            if (temp == -1) {
                break;
            }
            
            for (int ary=0; ary<strs.length;ary++) {
                if (strs[ary].charAt(j) != smallString.charAt(j)) {
                    temp=-1;
                    }
                }
            resp++;
            }
        return smallString.substring(0,resp-1);
        }
    

    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }        
        return prefix;
    }
    
    public String longestCommonPrefix3(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        int[] ary = new int[26];
        StringBuilder sb = new StringBuilder();
        
        for(String s:strs) {
            minLength = Math.min(minLength, s.length());
        }
        
        for (int i=0; i<minLength; i++) {
            char c = 0;
            for (int j=0; j<strs.length; j++) {
                c = strs[j].charAt(i);
                ary[c - 'a']++;
            }
            if (ary[c - 'a'] == strs.length) {
                sb.append(c);
                ary[c - 'a'] = 0;
            } else {
                break;
            }
        }
        
        return sb.toString();
    }
    
	public static void main(String[] args) {
		String[] strs = {"apple", "ape", "april"};
		//String[] strs = {"aa", "aa"};
		LongestCommonPrefixImp_14 lcp = new LongestCommonPrefixImp_14();
		//System.out.println(lcp.longestCommonPrefix(strs));
		System.out.println(lcp.longestCommonPrefix3(strs)); //Leetcode solution
	}

}
