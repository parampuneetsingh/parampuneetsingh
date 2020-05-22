//https://leetcode.com/problems/container-with-most-water/
//https://www.youtube.com/watch?v=TI3e-17YAlc

public class ContainerWithMostWater_11 {

	public int maxWater(int[] height) {
		int maxWater = 0;
		int min = 0;
		int max = height.length - 1;
		int area;
		while (min < max) {
			area = Math.min(height[min],height[max]) * (max - min);
			maxWater = Math.max(maxWater, area);
			
			if (height[min] < height[max]) {
				min++;
			} else {
				max--;
			}
		}
		return maxWater;
	}
	
	public static void main(String[] args) {
		int[] lengthArray = {1,8,6,2,5,4,8,3,7};
		ContainerWithMostWater_11 maxVal = new ContainerWithMostWater_11();
		int resp = maxVal.maxWater(lengthArray);
		System.out.println(resp);
	}

}
