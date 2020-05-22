import java.util.ArrayList;
import java.util.List;

public class LCABinaryTree_236 {

	TreeNode root;

	class TreeNode {
		int val;
		TreeNode left, right;

		public TreeNode(int item) {
			val = item;
			left = right = null;
		}
	}

	// Constructor
	LCABinaryTree_236() {
		root = null;
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

	//Better Solution
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
            
        if (left == null) {
            return right;
        }
        
        if (right == null) {
            return left;
        }
        
        return root;
    }
	
	public boolean search(TreeNode root, int n, List<Integer> num) {

		if (root == null) {
			return false;
		}

		num.add(root.val);

		if (root.val == n) {
			return true;
		}

		if (root.left != null && search(root.left, n, num)) {
			return true;
		}
		if (root.right != null && search(root.right, n, num)) {
			return true;
		}
		
		num.remove(num.size() - 1);
		return false;
	}

	public int LCA(int n1, int n2) {
		return findLCA(root, n1, n2);
	}

	public int findLCA(TreeNode rootVal, int n1, int n2) {
		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new ArrayList<Integer>();
		
		int i = 0;
		if (search(rootVal, n1, l1) && search(rootVal, n2, l2)) {
			for (i = 0; i < l1.size() && i < l2.size(); i++) {
		          //  System.out.println(path1.get(i) + " " + path2.get(i));
		            if (!l1.get(i).equals(l2.get(i)))
		                break;
		        }
		}
		return l1.get(i-1);
	}
	
	public static void main(String[] args) {
		LCABinaryTree_236 tree = new LCABinaryTree_236();
		int data[] = { 1, 2, 3, 4, 5, 6, 7 };
		tree.insert(data);
		int resp = tree.LCA(2,7);
		System.out.println(resp);
/*		         1
		        / \
		       2   3 
		      / \ / \
		     4  5 6  7
*/ 
	}

}
