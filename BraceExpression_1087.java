import java.util.ArrayList;
import java.util.List;

//https://github.com/openset/leetcode/tree/master/problems/brace-expansion
//https://www.youtube.com/watch?v=tJPpHxPEXX0

public class BraceExpression_1087 {

	private static void dfs(List<String> list, List<String> res, StringBuilder sb, int pos) {
		if (sb.length() == list.size()) {
			res.add(sb.toString());
			return;
		}
		
		for (char c:list.get(pos).toCharArray()) {
			sb.append(c);
			dfs(list, res, sb, pos+1);
			sb.setLength(sb.length() - 1);
		}
	}
	
	public static String[] expand(String s) {
		List<String> lst = new ArrayList<String>();
		
		int n = s.length();
		
		for (int i=0; i<n; i++) {
			char c = s.charAt(i);
			if (c == '{') {
				int j = i+1;
				StringBuilder sb = new StringBuilder();
				while (j < n && s.charAt(j) != '}') {
					if (Character.isLetter(s.charAt(j))) {
						sb.append(s.charAt(j));
					}
					j++;
				}
				lst.add(sb.toString());
				i=j;
			} else {
				lst.add(s.charAt(i)+"");
			}
		}
		
		List<String> res = new ArrayList<String>();
		dfs(lst, res, new StringBuilder(), 0);
		
		int size = res.size();
		int index = 0;
		String[] result = new String[size];
		
		for (String str:res) {
			result[index++] = str;
		}
		
		return result;
	}

	public static void main(String[] args) {
		String s = "{a,b,c}d{e,f}";
		expand(s);
	}

}
