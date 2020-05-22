public class sqrt_69 {

	public int mySqrt(int x) {
		if (x < 4)
			return x == 0 ? 0 : 1;
		int res = 2 * mySqrt(x / 4);
		if ((res + 1) * (res + 1) <= x && (res + 1) * (res + 1) >= 0)
			return res + 1;
		return res;
	}

	public static void main(String[] args) {
		sqrt_69 sqrt = new sqrt_69();
		int result = sqrt.mySqrt(9);
		System.out.println(result);
	}
}