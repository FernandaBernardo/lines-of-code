package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Program;

public class LinesOfCodeTest {

	@Test
	public void shouldReturnAllLinesOfCode() {
		Program program = new Program();
		program.setCode("public interface Dave {\n"
				+ "int countLines(File inFile);\n"
				+ "}");
		program.run();
		assertEquals(3, program.getLinesOfCode());
	}

	@Test
	public void shouldIgnoreCommentLine() {
		Program program = new Program();
		program.setCode("public interface Dave {\n"
				+ "int countLines(File inFile); \n"
				+ "// not the real signature!\n"
				+ "}");
		program.run();
		assertEquals(3, program.getLinesOfCode());
	}

	@Test
	public void shouldIgnoreBlockComment() {
		Program program = new Program();
		program.setCode("public interface Dave {\n"
				+ "/*\n"
				+ "*only block of comment\n"
				+ "*/\n"
				+ "int countLines(File inFile); \n"
				+ "// not the real signature!\n"
				+ "}");
		program.run();
		assertEquals(3, program.getLinesOfCode());
	}

	@Test
	public void shouldIgnoreBlankLines() {
		Program program = new Program();
		program.setCode("public interface Dave {\n\n"
				+ "int countLines(File inFile); \n\n"
				+ "}");
		program.run();
		assertEquals(3, program.getLinesOfCode());
	}

	@Test
	public void shouldCountCodeAfterComment() {
		Program program = new Program();
		program.setCode("public interface Dave {\n"
				+ "/* comment */int countLines(File inFile); \n"
				+ "}");
		program.run();
		assertEquals(3, program.getLinesOfCode());
	}
}
