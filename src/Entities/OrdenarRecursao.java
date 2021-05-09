package Entities;
import java.text.Collator;

public class OrdenarRecursao {
	String[][] arr = new String[5617][16];

	public OrdenarRecursao(String[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.arraycopy(arr[i], 0, this.arr[i], 0, 14); // o que é isso ?
		}
	}
	// ==================================merge====================================

	private static void organizar(String[][] vetor, int primeiro, int meio, int ultimo, int requiredData) {
		String[][] arr = new String[ultimo - primeiro][];
		Collator collator = Collator.getInstance();
		collator.setStrength(Collator.NO_DECOMPOSITION);
		int posicao = 0;
		int i = primeiro;
		int meioAux = meio;
		if (requiredData != 4) {
			while (i < meio && meioAux < ultimo) {
				if (Integer.parseInt(vetor[i][requiredData]) <= Integer.parseInt(vetor[meioAux][requiredData])) {
					arr[posicao] = vetor[i]; // transforma a posicao analisada no valor do la�o do vetor
					// Incrementa
					posicao++;
					i++;
				} else { // caso estamos tratando do espaco entre meio e o fim
					arr[posicao] = vetor[meioAux];

					// Incrementa
					posicao++;
					meioAux++;
				}
			}

			while (meioAux < ultimo) { // Trata apenas do meio at� o fim
				arr[posicao] = vetor[meioAux]; // valor do array auxiliar vira o elemento do vetor do meio ao fim)

				// Incremento
				posicao++;
				meioAux++;
			}

			while (i < meio) { // Trata apenas do inicio ao meio
				arr[posicao] = vetor[i]; // valor do array auxiliar vira o elemento do vetor i(do inicio ao meio)

				// Incremento
				posicao++;
				i++;
			}

			for (posicao = 0, i = primeiro; i < ultimo; i++) { // Com a ordena��o feita,poe valores da posi��o no vetor
				vetor[i] = arr[posicao];
				posicao++;
			}
		} else {
			while (i < meio && meioAux < ultimo) {
				if (collator.compare(vetor[meioAux][requiredData], vetor[i][requiredData]) > 0) {
					// Verifica se estamos tratando do espa�o in�cio at� o fim
					arr[posicao] = vetor[i]; // transforma a posicao analisada no valor do la�o do vetor
					// Incrementa
					posicao++;
					i++;

				} else { // caso estamos tratando do espa�o entre meio e o fim
					arr[posicao] = vetor[meioAux];

					// Incrementa
					posicao++;
					meioAux++;
				}
			}

			while (meioAux < ultimo) { // Trata apenas do meio at� o fim
				arr[posicao] = vetor[meioAux]; // valor do array auxiliar vira o elemento do vetor do meio ao fim)

				// Incremento
				posicao++;
				meioAux++;
			}

			while (i < meio) { // Trata apenas do inicio ao meio
				arr[posicao] = vetor[i]; // valor do array auxiliar vira o elemento do vetor i(do inicio ao meio)

				// Incremento
				posicao++;
				i++;
			}

			for (posicao = 0, i = primeiro; i < ultimo; i++) { // Com a ordena��o feita,poe valores da posi��o no vetor
				vetor[i] = arr[posicao];
				posicao++;
			}
		}
	}

	public String[][] mergeSort(String[][] vetor, int inicio, int fim, int requiredData) {

		if (inicio < fim - 1) {

			int meio = (inicio + fim) / 2;

			mergeSort(vetor, inicio, meio, requiredData); // Ordena do inicio at� o meio do vetor(recursividade)
			mergeSort(vetor, meio, fim, requiredData); // Ordena do meio at� o final do vetor(recursividade)
			organizar(vetor, inicio, meio, fim, requiredData);
		}
		return vetor;
	}

	// ================================== Fim do Merge sorting=====================

	// ===================== Inicio do QuickSort ==============================

	public String[][] quickSort(String[][] arr, int inicio, int fim, int requiredData) { // Função que realiza
		if (requiredData != 4) {
			if (inicio < fim) {
				int pivo;
				pivo = Integer.parseInt(arr[fim][requiredData]); // Pivo ser� o ultimo de cada galho

				int i = (inicio - 1);
				for (int j = inicio; j <= fim - 1; j++) {

					if (Integer.parseInt(arr[j][requiredData]) < pivo) {
						i++;
						String[] aux = arr[i];
						arr[i] = arr[j];
						arr[j] = aux;
					}

				}

				String[] aux = arr[i + 1];
				arr[i + 1] = arr[fim];
				arr[fim] = aux;
				int piAux = i + 1;

				// Funcao recursiva para cada ramo da arvore
				quickSort(arr, inicio, piAux - 1, requiredData);
				quickSort(arr, piAux + 1, fim, requiredData);
				return arr;
			}

		} else {
			Collator collator = Collator.getInstance();
			collator.setStrength(Collator.NO_DECOMPOSITION);
			if (inicio < fim) {
				String pivo = arr[fim][requiredData];

				int i = (inicio - 1);
				for (int j = inicio; j <= fim - 1; j++) {

					if (collator.compare(pivo, arr[j][requiredData]) > 0) {
						i++;
						String[] aux = arr[i];
						arr[i] = arr[j];
						arr[j] = aux;
					}
				}
				String[] aux = arr[i + 1];
				arr[i + 1] = arr[fim];
				arr[fim] = aux;
				int piAux = i + 1;

				// Funcao recursiva para cada ramo da arvore
				quickSort(arr, inicio, piAux - 1, requiredData);
				quickSort(arr, piAux + 1, fim, requiredData);
			}

		}

		return arr;
	}

	// ===================== Final do QuickSort =============================

	// ==================== Inicio da mediana de 3===========================

