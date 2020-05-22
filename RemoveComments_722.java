import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

//https://leetcode.com/problems/remove-comments/

public class RemoveComments_722 {

	public static List<String> removeComments(String[] source) {
		List<String> list = new ArrayList<String>();
		boolean inBlock = false;
		StringBuilder sb = new StringBuilder();

		for (String line : source) {
			if (!inBlock) {
				sb = new StringBuilder();
			}

			int i = 0;
			int n = line.length();

			while (i < n) {
				if (!inBlock && i + 1 < n && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
					inBlock = true;
					i++;
				} else if (inBlock && i + 1 < n && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
					inBlock = false;
					i++;
				} else if (!inBlock && i + 1 < n && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
					break;
				} else if (!inBlock) {
					sb.append(line.charAt(i));
				}
				i++;
			}

			if (!inBlock && sb.length() > 0) {
				list.add(sb.toString());
			}
		}

		return list;
	}

	public static void main(String[] args) {
		String[] source = { "/*Test program */", "int main()", "{ ", " // variable declaration ", "int a, b, c;",
				"/* This is a test", " multiline ", " comment for ", " testing */", "a = b + c;", "}" };

		// String[] source = { "a/*comment", "line", "more_comment*/b" };
		System.out.println(removeComments(source));
		
		String originalUrl = "https://www.google.co.nz/?gfe_rd=cr&ei=dzbFV&gws_rd=ssl#q=java";
		int encodedUrl = originalUrl.hashCode();
		System.out.println("Encoded -> " + encodedUrl);
	}

}
