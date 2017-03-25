package main;

public class Line {
	private boolean isComment;
	private String line;

	public Line(String line) {
		this.line = line;
		verify();
	}

	public boolean isComment() {
		return isComment;
	}

	private void verify() {
		this.isComment = isLineOfCode() || isBlockOfCode() || isBlankLine();
	}

	private boolean isBlankLine() {
		return line.isEmpty();
	}

	private boolean isBlockOfCode() {
		return (line.startsWith("/*") && (line.endsWith("*/") || !line.contains("*/")))
				|| line.startsWith("*")
				|| (line.endsWith("*/") && line.indexOf("*/") == line.length());
	}

	private boolean isLineOfCode() {
		return line.startsWith("//");
	}
}