	public String[][] medianaDeTres(String[][] arr, int primeiro, int ultimo, int requiredData) {
		if (requiredData != 4) {
			if (primeiro < ultimo) {

				int meio = ((primeiro + ultimo) / 2);
				int a = Integer.parseInt(arr[primeiro][requiredData]);
				int b = Integer.parseInt(arr[meio][requiredData]);
				int c = Integer.parseInt(arr[ultimo][requiredData]);
				int medianaIndice;

				if (a < b) {
					if (b < c) {
						// a < b && b < c
						medianaIndice = meio;
					} else {
						if (a < c) {
							// a < c && c <= b
							medianaIndice = ultimo;
						} else {
							// c <= a && a < b
							medianaIndice = primeiro;
						}
					}
				} else {
					if (c < b) {
						// c < b && b <= a
						medianaIndice = meio;
					} else {
						if (c < a) {
							// b <= c && c < a
							medianaIndice = ultimo;
						} else {
							// b <= a && a <= c
							medianaIndice = primeiro;
						}
					}
				}

				swap(arr, medianaIndice, ultimo);

				int pivo = Integer.parseInt(arr[ultimo][requiredData]);

				int i = (primeiro - 1);
				for (int j = primeiro; j <= ultimo - 1; j++) {

					if (Integer.parseInt(arr[j][requiredData]) < pivo) {
						i++;
						String[] aux = arr[i];
						arr[i] = arr[j];
						arr[j] = aux;
					}
				}

				String[] aux = arr[i + 1];
				arr[i + 1] = arr[ultimo];
				arr[ultimo] = aux;
				int piAux = i + 1;

				medianaDeTres(arr, primeiro, piAux - 1, requiredData);
				medianaDeTres(arr, piAux + 1, ultimo, requiredData);
			}
		} else {
			if (primeiro < ultimo) {
				Collator collator = Collator.getInstance();
				collator.setStrength(Collator.NO_DECOMPOSITION);
				int meio = ((primeiro + ultimo) / 2);
				String a = (arr[primeiro][requiredData]);
				String b = (arr[meio][requiredData]);
				String c = (arr[ultimo][requiredData]);
				int medianaIndice;

				if (collator.compare(b, a) > 0) {
					if (collator.compare(c, b) > 0) {
						// a < b && b < c
						medianaIndice = meio;
					} else {
						if (collator.compare(c, a) > 0) {
							// a < c && c <= b
							medianaIndice = ultimo;
						} else {
							// c <= a && a < b
							medianaIndice = primeiro;
						}
					}
				} else {
					if (collator.compare(b, c) > 0) {
						// c < b && b <= a
						medianaIndice = meio;
					} else {
						if (collator.compare(a, c) > 0) {
							// b <= c && c < a
							medianaIndice = ultimo;
						} else {
							// b <= a && a <= c
							medianaIndice = primeiro;
						}
					}
				}

				swap(arr, medianaIndice, ultimo);

				String pivo = (arr[ultimo][requiredData]);

				int i = (primeiro - 1);
				for (int j = primeiro; j <= ultimo - 1; j++) {

					if (collator.compare(pivo, arr[j][requiredData]) > 0) {
						i++;
						String[] aux = arr[i];
						arr[i] = arr[j];
						arr[j] = aux;
					}
				}

				String[] aux = arr[i + 1];
				arr[i + 1] = arr[ultimo];
				arr[ultimo] = aux;
				int piAux = i + 1;

				medianaDeTres(arr, primeiro, piAux - 1, requiredData);
				medianaDeTres(arr, piAux + 1, ultimo, requiredData);
			}
		}
		return arr;
	}

	public static void swap(String[][] A, int i, int j) {
		String[] temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	// ==================== Fim da mediana de 3=========================

	// ==================== Inicio do heapify===========================

	public String[][] sort(String[][] arr, int requiredData) {
		int n = arr.length;

		for (int i = n / 2 - 1; i >= 1; i--)
			heapify(arr, n, i, requiredData);

		for (int i = n - 1; i > 1; i--) {

			String[] temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			heapify(arr, i, 0, requiredData);
		}

		return arr;
	}

	static void heapify(String[][] arr, int n, int i, int requiredData) {
		if (requiredData != 4) {
			int largest = i;
			int l = 2 * i + 1;
			int r = 2 * i + 2;

			// If left child is larger than root
			if (l < n && Integer.parseInt(arr[l][requiredData]) > Integer.parseInt(arr[largest][requiredData]))
				largest = l;

			// If right child is larger than largest so far
			if (r < n && Integer.parseInt(arr[r][requiredData]) > Integer.parseInt(arr[largest][requiredData]))
				largest = r;

			// If largest is not root
			if (largest != i) {
				String[] swap = arr[i];
				arr[i] = arr[largest];
				arr[largest] = swap;

				// Recursively heapify the affected sub-tree
				heapify(arr, n, largest, requiredData);
			}
		} else {
			Collator collator = Collator.getInstance();
			collator.setStrength(Collator.NO_DECOMPOSITION);
			int largest = i;
			int l = 2 * i + 1;
			int r = 2 * i + 2;

			// If left child is larger than root
			if (l < n && collator.compare(arr[l][requiredData], arr[largest][requiredData]) > 0)
				largest = l;

			// If right child is larger than largest so far
			if (r < n && collator.compare(arr[r][requiredData], arr[largest][requiredData]) > 0)
				largest = r;

			// If largest is not root
			if (largest != i) {
				String[] swap = arr[i];
				arr[i] = arr[largest];
				arr[largest] = swap;

				// Recursively heapify the affected sub-tree
				heapify(arr, n, largest, requiredData);
			}
		}

		// ==================== Final do heapify===========================
	}
}