package Entities;
import java.util.Arrays;

public class OrdenarLinear { // couting

	public OrdenarLinear() {
	}

	public String[][] countSort(String[][] arr, int requiredData) {
		int size = arr.length;

		String[][] output = new String[size + 1][0];

		String[] max = arr[1];
		for (int i = 1; i < size; i++) {
			if (Integer.parseInt(arr[i][requiredData]) > Integer.parseInt(max[requiredData]))
				max = arr[i];
		}
		int[] count = new int[Integer.parseInt(max[requiredData]) + 1];

		for (int i = 0; i < Integer.parseInt(max[requiredData]); ++i) {
			count[i] = 0;
		}


		for (int i = 1; i < size; i++) {
			count[Integer.parseInt(arr[i][requiredData])]++;
		}


		for (int i = 1; i <= Integer.parseInt(max[requiredData]); i++) {
			count[i] += count[i - 1];
		}


		for (int i = size - 1; i > 0; i--) {
			output[count[Integer.parseInt(arr[i][requiredData])] - 1] = arr[i];
			count[Integer.parseInt(arr[i][requiredData])]--;
		}
		for (int i = 0; i < size; i++) {
			arr[i] = output[i];
		}
		return arr;

	}

}
