//https://leetcode.com/problems/hamming-distance/

public class HammingDistance_461 {

	// Better Solution
	public int hammingDistance(int x, int y) {

		int dist = 0;

		for (int i = 0; i < 32; i++) {
			int a = (x & (1 << i)); // This will check if Bit is Set or Not at i-th position in 32 bits
			int b = (y & (1 << i));

			if (a != b) {
				dist++;
			}
		}

		return dist;
	}

	public static void main(String[] args) {

		HammingDistance_461 findDist = new HammingDistance_461();
		System.out.println(findDist.hammingDistance(1, 4));
	}
}
