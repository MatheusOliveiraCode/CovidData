package Entities;
import java.text.Collator;


public class OrdenarElementar { // Insertion e selection

	String[][] arr = new String[5617][16];


	// String forma_ordenar;
	public OrdenarElementar(String[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < 16; j++) {
				this.arr[i][j] = arr[i][j];
			}
		}


	}

	public String[][] selectionSort(int dadoRequisitado) {
		Collator collator = Collator.getInstance();
		collator.setStrength(Collator.NO_DECOMPOSITION);
		for (int i = 1; i < this.arr.length; i++) {

			int minimum = i;

			for (int j = i + 1; j < this.arr.length; j++) {
				if (dadoRequisitado == 4) {
					if (collator.compare(this.arr[minimum][dadoRequisitado], this.arr[j][dadoRequisitado]) > 0) {
						minimum = j;
					}
				} else {

					if (Integer.parseInt(this.arr[j][dadoRequisitado]) < Integer
							.parseInt(this.arr[minimum][dadoRequisitado])) {
						minimum = j;
					}
				}

			}
			if (i != minimum) {
				String[] aux = this.arr[i];
				this.arr[i] = this.arr[minimum];
				this.arr[minimum] = aux;
			}
		}
		return this.arr;
	}

	public String[][] insertionSort(int dadoRequisitado) {
		Collator collator = Collator.getInstance();
		collator.setStrength(Collator.NO_DECOMPOSITION);
		String[] aux;
		int j;
		for (int i = 1; i < this.arr.length; i++) {
			aux = this.arr[i];
			
			j = i - 1;

			if (dadoRequisitado == 4) {
				while (j >= 1 && collator.compare(this.arr[j][dadoRequisitado], aux[dadoRequisitado]) > 0) {
					this.arr[j + 1] = this.arr[j];
					j--;
				}
			} else {
				while (j >= 1
						&& Integer.parseInt(this.arr[j][dadoRequisitado]) > Integer.parseInt(aux[dadoRequisitado])) {
					this.arr[j + 1] = this.arr[j];
					j--;
				}
			}

			this.arr[j + 1] = aux;
		}
		return this.arr;
	}
}
