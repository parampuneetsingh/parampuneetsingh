//https://leetcode.com/problems/trapping-rain-water/
//https://www.ideserve.co.in/learn/trapping-rain-water-between-towers

public class TrappingRainWater_42 {

	// Dynamic Programming solution
	public static int getMaxRainwaterBetweenTowers(int[] towerHeight) {
		int maxSeenSoFar = 0;

		int[] maxSeenRight = new int[towerHeight.length];
		int maxSeenLeft = 0;

		int rainwater = 0;

		for (int i = towerHeight.length - 1; i >= 0; i--) {
			if (towerHeight[i] > maxSeenSoFar) {
				maxSeenSoFar = towerHeight[i];
			}
			maxSeenRight[i] = maxSeenSoFar;
		}

		for (int i = 0; i < towerHeight.length; i++) {
			rainwater += Math.max(Math.min(maxSeenLeft, maxSeenRight[i]) - towerHeight[i], 0);
			if (towerHeight[i] > maxSeenLeft) {
				maxSeenLeft = towerHeight[i];
			}
		}

		return rainwater;
	}

	// Dynamic Programming solution
	public static int getMaxRainwaterBetweenTowers2(int[] towerHeight) {
		int maxSeenLeftSoFar = 0;
		int maxSeenRightSoFar= 0;

		int[] minSeenLeft = new int[towerHeight.length];
		int[] maxSeenRight = new int[towerHeight.length];

		int rainwater = 0;

		for (int i = 0; i < towerHeight.length; i++) {
			if (towerHeight[i] > maxSeenLeftSoFar) {
				maxSeenLeftSoFar = towerHeight[i];
			}
			minSeenLeft[i] = maxSeenLeftSoFar;
		}

		for (int i = towerHeight.length - 1; i >= 0; i--) {
			if (towerHeight[i] > maxSeenRightSoFar) {
				maxSeenRightSoFar = towerHeight[i];
			}
			maxSeenRight[i] = maxSeenRightSoFar;
		}

		for (int i = 1; i < towerHeight.length; i++) {
			rainwater += Math.min(minSeenLeft[i], maxSeenRight[i]) - towerHeight[i];
		}

		return rainwater;
	}

	public static void main(String[] args) {
		int[] towerHeight = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(getMaxRainwaterBetweenTowers2(towerHeight));
	}

}
