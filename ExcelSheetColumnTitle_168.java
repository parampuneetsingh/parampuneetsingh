
public class ExcelSheetColumnTitle_168 {

	public String convertToTitle(int n) {
		String str = "";
        while(n!=0) {
        	int div = (--n)%26;  
        	str = (char) (div + 'A') + str;
        	n = n/26;
        }

        return str;
    }

	public static void main(String[] args) {
		ExcelSheetColumnTitle_168 col = new ExcelSheetColumnTitle_168();
		String result = col.convertToTitle(701);
		//System.out.println(((char) 26) + 'A');
		System.out.println(result);
	}

}
