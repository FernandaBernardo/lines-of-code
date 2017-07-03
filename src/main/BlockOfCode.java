package main;

public class BlockOfCode implements CheckLineProgram {

	@Override
	public boolean validate(String line) {
		String endComment = "*/";

		String newLine = line.replaceAll("\\/\\*[\\w|\\s]+\\*\\/", "");
		return newLine.isEmpty()
				|| (newLine.startsWith("/*") && !newLine.contains(endComment))
				|| (newLine.startsWith("*") && (!newLine.contains(endComment) || newLine.lastIndexOf(endComment) == newLine.length()))
				|| (newLine.endsWith(endComment) && newLine.lastIndexOf(endComment) == newLine.length() - endComment.length());
	}

}
