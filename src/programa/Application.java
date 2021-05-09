package programa;
import Entities.OrdenarElementar;
import Entities.OrdenarLinear;
import Entities.OrdenarRecursao;
import Entities.GerarCsv;
public class Application {
	
	public static void main(String[] args) {
		
		GerarCsv gerarCsv = new GerarCsv();
		String[][] arr =  gerarCsv.readFile("src\\CovidDataSet.csv"); // Lendo o arquivo passado no path


		// Abaixo todos os arrays que serão usado para ordenar
		String[][] ArrElementar = arr.clone();
		String[][] ArrRecursao = arr.clone();

         long startingTime;
         long finishTime;

		OrdenarElementar ordenarElementar = new OrdenarElementar(ArrElementar);
		OrdenarLinear ordenarLinear = new OrdenarLinear();
		OrdenarRecursao ordenarRecursao = new OrdenarRecursao(ArrRecursao);



		//========================= ALGORTIMOS LINEARES ==============================
			System.out.println("Couting...");
			//Counting ....
		    startingTime =System.currentTimeMillis();
		    
		    String[][] ArrCoutingForOrdeneDead = arr.clone();
			String[][] ArrCountingOrdenedForDead = ordenarLinear.countSort(ArrCoutingForOrdeneDead, 10); // Dead
		    finishTime =System.currentTimeMillis();
			gerarCsv.writeInFile(ArrCountingOrdenedForDead, "src\\Results\\CountionOrdenedDead.csv");
		    System.out.println("Tempo de Execução CountingSorrt Mortes : "+ (finishTime - startingTime)+" ms");

			String[][] ArrCoutingForOrdeneCase = arr.clone();
			startingTime =System.currentTimeMillis();
			String[][] ArrCountingOrdenedForCase = ordenarLinear.countSort(ArrCoutingForOrdeneCase, 7); // Case
			finishTime =System.currentTimeMillis();
			gerarCsv.writeInFile(ArrCountingOrdenedForCase, "src\\Results\\CountionOrdenedCase.csv");
			System.out.println("Tempo de Execução CountingSorrt Casos : "+ (finishTime - startingTime)+" ms");

				
		//========================= ALGORTIMOS ELEMENTARES ==============================

		System.out.println("Insertion...");
        //Insertion ....
		startingTime =System.currentTimeMillis();
		String[][] ArrInsertionOrdenedForDead = ordenarElementar.insertionSort(10);// Dead
		System.out.println("Tamanho: " + ArrCountingOrdenedForDead.length);
		finishTime =System.currentTimeMillis();
		gerarCsv.writeInFile(ArrInsertionOrdenedForDead, "src\\Results\\InsertionOrdenedDeath.csv");
		System.out.println("Tempo de execução Máximo Insectionsort Mortes: "+ (finishTime - startingTime)+" ms");

		startingTime =System.currentTimeMillis();
		String[][] ArrInsertionOrdenedForCase = ordenarElementar.insertionSort(7); // Case
		finishTime =System.currentTimeMillis();
		gerarCsv.writeInFile(ArrInsertionOrdenedForCase, "src\\Results\\InsertionOrdenedCase.csv");
		System.out.println("Tempo de  Máximo Insectionsort Casos: "+ (finishTime - startingTime)+" ms" );

		startingTime =System.currentTimeMillis();
		String[][] ArrInsertionOrdenedForCity = ordenarElementar.insertionSort(4); // City
		finishTime =System.currentTimeMillis();
		gerarCsv.writeInFile(ArrInsertionOrdenedForCity, "src\\Results\\InsertionOrdenedCity.csv");
		System.out.println("Tempo de execução  Insectionsort Nome de Cidades: "+ (finishTime - startingTime)+" ms" );

		System.out.println("Selection...");
		//Selection ....
		startingTime =System.currentTimeMillis();
		String[][] ArrSelectionOrdenedForDead = ordenarElementar.selectionSort(10); // Dead
		finishTime =System.currentTimeMillis();
		gerarCsv.writeInFile(ArrSelectionOrdenedForDead, "src\\Results\\SelectionOrdenedDead.csv");
		System.out.println("Tempo de execução  Selection Mortes : "+ (finishTime - startingTime)+" ms");

		startingTime =System.currentTimeMillis();
		String[][] ArrSelectionOrdenedForCase = ordenarElementar.selectionSort(7); // Case
		finishTime =System.currentTimeMillis();
		gerarCsv.writeInFile(ArrSelectionOrdenedForCase, "src\\Results\\SelectionOrdenedCase.csv");
		System.out.println("Tempo de execução  Selection Casos "+ (finishTime - startingTime)+" ms");

		startingTime =System.currentTimeMillis();
		String[][] ArrSelectionOrdenedForCity = ordenarElementar.selectionSort(4); // City
		finishTime =System.currentTimeMillis();
		gerarCsv.writeInFile(ArrSelectionOrdenedForCity, "src\\Results\\SelectionOrdenedCity.csv");
		System.out.println("Tempo de execução  SelectionSort Cidades : "+ (finishTime - startingTime)+" ms");

	//========================= ALGORITMOS DE RECURSÃO ==============================
		System.out.println("Merge...");
		// Merge ....
		startingTime =System.currentTimeMillis();
		String[][] ArrMergeOrdenedForDead = ordenarRecursao.mergeSort(ArrRecursao.clone(), 1,ArrRecursao.length,10);// Dead
		finishTime =System.currentTimeMillis();
		gerarCsv.writeInFile(ArrMergeOrdenedForDead, "src\\Results\\MergeOrdenedDead.csv");
		System.out.println("Tempo de execução MergeSort Mortes : "+ (finishTime - startingTime)+" ms");

	startingTime =System.currentTimeMillis();
		String[][] ArrMergeOrdenedForCase = ordenarRecursao.mergeSort(ArrRecursao.clone(), 1,ArrRecursao.length,7);// Case
		finishTime =System.currentTimeMillis();
		gerarCsv.writeInFile(ArrMergeOrdenedForCase, "src\\Results\\MergeOrdenedCase.csv");
		System.out.println("Tempo de execução MergeSort Casos: "+ (finishTime - startingTime)+" ms");

		startingTime =System.currentTimeMillis();
		String[][] ArrMergeOrdenedForCity = ordenarRecursao.mergeSort(ArrRecursao.clone(), 1,ArrRecursao.length,4); // City
		finishTime =System.currentTimeMillis();
		gerarCsv.writeInFile(ArrMergeOrdenedForCity, "src\\Results\\MergeOrdenedCity.csv");
		System.out.println("Tempo de execução MergeSort Cidade : "+ (finishTime - startingTime)+" ms");


		System.out.println("quick sort...");
		startingTime =System.currentTimeMillis();
		String[][] ArrQuickOrdenedForDead = ordenarRecursao.quickSort(arr.clone(), 1,ArrRecursao.length-1,10); // Dead
		finishTime =System.currentTimeMillis();
		gerarCsv.writeInFile(ArrQuickOrdenedForDead, "src\\Results\\QuickOrdenedDead.csv");
		System.out.println("Tempo de execução QuickSort Mortes : "+ (finishTime - startingTime)+" ms");

		startingTime =System.currentTimeMillis();
		String[][] ArrQuickOrdenedForCase = ordenarRecursao.quickSort(arr.clone(), 1,ArrRecursao.length-1,7); // Case
		finishTime =System.currentTimeMillis();
		gerarCsv.writeInFile(ArrQuickOrdenedForCase, "src\\Results\\QuickOrdenedCase.csv");
		System.out.println("Tempo de execução QuickSort Casos : "+ (finishTime - startingTime)+" ms");

		startingTime =System.currentTimeMillis();
		String[][] ArrQuickOrdenedForCity = ordenarRecursao.quickSort(arr.clone(), 1,ArrRecursao.length-1,4); // City
		finishTime =System.currentTimeMillis();
		gerarCsv.writeInFile(ArrQuickOrdenedForCity, "src\\Results\\QuickOrdenedCity.csv");
		System.out.println("Tempo de execução QuickSort Cidades : "+ (finishTime - startingTime)+" ms");





		System.out.println("Mediana de 3...");
		// MedianaDeTres ....
		startingTime =System.currentTimeMillis();
			String[][] ArrMedianaDeTresOrdenedForDead = ordenarRecursao.medianaDeTres(ArrRecursao.clone(), 1,ArrRecursao.length-1,10);// Dead
		finishTime =System.currentTimeMillis();
		gerarCsv.writeInFile(ArrMedianaDeTresOrdenedForDead, "src\\Results\\MedianaDeTresOrdenedDead.csv");
		System.out.println("Tempo de execução Quick mediana de 3 Mortes : "+ (finishTime - startingTime)+" ms");

		startingTime =System.currentTimeMillis();
		String[][] ArrMedianaDeTresOrdenedForCase = ordenarRecursao.medianaDeTres(ArrRecursao.clone(), 1,ArrRecursao.length-1,7); // Case
		finishTime =System.currentTimeMillis();
		gerarCsv.writeInFile(ArrMedianaDeTresOrdenedForCase, "src\\Results\\MedianaDeTresOrdenedCase.csv");
		System.out.println("Tempo de execução Quick Mediana de 3 Casos: "+ (finishTime - startingTime)+" ms");

		startingTime =System.currentTimeMillis();
		String[][] ArrMedianaDeTresOrdenedForCity = ordenarRecursao.medianaDeTres(ArrRecursao.clone(), 1,ArrRecursao.length-1,4); // City
		finishTime =System.currentTimeMillis();
		gerarCsv.writeInFile(ArrMedianaDeTresOrdenedForCity, "src\\Results\\MedianaDeTresOrdenedCity.csv");
		System.out.println("Tempo de execução Quick Mediana de 3 Cidades : "+ (finishTime - startingTime)+" ms");

		System.out.println("Heapify...");
		// Heapify ....
		startingTime =System.currentTimeMillis();
		String[][] ArrHeapifyOrdenedForDead = ordenarRecursao.sort(arr.clone(), 10);
		finishTime =System.currentTimeMillis();
		gerarCsv.writeInFile(ArrHeapifyOrdenedForDead, "src\\Results\\HeapifyOrdenedDead.csv");
		System.out.println("Tempo de execução heapySort Mortes: "+ (finishTime - startingTime)+" ms");
		startingTime =System.currentTimeMillis();
		String[][] ArrHeapifyOrdenedForCase = ordenarRecursao.sort(arr.clone(), 7); // Case
		finishTime =System.currentTimeMillis();
		gerarCsv.writeInFile(ArrHeapifyOrdenedForCase, "src\\Results\\HeapifyOrdenedCase.csv");
		System.out.println("Tempo de execução HeapySort Casos : "+ (finishTime - startingTime)+" ms");
  
		startingTime =System.currentTimeMillis();
		String[][] ArrHeapifyOrdenedForCity = ordenarRecursao.sort(arr.clone(), 4); // City
		finishTime =System.currentTimeMillis();
		gerarCsv.writeInFile(ArrHeapifyOrdenedForCity, "src\\Results\\HeapifyOrdenedCity.csv");
		System.out.println("Tempo de execução HeapySort Cidades : "+ (finishTime - startingTime) +" ms");




	System.out.println("Programa Executado Com sucesso, verifique os arquivos de Saida na pasta Results");
	}

}