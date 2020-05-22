//https://leetcode.com/problems/gas-station/
//https://www.youtube.com/watch?v=KV2W-NPHPa4

public class GasStation_134 {

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int start = 0, defiliate = 0, tank = 0;

		for (int i = 0; i < gas.length; i++) {
			tank += gas[i] - cost[i];
			if (tank < 0) {
				start = i + 1;
				defiliate += tank;
				tank = 0;
			}
		}
		return (tank + defiliate >= 0) ? start : -1;
	}

	public static void main(String[] args) {
		int[] gas = { 1, 2, 3, 4, 5 };
		int[] cost = { 3, 4, 5, 1, 2 };
		System.out.println(canCompleteCircuit(gas, cost));
	}

}
