
public class Solution {
	int total = 0;

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
		
		public String toString() {
			return "" + this.val;
		}
	}
	
	public TreeNode convertBST(TreeNode root) {
		if (root != null) {
			convertBST(root.right);
			total += root.val;
			root.val = total;
			convertBST(root.left);
		}
		
		return root;
    }
	
	public void printTree(TreeNode root) {
		if (root != null) {
			printTree(root.left);
			System.out.print(root.val + " ");
			printTree(root.right);
		}
    }

	private TreeNode buildTree(int[] array) {
		TreeNode nodeArray[] = new TreeNode[array.length];
		
		for (int i = 0; i < array.length; i++) {
			nodeArray[i] = null;
			
			if (array[i] != -1) {
				nodeArray[i] = new TreeNode(array[i]);
			}
		}
		
		for (int i = 1; i < array.length; i++) {
			int index = (i - 1) / 2;
			
			if (nodeArray[index] != null) {
				if (i % 2 == 1) {
					nodeArray[index].left = nodeArray[i];
				} else {
					nodeArray[index].right = nodeArray[i];
				}
			}
		}
		
		if (nodeArray.length == 0) {
			return null;
		}
		
		return nodeArray[0];
	}
	
	private void test() {
		int[] array = {4,1,6,0,2,5,7,-1,-1,-1,3,-1,-1,-1,8};
		TreeNode root = buildTree(array);
		root = convertBST(root);
		
		System.out.print("result : ");
		printTree(root);
		System.out.println();
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}
}
