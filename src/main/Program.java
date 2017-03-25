package main;

import java.util.ArrayList;
import java.util.List;

public class Program {
	private List<Line> linesOfCode;

	public Program(String code) {
		this.linesOfCode = new ArrayList<>();
		formatCode(code);
	}

	private void formatCode(String code) {
		String[] lines = code.split("\n");
		for (String line: lines) {
			this.linesOfCode.add(new Line(line));
		}
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
