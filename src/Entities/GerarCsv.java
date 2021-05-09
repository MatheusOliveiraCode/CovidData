package Entities;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;


public class GerarCsv {
	
	String[][] arr = new String[5617][16];
	
	public GerarCsv() {
	}

	public String[][] readFile(String path) {
		String line = "";
		int i = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				for (int j = 0; j < 16; j++) {
					this.arr[i][j] = values[j];
				}
				i++;
			}
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
		return this.arr;
	}
	public void writeInFile(String[][] lista, String filepath) {
		int i = 0;
		int j = 0;
		try {
			FileWriter fw = new FileWriter(filepath, true);
			BufferedWriter wrt = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(wrt);



			for(i = 0; i < lista.length ; i++){
				
				for(j =0 ; j < lista[i].length ; j++){
					if(j!=15) {
						pw.print(lista[i][j]+",");
					}else {
						pw.print(lista[i][j]);
						}

				}
				pw.println();
				wrt.flush();
			}

		} catch (Exception e) {
			System.out.println("Error na escritura do arquivo");
		}
	}
	

}
