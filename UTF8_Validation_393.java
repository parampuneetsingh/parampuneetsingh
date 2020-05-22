//https://leetcode.com/problems/utf-8-validation/

public class UTF8_Validation_393 {
    
	public boolean validUtf8(int[] data) {
		int mask1 = 1 << 7;
		int mask2 = 1 << 6;

		int numberOfBytesToProcess = 0;

		for (int i = 0; i < data.length; i++) {

			if (numberOfBytesToProcess == 0) {
				int mask = 1 << 7;
				
				while ((data[i] & mask) != 0) {
					numberOfBytesToProcess++;
					mask = mask >> 1;
				}

				// 1 byte characters
				if (numberOfBytesToProcess == 0) {
					continue;
				}

				if (numberOfBytesToProcess > 4 || numberOfBytesToProcess == 1) {
					return false;
				}

			} else {
				if (!((data[i] & mask2) == 0 && (data[i] & mask1) != 0)) {
					return false;
				}
			}
			
			numberOfBytesToProcess--;
		}

		return numberOfBytesToProcess == 0;
	}

	public static void main(String[] args) {
		UTF8_Validation_393 valid = new UTF8_Validation_393();
		int[] data = { 197, 130, 1 };
		System.out.println(valid.validUtf8(data));
	}

}
