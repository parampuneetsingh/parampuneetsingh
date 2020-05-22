import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/restore-ip-addresses/
//https://github.com/awangdev/LeetCode/blob/master/Java/Restore%20IP%20Addresses.java

public class RestoreIPAddresses_93 {

	/*
	 * Thoughts: NOT DONE. NEED CLEAR MIND Break into 4 parts. At each index, either
	 * close it as one IP spot, or not. recursive down. If level == 4 validate if
	 * valid IP address. If so, add it. pass along: rst, list (store the 4 IP
	 * spots), level (0 ~ 3), s, for (0 ~ 2): can pick 1 digit, 2 digits, or 3
	 * digits
	 */
	public List<String> restoreIpAddresses(String s) {
		List<String> rst = new ArrayList<String>();
		if (s == null || s.length() == 0) {
			return rst;
		}
		if (s.length() < 4 || s.length() > 12) {
			return rst;
		}
		ArrayList<String> list = new ArrayList<String>();
		helper(rst, list, 0, s);

		return rst;
	}

	public void helper(List<String> rst, ArrayList<String> list, int start, String s) {
		if (list.size() == 4) {
			if (start != s.length()) {
				return;
			}
			StringBuffer sb = new StringBuffer();
			for (String str : list) {
				sb.append(str + ".");
			}
			rst.add(sb.substring(0, sb.length() - 1).toString());
			return;
		}
		// run for loop 3 times: one IP spot has at most 3 digits
		for (int i = start; i < s.length() && i <= start + 3; i++) {
			String temp = s.substring(start, i + 1);
			if (isValid(temp)) {
				list.add(temp);
				helper(rst, list, i + 1, s);
				list.remove(list.size() - 1);
			}
		}
	}

	// Valid the IP [0,255]; cannot start with 0 if it's not 0
	public boolean isValid(String str) {
		if (str.charAt(0) == '0') {
			return str.equals("0");
		}
		int num = Integer.parseInt(str);
		return num <= 255 && num >= 0;
	}

	// Time Complexity O(1) and Space complexity O(1) because we have constant value
	// of IP addresses
	public static void main(String[] args) {
		RestoreIPAddresses_93 restore = new RestoreIPAddresses_93();
		String str = "25525511135";
		System.out.println(restore.restoreIpAddresses(str));
	}

}
