
public class ReverseString {

	public static void main(String[] args) {
		String str = "hello";
		char[] splitStr = str.toCharArray();
		int size = splitStr.length;
		for (int i = 0; i < splitStr.length/2; i++) {
			if (i != size-1 || i < size-1) {
				char temp = splitStr[i];
				splitStr[i] = splitStr[size - 1];
				splitStr[size - 1] = temp;
				size--;
			}
		}
		String strPrint = String.valueOf(splitStr);
		System.out.println(strPrint);
		//System.out.println(Math.pow(2, 31) - 1);
	}

}