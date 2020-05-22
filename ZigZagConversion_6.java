
public class ZigZagConversion_6 {

	public String convert(String s, int numRows) {
		char[] c = s.toCharArray();
		int len = c.length;
		StringBuffer[] sb = new StringBuffer[numRows];
		for (int i = 0; i < sb.length; i++)
			sb[i] = new StringBuffer();

		int i = 0;

		while (i < len) {
			for (int idx = 0; idx < numRows && i < len; idx++) // vertically down
				sb[idx].append(c[i++]);
			for (int idx = numRows - 2; idx >= 1 && i < len; idx--) // obliquely up
				sb[idx].append(c[i++]);
		}
		for (int idx = 1; idx < sb.length; idx++)
			sb[0].append(sb[idx]);
		return sb[0].toString();
	}

	public static void main(String[] args) {
		String str = "PAYPALISHIRING";
		int rows = 3;
		ZigZagConversion_6 zigzag = new ZigZagConversion_6();
		String resp = zigzag.convert(str, rows);
		System.out.println(resp);
	}
}