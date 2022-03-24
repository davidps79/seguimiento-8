package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import model.SortingSystem;

public class Main {
	private SortingSystem back;
	private BufferedReader in;
	private BufferedWriter out;
	
	public Main() {
		back = new SortingSystem();
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new BufferedWriter(new OutputStreamWriter(System.out));
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Main main = new Main();
		main.start();
	}
	
	public void start() throws IOException {
		out.write("(1) Type info manually\n(2) Import info from file\n");
		out.flush();
		int option;
		do {
			option = Integer.parseInt(in.readLine());
			switch (option) {
			case 1:
				out.write("Please type the info:\n"); out.flush();
				writeManually();
				break;
			case 2:
				try{
					out.write("Type the path of the txt file\nexample file: ./files/sampleData.txt\n"); out.flush();
					importData();
				} catch (IOException e) {
					out.write("Please check the path of the file\n");
				}
				break;
			default:
				out.write("Invalid option, type again"); out.flush();
				break;
			}
		} while (option<1 || option>2);
		
		out.write("Masculino\n" + back.getListM() + "----------\nFemenino\n" + back.getListF() + "----------\nCombinado\n" + back.getListC());
		out.close();
		in.close();
	}
	
	public void writeManually() throws IOException {
		int n = Integer.parseInt(in.readLine());
		for (int i=0; i<n; i++) {
			String[] line = in.readLine().split(";");
			back.addCountry(
				line[0],
				Integer.parseInt(line[1]),
				Integer.parseInt(line[2]),
				Integer.parseInt(line[3]),
				Integer.parseInt(line[4]),
				Integer.parseInt(line[5]),
				Integer.parseInt(line[6])
			);
		}
	}
	
	public void importData() throws IOException {
		String path = in.readLine();
		BufferedReader bf = new BufferedReader(new FileReader(new File(path)));
		String line;
		while ((line=bf.readLine())!=null) {
			String[] params = line.split(";");
			back.addCountry(
					params[0],
					Integer.parseInt(params[1]),
					Integer.parseInt(params[2]),
					Integer.parseInt(params[3]),
					Integer.parseInt(params[4]),
					Integer.parseInt(params[5]),
					Integer.parseInt(params[6])
				);
		}
		out.write("Data loaded succesfully\n\n"); out.flush();
	}
}
