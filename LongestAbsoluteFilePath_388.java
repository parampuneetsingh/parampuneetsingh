import java.util.HashMap;

//https://leetcode.com/problems/longest-absolute-file-path/

public class LongestAbsoluteFilePath_388 {

	public static int lengthLongestPath(String input) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		int max = 0;

		String[] str = input.split("\n");

		for (String s : str) {
			int level = 0;
			while (s.startsWith("\t")) {
				level++;
				s = s.substring(1);
			}

			if (s.contains(".")) {
				int l = s.length();
				int temp = level - 1;
				while (map.containsKey(temp)) {
					l += map.get(temp).length() + 1;
					temp--;
				}
				max = Math.max(max, l);
			} else {
				map.put(level, s);
			}
		}

		return max;
	}

	public static void main(String[] args) {
		String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
		System.out.println(lengthLongestPath(input));
	}

}
