
public class Solution {
	TreeNode newRoot = null;
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
		
		public String toString() {
			return "" + this.val;
		}
	}
	
	private void insertNode(TreeNode node, int val) {
		if (val < node.val) {
			if (node.left != null) {
				insertNode(node.left, val);
			} else {
				node.left = new TreeNode(val);
			}
		} else {
			if (node.right != null) {
				insertNode(node.right, val);
			} else {
				node.right = new TreeNode(val);
			}
		}
	}
	
	private void printTree(TreeNode root) {
		if (root != null) {
			System.out.print(root.val + " ");
			printTree(root.left);
			printTree(root.right);
		}
	}
	
	private void buildBST(TreeNode root, int low, int high) {
		if (root != null) {
			if (root.val >= low && root.val <= high) {
				if (newRoot != null) {
					insertNode(newRoot, root.val);
				} else {
					newRoot = new TreeNode(root.val);
				}
			}
			
			buildBST(root.left, low, high);
			buildBST(root.right, low, high);
		}
	}
	
	public TreeNode trimBST(TreeNode root, int low, int high) {
		buildBST(root, low, high);
		
		return newRoot;
	}
	
	private void test() {
		TreeNode root = new TreeNode(3);
		insertNode(root, 0);
		insertNode(root, 4);
		insertNode(root, 2);
		insertNode(root, 1);
		
		TreeNode result = trimBST(root, 1, 3);
		
		printTree(result);
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}
}
