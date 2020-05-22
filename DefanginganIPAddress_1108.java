//https://leetcode.com/problems/defanging-an-ip-address/

public class DefanginganIPAddress_1108 {

	public static String defangIPaddr(String address) {
		StringBuilder sb = new StringBuilder();

		String[] strSplit = address.split("\\.");
		for (int i = 0; i < strSplit.length; i++) {
			sb.append(strSplit[i] + "[.]");
		}
		return sb.toString().substring(0, sb.length() - 3);
	}

	public static void main(String[] args) {
		String address = "1.1.1.1";
		System.out.println(defangIPaddr(address));
	}

}
