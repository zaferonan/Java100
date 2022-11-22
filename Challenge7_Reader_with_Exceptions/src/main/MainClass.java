package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MainClass {

	public static void main(String[] args) throws MyFilenotFoundException {

		MyReader myReader = null;

		ArrayList<String> kelimeler;
		try {
			myReader = new MyReader(new File("src/myFile2.txt"));
			kelimeler = myReader.readWords();
			System.out.println(kelimeler.toString());
		} catch (MyNullReaderException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

		try {
			myReader = new MyReader(new File("src/myFile2.txt"));
			System.out.println("Count of lines in file is : " + myReader.countLines());
		} catch (MyFilenotFoundException e) {
			System.err.println(e.getMessage());
		} catch (FileNotFoundException e) {
			throw new MyFilenotFoundException();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

		try {
			myReader = new MyReader(new File("src/myFile2.txt"));
			int lineNumber=4;
			String line = myReader.readLineAt(lineNumber);
			System.out.println(lineNumber+". line of text is : "+ line);
		} catch (NullLineException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

		try {
			myReader = new MyReader(new File("src/myFile2.txt"));
			int lineNumber=5;
			String line = myReader.readLineAt(lineNumber);
			System.out.println(lineNumber+". line of text is : "+ line);
		} catch (NullLineException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

		try {
			myReader.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

	}

}
