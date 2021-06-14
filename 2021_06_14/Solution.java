import java.util.Arrays;
import java.util.Comparator;

public class Solution {

	class Item {
		int boxCount;
		int unitCount;
		
		Item(int boxCount, int unitCount) {
			this.boxCount = boxCount;
			this.unitCount = unitCount;
		}
	}
	
	class ItemComparator implements Comparator<Item> {
		@Override
		public int compare(Item o1, Item o2) {
			return Integer.compare(o2.unitCount, o1.unitCount);
		}
	}
	
	private Item[] convertToItems(int[][] boxTypes) {
		Item[] itemArray = new Item[boxTypes.length];
		
		for (int i = 0; i < itemArray.length; i++) {
			itemArray[i] = new Item(boxTypes[i][0], boxTypes[i][1]);
		}
		
		return itemArray;
	}
	
	public int maximumUnits(int[][] boxTypes, int truckSize) {
        int sum = 0;
        int i = 0;
		Item[] itemArray = convertToItems(boxTypes);
        Arrays.sort(itemArray, new ItemComparator());
        
        while (truckSize > 0 && i < itemArray.length) {
        	if (itemArray[i].boxCount <= truckSize) {
        		sum += itemArray[i].boxCount * itemArray[i].unitCount;
        		truckSize -= itemArray[i].boxCount;
        	} else {
        		sum += truckSize * itemArray[i].unitCount;
        		truckSize = 0;
        	}
        	
        	i++;
        }
        
        return sum;
    }
	
	private void test() {
		int[][] boxTypes = {{5, 10}, {2, 5}, {4, 7}, {3, 9}};
		
		System.out.println("result : " + maximumUnits(boxTypes, 10));
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		s.test();
	}

}
