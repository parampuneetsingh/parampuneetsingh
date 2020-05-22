import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal_145 {

	TreeNode root;

	class TreeNode {
		int val;
		TreeNode left, right;

		public TreeNode(int item) {
			val = item;
			left = right = null;
		}
	}

	public void insert(int[] data) {
		root = insertData(root, data, 0, data.length);
	}

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

	public List<Integer> postOrder() {
		return postorderTraversal(root);
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		Stack<TreeNode> stk = new Stack<TreeNode>();
		Deque<Integer> dq = new LinkedList<Integer>();

		stk.push(root);

		while (!stk.isEmpty()) {
			TreeNode temp = stk.pop();
			dq.addFirst(temp.val);

			if (temp.left != null) {
				stk.push(temp.left);
			}
			if (temp.right != null) {
				stk.push(temp.right);
			}
		}
		return (List) dq;
	}

	public static void main(String[] args) {
		BinaryTreePostorderTraversal_145 tree = new BinaryTreePostorderTraversal_145();
		int data[] = { 1, 2, 3, 4, 5, 6, 7 };
		tree.insert(data);
		System.out.println(tree.postOrder().toString());
	}

}
