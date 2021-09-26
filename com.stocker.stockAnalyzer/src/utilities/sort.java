package utilities;

import java.util.Arrays;

public class sort {
	
	
private static	void merge(double arr[], int l, int m, int r)
	{
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temporary arrays */
		double L[] = new double[n1];
		double R[] = new double[n2];

		/*Copy data to temporary arrays*/
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		/* Merge the temporary arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarray array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			}
			else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	public static void  sortArray(double[] arr,int l,int r) {
		// TODO Auto-generated method stub
		if (l < r) {
			// Find the middle point
			int m =l+ (r-l)/2;

			// Sort first and second halfs
			sortArray(arr, l, m);
			sortArray(arr, m + 1, r);

			// Merging sorted halfs
			merge(arr, l, m, r);
		}
	}

}
