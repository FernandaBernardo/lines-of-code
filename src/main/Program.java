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
			if(isLineOfCode(line) || isBlockOfCode(line) || isBlankLine(line)) {
				continue;
			}
			linesOfCode++;
		}
	}

	private boolean isBlankLine(String line) {
		return line.isEmpty();
	}

	private boolean isBlockOfCode(String line) {
		return (line.startsWith("/*") && (line.endsWith("*/") || !line.contains("*/")))
				|| line.startsWith("*")
				|| (line.endsWith("*/") && line.indexOf("*/") == line.length());
	}

	private boolean isLineOfCode(String line) {
		return line.startsWith("//");
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
