package main;

public class NullLineException extends Exception {

	@Override
	public String getMessage()
	{
		return "Asked line is null at file.";
	}
}
