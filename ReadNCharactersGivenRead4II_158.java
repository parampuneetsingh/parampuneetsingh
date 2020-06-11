//https://www.lintcode.com/problem/read-n-characters-given-read4-ii-call-multiple-times/
//https://www.youtube.com/watch?v=5gO5syMOKnI

class Reader4 {
	int read4(char[] buf) {
		return 0;
	}
}

public class ReadNCharactersGivenRead4II_158 extends Reader4 {

	private char[] charBuf = new char[4];
	private int tmpPointer = 0;
	private int tmpCount = 0;

	public int read(char[] buf, int n) {
		int total = 0;

		while (total < n) {
			if (tmpPointer == 0) {
				tmpCount = read4(charBuf);
			}

			if (tmpCount == 0)
				break;

			while (total < n && tmpPointer < tmpCount) {
				buf[total++] = charBuf[tmpPointer++];
			}

			if (tmpPointer == tmpCount) {
				tmpPointer = 0;
			}

			if (tmpCount < 4)
				break;
		}

		return total;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
