import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/search-in-a-binary-search-tree/

public class SearchinaBinarySearchTree_700 {

	//Solution 2
    public TreeNode searchBSTDFS(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        
        if (root.val == val) {
            return root;
        } else if (val < root.val) {
            return searchBST(root.left, val);
        } else if (val > root.val) {
            return searchBST(root.right, val);
        }
        
        return null;
    }
    
	//Solution 1
	public TreeNode searchBST(TreeNode root, int val) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();

		q.add(root);

		while (!q.isEmpty()) {
			TreeNode t = q.poll();
			if (t.val == val) {
				return t;
			} else if (val < t.val && t.left != null) {
				q.add(t.left);
			} else if (val > t.val && t.right != null) {
				q.add(t.right);
			}
		}

		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
