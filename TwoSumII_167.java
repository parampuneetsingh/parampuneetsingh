public class TwoSumII_167 {

	public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;
        
        while(start < end) {
        if (numbers[start] + numbers[end] == target) {
            break;
        }
        if (numbers[start] + numbers[end] < target) {
            start++;
        } else {
            end--;
        }
       }
        
        return new int[]{start+1,end+1};
    }
	
	/* Solution 1
	public int[] twoSum(int[] numbers, int target) {
        int[] op = new int[2];
        List<Integer> lst = new ArrayList<Integer>();
        
        for (int k:numbers) {
            lst.add(k);    
        }
        
        for (int i=0;i<numbers.length;i++) {
            int temp = target - numbers[i];
            if (lst.contains(temp)) {
                op[0] = i + 1;
                op[1] = lst.lastIndexOf(temp) + 1;
                break;
            }
        }
        return op;
    }
	*/
	
	public static void main(String[] args) {
		TwoSumII_167 sum = new TwoSumII_167();
		int[] numbers = {2,7,11,15};
		sum.twoSum(numbers, 9);

	}

}
