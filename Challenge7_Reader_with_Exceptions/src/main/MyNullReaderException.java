package main;

public class MyNullReaderException extends NullPointerException{

	@Override
	public String getMessage()
	{
		return "Reader is null.";
	}
}
