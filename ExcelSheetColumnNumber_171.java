//https://leetcode.com/problems/excel-sheet-column-number/

public class ExcelSheetColumnNumber_171 {

    public int titleToNumber(String s) {
        char[] charAry = s.toCharArray();
        int sum = 0;
        int resp = 0;
        for (int i=0; i<charAry.length; i++) {
            int temp = charAry[i] - 'A';
            sum = resp + temp + 1;
            resp = sum * 26;
        }
        return sum;
    }
    
	public static void main(String[] args) {
		ExcelSheetColumnNumber_171 excl = new ExcelSheetColumnNumber_171();
		excl.titleToNumber("ZY");
	}

}
