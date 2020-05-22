import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal_107 {

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

	public void traverse() {
		levelOrderBottom(root);
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		
		LinkedList<List<Integer>> resList = new LinkedList<List<Integer>>();
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        if(root == null){
            return resList;
        }
        
        queue.offer(root);

        while(!queue.isEmpty()){
            
            int levelSize = queue.size();
            List<Integer> list = new ArrayList<Integer>(); // tmp list to hold nodes of current level

            for(int i = 0; i < levelSize; i ++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            
            resList.addFirst(list);
            
        }
        
        return resList;
	}

	public static void main(String[] args) {
		int[] data = { 3, 9, 20, 12, 34, 15, 7 };
		BinaryTreeLevelOrderTraversal_107 traverseTree = new BinaryTreeLevelOrderTraversal_107();
		traverseTree.insert(data);
		traverseTree.traverse();

	}

}
