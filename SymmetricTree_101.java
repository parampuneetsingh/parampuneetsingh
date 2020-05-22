import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree_101 {

	TreeNode root;
	
	class TreeNode {
		int val;
		TreeNode left, right;

		public TreeNode(int item) {
			val = item;
			left = right = null;
		}
	}
	
	public void insertRoot(int[] data) {
		root = insertData(root, data, 0, data.length);
	}
	
	
	// Took it from existing code
		public TreeNode insertData(TreeNode root, int[] data, int start, int size) {

			TreeNode temp = new TreeNode(0);
			int left = 2 * start + 1;
			int right = 2 * start + 2;

			if (left > size && right > size) {
				return null;
			}

			if (root == null) {
				temp.val = data[start];
				root = temp;
			}

			if (root.left == null && root.right == null) {
				if (left < size) {
					root.left = new TreeNode(data[left]);
				}
				if (right < size) {
					root.right = new TreeNode(data[right]);
				}
			}

			insertData(root.left, data, left, size);
			insertData(root.right, data, right, size);

			return root;
		}
	
	public void checkSameTree() {
		boolean ans = compareRootRecursive(root, root); //Recursive Solution
		boolean ans2 = checkMirrorIterative(root, root); //Iterative Solution
		System.out.println(ans2);
	}	
	
	
	public boolean checkMirrorIterative(TreeNode root1, TreeNode root2) {
		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();
		
		q1.add(root1);
		q2.add(root2);
		
		while (!q1.isEmpty() && !q2.isEmpty()) {
			TreeNode temp1 = q1.peek();
			TreeNode temp2 = q2.peek();
			
			if (temp1.val != temp2.val) {
				return false;
			} 
			q1.remove();
			q2.remove();
			
			if (temp1.left != null) {
				q1.add(temp1.left);
			}
			if (temp1.right!= null) {
				q1.add(temp1.right);
			}
			if (temp2.right!= null) {
				q2.add(temp2.right);
			}
			if (temp2.left!= null) {
				q2.add(temp2.left);
			}
		}
		return true;
	}
	
	public boolean compareRootRecursive(TreeNode leftRoot, TreeNode rightRoot) {
		if (leftRoot == null && rightRoot == null) {
			return true;
		}
		else if (leftRoot == null || rightRoot == null || leftRoot.val != rightRoot.val) {
			return false;
		}
		else {
			return compareRootRecursive(leftRoot.left, rightRoot.right) && compareRootRecursive(leftRoot.right, rightRoot.left);
		}
	}
	
	public static void main(String[] args) {
		SymmetricTree_101 tree = new SymmetricTree_101();
		int data[] = { 1, 2, 2, 3, 4, 4, 3 };
		tree.insertRoot(data);
		tree.checkSameTree();

	}

}
