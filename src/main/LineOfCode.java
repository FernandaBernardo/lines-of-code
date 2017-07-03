package main;

public class LineOfCode implements CheckLineProgram {

	@Override
	public boolean validate(String line) {
		return line.startsWith("//");
	}

}
