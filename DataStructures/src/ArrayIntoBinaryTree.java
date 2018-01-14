public class ArrayIntoBinaryTree {
	
	public static void main(String[] args) {
		int arr[] = new int[6];
		loadElementsInArray(arr);
		
		findSubArray(arr, 0, arr.length-1);
	}

	private static void loadElementsInArray(int[] arr) {
		arr[0] = 25;
		arr[1] = 50;
		arr[2] = 75;
		arr[3] = 100;
		arr[4] = 125;
		arr[5] = 150;
	}
	
	findSubArray(arr, int start, int end) {
		if(end>start) 
			return null;
		
		int mid = (start+end)/2;
		
		
	}
	
}