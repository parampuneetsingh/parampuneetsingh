
public class MedianOfTwoSortedArrays_4 {

	public int findMedian(int[] ary1, int[] ary2) {
		
		if (ary1.length > ary2.length) {
			int[] temp = ary1;
			ary1 = ary2;
			ary2 = temp;
		}
		
		int halfLength = (ary1.length + ary2.length + 1) / 2;
		
		int start = 0;
		int end = ary1.length;
		
		while (start <= end) {
			int i = (start + end) / 2;
			int j = halfLength - i;
			
			if (i < end && ary2[j - 1] > ary1[i]) {
				start = start + 1;
			}
			else if (i > start && ary1[i - 1] > ary2[j]) {
				end = end - 1;
			}
			else {
				int maxLeft = 0;
				if (i==0) {
					maxLeft = ary2[j - 1];
				} else if(j==0) {
					maxLeft = ary1[i - 1];  
				} else {
					maxLeft = Math.max(ary1[i - 1], ary2[j - 1]); 
				}
				if ((start + end) % 2 == 1) {
					return maxLeft;
				}
				
				int minRight = 0;
                if (i == start) { minRight = ary2[j]; }
                else if (j == end) { minRight = ary1[i]; }
                else { minRight = Math.min(ary2[j], ary1[i]); }

                return (maxLeft + minRight) / 2;
			}
			
		}
			return 0;
		}
		
	public static void main(String[] args) {
		
		int[] ary1 = {1,3,8,9,15};
		int[] ary2 = {7,11,18,19,21,25};
		MedianOfTwoSortedArrays_4 median = new MedianOfTwoSortedArrays_4();
		System.out.println(median.findMedian(ary1, ary2)); //LeetCode Solution. For explanation, Watch https://www.youtube.com/watch?v=LPFhl65R7ww&t=398s
	}

}
