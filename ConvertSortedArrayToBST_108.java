//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
//https://www.youtube.com/watch?v=PZYTs9y4f4o
//https://www.youtube.com/watch?v=12omz-VAyRk

public class ConvertSortedArrayToBST_108 {
	TreeNode root;

	public class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		public TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

	public TreeNode sortedArrayToBST(int[] nums) {
        return insertData(nums, 0, nums.length - 1);
   }
	
	public TreeNode insertData(int[] nums, int start, int size) {
		if (start > size) {
			return null;
		}
		int middle=(start+size)/2;
        TreeNode currNode=new TreeNode(nums[middle]);
        currNode.left=insertData(nums,start,middle-1);
        currNode.right=insertData(nums,middle+1,size);
        return currNode;
	}
	
	public static void main(String[] args) {
		ConvertSortedArrayToBST_108 convert = new ConvertSortedArrayToBST_108();
		int[] nums = {-10,-3,0,5,9};
		convert.sortedArrayToBST(nums);
	}

}
