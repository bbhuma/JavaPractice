package com.java.JavaRefresherIntermediate.Sessionn40;

public class FindAPeakElement {

	public static void main(String[] args) {
		int[] arr = { 5, 17, 100, 11, 6 };
		System.out.println("Peak index is at: " + findAPeakElementApproach1(arr));

	}

	// Approach 1 : Compare with both left and right neighbour
		public static int findAPeakElementApproach1(int[] arr) {

			int n = arr.length;

			// Boundary Cases
			if (n == 1)
				return arr[0];
			// Decreasing slope 
			if (arr[0] > arr[1])
				return arr[0];
			// Increasing slope, last is the peak
			if (arr[n - 1] > arr[n - 2])
				return arr[n - 1];

			int low = 1;
			int high = n - 2;
			int mid = -1;

			while (low <= high) {

				mid = low + (high - low) / 2;

				// Peak found
				if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
					return arr[mid];
				}

				// Ascending, Increasing slope
				else if (arr[mid] < arr[mid + 1]) {
					low = mid + 1;
				}

				// Descending,Decreasing slope
				else {
					high = mid - 1;
				}
			}
			return arr[mid];
		}
		
		// Approach 2 : Compare only with right neighbour
		public static int findAPeakElementApproach2(int[] arr) {

			int low = 0;
			int high = arr.length - 1;

			while (low < high) {

				int mid = low + (high - low) / 2;

				// Increasing slope
				if (arr[mid] < arr[mid + 1]) {

					low = mid + 1;

				}
				// Decreasing slope OR Peak itself
				else {

					high = mid;
				}
			}

			return low;
		}
}
