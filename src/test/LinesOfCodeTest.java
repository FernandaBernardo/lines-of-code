package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Program;

public class LinesOfCodeTest {

	@Test
	public void shouldReturnAllLinesOfCode() {
		String code = "public interface Dave {\n"
				+ "int countLines(File inFile);\n"
				+ "}";
		Program program = new Program(code);
		assertEquals(3, program.getLinesOfCode());
	}

	@Test
	public void shouldIgnoreCommentLine() {
		String code = "public interface Dave {\n"
				+ "int countLines(File inFile); \n"
				+ "// not the real signature!\n"
				+ "}";
		Program program = new Program(code);
		assertEquals(3, program.getLinesOfCode());
	}

	@Test
	public void shouldIgnoreBlockComment() {
		String code = "public interface Dave {\n"
				+ "/*\n"
				+ "*only block of comment\n"
				+ "*/\n"
				+ "int countLines(File inFile); \n"
				+ "// not the real signature!\n"
				+ "}";
		Program program = new Program(code);
		assertEquals(3, program.getLinesOfCode());
	}

	@Test
	public void shouldIgnoreBlankLines() {
		String code = "public interface Dave {\n\n"
				+ "int countLines(File inFile); \n\n"
				+ "}";
		Program program = new Program(code);
		assertEquals(3, program.getLinesOfCode());
	}

	@Test
	public void shouldCountCodeAfterComment() {
		String code = "public interface Dave {\n"
				+ "/* comment */int countLines(File inFile); \n"
				+ "}";
		Program program = new Program(code);
		assertEquals(3, program.getLinesOfCode());
	}
}
