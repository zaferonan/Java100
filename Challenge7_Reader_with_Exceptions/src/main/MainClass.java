package main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MainClass {

	public static void main(String[] args) throws MyFilenotFoundException   {
		
		MyReader myReader = null;
		try {
			myReader = new MyReader(new File("src/myFile.txt"));
						
		}catch (MyFilenotFoundException e) {
			System.err.println(e.getMessage());
		}catch (FileNotFoundException e) {
			throw new MyFilenotFoundException();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
		
		
		try {
			System.out.println("Count of lines in file is : " +myReader.countLines());
		} catch (MyNullReaderException | IOException e1) {
			System.err.println(e1.getMessage());
		}	
		
		ArrayList<String> kelimeler;
		try {
			kelimeler = myReader.readWords();
			System.out.println(kelimeler.toString());
		} catch (MyNullReaderException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
		try {
			String line=myReader.readLineAt(4);
			System.out.println(line);
		} catch (NullLineException e) {
			System.err.println(e.getMessage());
		}  catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
		try {
			String line=myReader.readLineAt(3);
			System.out.println(line);
		} catch (NullLineException e) {
			System.err.println(e.getMessage());
		}  catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
		try {
			myReader.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		

	}

}
