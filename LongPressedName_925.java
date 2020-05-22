
public class LongPressedName_925 {

	public static boolean isLongPressedName(String name, String typed) {
		int i = 0;
		int j = 0;
		// i=0,1,2
		// j=0,1,2,3,4,5

		if (name.charAt(0) != typed.charAt(0)) {
			return false;
		}
			
		while (j < typed.length()) {
			if (name.charAt(i) == typed.charAt(j)) {
				j++;
			} else if (name.charAt(i + 1) == typed.charAt(j)) {
				while (j < typed.length() && i < name.length() - 1 && name.charAt(i+1) == typed.charAt(j)) {
					i++;
					j++;
				}
			} else {
				return false;
			}
		}

		return (i == name.length() - 1);
	}

	public static void main(String[] args) {
		String name = "yyxbtsrs"; 
		String typed = "yyyyxbbtssrs";
		System.out.println(isLongPressedName(name, typed));
	}

}
