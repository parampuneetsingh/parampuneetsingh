//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

public class LCAofBST_235 {

	//Faster Solution
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        
        if ((root.left == p && root.right == q) || (root.left == q && root.right == p)) {
            return root;
        }
        
        if (root == p || root == q) {
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
    
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        else {
            return root;
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
