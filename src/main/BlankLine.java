package main;

public class BlankLine implements CheckLineProgram {

	@Override
	public boolean validate(String line) {
		return line.isEmpty();
	}

}
