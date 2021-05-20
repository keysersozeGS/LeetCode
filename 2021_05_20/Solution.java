import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

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
	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderList = new ArrayList<List<Integer>>();
        Queue<TreeNode> elementQueue = new LinkedList<TreeNode>();
        
        if (root != null) {
        	elementQueue.add(root);
            
            while (elementQueue.size() > 0) {
            	int queueSize = elementQueue.size();
            	List<Integer> tempList = new ArrayList<Integer>();
            	
            	for (int i = 0; i < queueSize; i++) {
            		TreeNode currentNode = elementQueue.remove();
            		tempList.add(currentNode.val);
            		
            		if (currentNode.left != null) {
            			elementQueue.add(currentNode.left);
            		}
            		
            		if (currentNode.right != null) {
            			elementQueue.add(currentNode.right);
            		}
            	}
            	
            	levelOrderList.add(tempList);
            }
        }
        
        return levelOrderList;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
