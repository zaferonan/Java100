package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

public class MyReader extends FileReader {

	private BufferedReader bufferedReader;

	public MyReader(File file) throws IOException {
		super(file);
		bufferedReader = new BufferedReader(this);
		
	}

	public int countLines() throws MyNullReaderException, IOException {
		
		if (bufferedReader == null) {
			throw new MyNullReaderException();
		} else {
			int count = 0;
			String lineRead = "";
			while ((lineRead = bufferedReader.readLine()) != null) {
				count++;
			}
			
			return count;
		}
	}

	public String readLineAt(int i) throws MyNullReaderException, NullLineException, IOException {

		
		if (bufferedReader == null) {
			throw new MyNullReaderException();
		} else {
			for (int j = 0; j < i - 1; j++) {
				bufferedReader.readLine();
			}
			String line = bufferedReader.readLine();
			
			if (line.equals("")) {
				throw new NullLineException();
			} else {
				return line;
			}
		}

	}

	public ArrayList<String> readWords() throws MyNullReaderException, IOException {
		
		if (bufferedReader == null) {
			throw new MyNullReaderException();
		} else {
			ArrayList<String> wordList = new ArrayList<>();
			StringBuilder stringBuilder = new StringBuilder();

			while(bufferedReader.ready()) {
				String line;
				try {
					line = bufferedReader.readLine();
					for (int j = 0; j < line.length(); j++) {
						if (line.charAt(j) != ' ') {
							stringBuilder.append(line.charAt(j));
						} else {
							if (!stringBuilder.isEmpty()) {
								wordList.add(stringBuilder.toString());
								stringBuilder = new StringBuilder();
							}
						}
					}
				} catch (Exception e) {

				} finally {
					if (!stringBuilder.isEmpty()) {
						wordList.add(stringBuilder.toString());
						stringBuilder = new StringBuilder();
					}
				}

			}
			
			return wordList;
		}
	}

}
