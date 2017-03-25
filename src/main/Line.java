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
		String endComment = "*/";

		String newLine = line.replaceAll("\\/\\*[\\w|\\s]+\\*\\/", "");
		return newLine.isEmpty()
				|| (newLine.startsWith("/*") && !newLine.contains(endComment))
				|| (newLine.startsWith("*") && (!newLine.contains(endComment) || newLine.lastIndexOf(endComment) == newLine.length()))
				|| (newLine.endsWith(endComment) && newLine.lastIndexOf(endComment) == newLine.length() - endComment.length());
	}

	private boolean isLineOfCode() {
		return line.startsWith("//");
	}
}
