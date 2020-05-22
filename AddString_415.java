
public class AddString_415 {

	public static String addStrings(String num1, String num2) {
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        StringBuilder str = new StringBuilder();
        int carry = 0;
        
        while (l1 >= 0 || l2 >= 0 || carry > 0) {
            if (l1 >= 0 && l2 >=0) {
                int temp = num1.charAt(l1) - '0' + (int) num2.charAt(l2) - '0' + carry;
                carry=0;
                if (temp / 10 > 0) {
                    carry = 1;
                }
                    str.append(temp % 10);
                    l1--;
                    l2--;
                }
            
            else if (l1 >= 0) {
                int temp = num1.charAt(l1) - '0' + carry;
                carry=0;
                if (temp / 10 > 0) {
                    carry = 1;
                }
                l1--;
                str.append(temp % 10);
                }
            else if (l2 >= 0) {
                int temp = num2.charAt(l2) - '0' + carry;
                carry=0;
                if (temp / 10 > 0) {
                    carry = 1;
                }
                l2--;
                str.append(temp%10);
                }
            
            else if (carry != 0) {
            	str.append(carry);
            	carry = 0;
            }
            }
            
            return str.reverse().toString();
            }

	public static void main(String[] args) {
		addStrings("9", "99");
	}

}
