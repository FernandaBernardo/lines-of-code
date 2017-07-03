package main;

import java.util.List;

public class Program {
	private List<Line> linesOfCode;

	public Program(String code) {
		this.linesOfCode = CodeFormatter.format(code);
	}

	public int getLinesOfCode() {
		int count = 0;
		for (Line line : linesOfCode) {
			if(!line.isComment()) {
				count++;
			}
		}
		return count;
	}
}
