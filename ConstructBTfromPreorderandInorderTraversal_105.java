//https://www.youtube.com/watch?v=PoBGyrIWisE
//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

import java.util.ArrayDeque;
import java.util.Deque;

public class ConstructBTfromPreorderandInorderTraversal_105 {

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

	int i=0, j = 0;
	public TreeNode buildTreeDFS(int[] preorder, int[] inorder) {
		TreeNode node = new TreeNode(preorder[i++]);
		
		if (node.val != inorder[j]) {
			node.left = buildTreeDFS(preorder, inorder);
		}
		
		if (node.val != inorder[j]) {
			node.right = buildTreeDFS(preorder, inorder);
		}
		
		while (inorder[j] == node.val) {
			j++;
		}
		return node;
	}
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0)
			return null;

		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		TreeNode root = new TreeNode(preorder[0]);
		stack.push(root);

		// i is preorder index, j is inorder index
		for (int i = 1, j = 0; i < preorder.length; i++) {
			TreeNode cur = new TreeNode(preorder[i]);

			// find cur's parent
			TreeNode parent = stack.peek();
			if (parent.val != inorder[j]) {
				// cur's parent is the top node on stack
				// cur is prent's left child
				parent.left = cur;
			} else {
				// cur's parent is the last node on stack whose val == inorder[j].val
				// cur is parent's right child
				while (!stack.isEmpty() && stack.peek().val == inorder[j]) {
					parent = stack.pop();
					j++;
				}
				parent.right = cur;
			}
			stack.push(cur);
		}

		return root;
	}

	public static void main(String[] args) {
		ConstructBTfromPreorderandInorderTraversal_105 tree = new ConstructBTfromPreorderandInorderTraversal_105();
		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };
		tree.buildTreeDFS(preorder, inorder);
	}

}
