package main;

import java.util.ArrayList;
import java.util.List;

public class CodeFormatter {
	public static List<Line> format(String code) {
		List<Line> linesOfCode = new ArrayList<>();
		
		String newCode = code.trim();
		String[] lines = newCode.split("\n");
		for (String line: lines) {
			linesOfCode.add(new Line(line));
		}
		
		return linesOfCode;
	}
}