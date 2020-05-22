import java.util.LinkedList;
import java.util.Queue;

public class SameTree_100 {
	TreeNode root1;
	TreeNode root2;
	
	class TreeNode {
		int val;
		TreeNode left, right;

		public TreeNode(int item) {
			val = item;
			left = right = null;
		}
	}
	
	public void insertRoot(int[] data1,int[] data2) {
		root1 = insertData(root1, data1, 0, data1.length);
		root2 = insertData(root2, data2, 0, data2.length);
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
		
	public boolean checkSameTree() {
		boolean ans = isSameTree(root1, root2); 
		return ans;
	} 
	
	public boolean RecursiveSolnSameTree() {
		boolean ans = isSameTree(root1, root2); 
		return ans;
	}
	
	public boolean recursiveSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null || p.val != q.val) {
			return false;
		}
		return recursiveSameTree(p.left, q.left) && recursiveSameTree(p.right, q.right);
	}
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
		boolean result = true;
		Queue<TreeNode> Q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> Q2 = new LinkedList<TreeNode>();
		Q1.add(p);
		Q2.add(q);
		
		while(Q1.size() > 0 && Q2.size() > 0) {
			TreeNode tempP = Q1.peek();
			TreeNode tempQ = Q2.peek();
			
			if (tempP == null && tempQ == null) {
				return result;
			}
			
			if (tempP.val == tempQ.val) {
				Q1.remove();
				Q2.remove();
				Q1.add(tempP.left);
				Q2.add(tempQ.left);
				Q1.add(tempP.right);
				Q2.add(tempP.right);
			} else {
				result = false;
				break;
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		SameTree_100 tree1 = new SameTree_100();
		int data1[] = { 1, 2, 3 };
		int data2[] = { 1, 4, 3 };
		tree1.insertRoot(data1,data2);
		tree1.checkSameTree();		
		tree1.RecursiveSolnSameTree();
	}
}
