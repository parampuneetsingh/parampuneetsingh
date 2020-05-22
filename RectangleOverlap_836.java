//https://leetcode.com/problems/rectangle-overlap/

public class RectangleOverlap_836 {

	public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
		return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0])
				&& Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));
	}

	public static void main(String[] args) {
		int[] rec1 = { 0, 0, 2, 2 }, rec2 = { 1, 1, 3, 3 };
		System.out.println(isRectangleOverlap(rec1, rec2));
	}

}
