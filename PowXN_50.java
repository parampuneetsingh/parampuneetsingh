public class PowXN_50 {

	private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }
    
	public static void main(String[] args) {
	PowXN_50 power = new PowXN_50();
	double resp = power.myPow(2, 3);
	System.out.println(resp);
	}
}