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
	
	public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averageList = new ArrayList<Double>();
        Queue<TreeNode> elementQueue = new LinkedList<TreeNode>();
        
        elementQueue.add(root);
        
        while (elementQueue.size() > 0) {
        	int queueSize = elementQueue.size();
        	long total = 0;
        	for (int i = 0; i < queueSize; i++) {
        		TreeNode currentNode = elementQueue.remove();
        		total += currentNode.val;
        		
        		if (currentNode.left != null) {
        			elementQueue.add(currentNode.left);
        		}
        		
        		if (currentNode.right != null) {
        			elementQueue.add(currentNode.right);
        		}
        	}
        	
        	averageList.add((double)total / queueSize);
        }
        
        return averageList;
    }

	private void test() {
		
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}
}
