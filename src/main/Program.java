package main;

public class Program {
	private String code;
	private int linesOfCode;

	public Program() {
		linesOfCode = 0;
	}

	public void run() {
		String[] lines = code.split("\n");
		for (String line: lines) {
			if(line.startsWith("//")) {
				continue;
			}
			linesOfCode++;
		}
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public int getLinesOfCode() {
		return linesOfCode;
	}
}
