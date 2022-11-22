package main;

import java.io.FileNotFoundException;

public class MyFilenotFoundException extends FileNotFoundException{

	@Override
	public String getMessage()
	{
		return "The requested file was not found.";
	}
}
