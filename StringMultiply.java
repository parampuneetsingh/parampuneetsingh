
public class StringMultiply {

	public String multiply(String num1, String num2) {
		int length1 = num1.length();
		int length2 = num2.length();
		int carry = 0;
		int[] product = new int[length1 + length2];

		for (int i = num1.length() - 1; i >= 0; i--) {
			for (int j = num2.length() - 1; j >= 0; j--) {
				int d1 = num1.charAt(i) - '0'; 
                int d2 = num2.charAt(j) - '0';
                product[i + j + 1] += d1 * d2;
			}
		}
		for (int i = product.length - 1; i >= 0; i--) {
            int tmp = (product[i] + carry) % 10;
            carry = (product[i] + carry) / 10;
            product[i] = tmp;
        }
		int i = 0;
		StringBuilder strBuild = new StringBuilder();
		while (product[i] == 0) {
			i++;
		}
		while (i < length1 + length2) {
			strBuild.append(product[i]);
			i++;
		}
		return strBuild.toString();
	}

	public static void main(String[] args) {
		String str1 = "110";
		String str2 = "276";

		StringMultiply strMul = new StringMultiply();
		String resp = strMul.multiply(str1, str2);
		System.out.println(resp);
	}

}
