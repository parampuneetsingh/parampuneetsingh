//https://leetcode.com/problems/validate-ip-address/

public class ValidateIPAddress_468 {

	public static String validIPAddress(String IP) {
		int count = 0;

		if (IP.contains(".")) {
			String[] splitIP = IP.split("\\.");

			for (String str : splitIP) {
				count++;
				if (count > 4 || str.isEmpty() || (str.length() > 1 && str.startsWith("0")) || str.length() > 3) {
					return "Neither";
				}
				for (char c : str.toCharArray()) {
					if (c < '0' || c > '9')
						return "Neither";
				}

				int val = Integer.parseInt(str);
				if (val < 0 || val > 255)
					return "Neither";
			}
			return count == 4 && IP.charAt(IP.length() - 1) != '.' ? "IPv4" : "Neither";
		}

		else {
			String[] splitIP = IP.split(":");

			for (String str : splitIP) {
				count++;
				if (count > 8 || str.isEmpty() || str.length() > 4) {
					return "Neither";
				}
				for (char c : str.toCharArray()) {
					if (!(c >= '0' && c <= '9') && !(c >= 'a' && c <= 'f') && !(c >= 'A' && c <= 'F'))
						return "Neither";
				}
			}

			return count == 8 && IP.charAt(IP.length() - 1) != ':' ? "IPv6" : "Neither";
		}

	}

	public static void main(String[] args) {
		String IP = "172.16.254.1";
		// String IP = "2001:0db8:85a3:0000:0000:8a2e:0370:7334";
		System.out.println(validIPAddress(IP));
	}

}
