//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/290593/0-ms-beats-100-Java-Solution-With-Explanation

public class FlattenBinaryTreetoLL_114 {

	TreeNode root;
	
	static class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		public TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}
	public void flatten() {
        if (root == null) {
            return;
        }
        
        flattenTree(root);
    }
    
    public TreeNode flattenTree(TreeNode root) {
        TreeNode leftFlatTree;
        TreeNode rightFlatTree;
        
        if (root == null) {
            return null;
        }
        
        leftFlatTree = flattenTree(root.left);
        
        if (root.right != null) {
            rightFlatTree = root.right;
            
            if (leftFlatTree != null) {
                root.right = leftFlatTree;
                while (leftFlatTree.right != null) {
                    leftFlatTree = leftFlatTree.right;
                }
                leftFlatTree.right = flattenTree(rightFlatTree);
            }
            else {
                leftFlatTree = flattenTree(rightFlatTree);
            }
        } else {
            root.right = leftFlatTree;
        }
        
        root.left = null;
        return root;
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
    
	public static void main(String[] args) {
		FlattenBinaryTreetoLL_114 tree = new FlattenBinaryTreetoLL_114();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(5);
		tree.root.left.left = new TreeNode(3);
		tree.root.left.right = new TreeNode(4);
		tree.root.right.right = new TreeNode(6);
		tree.flatten();
	}

}