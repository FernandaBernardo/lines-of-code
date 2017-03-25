package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Program;

public class LinesOfCodeTest {

	@Test
	public void shouldReturnAllLinesOfCode() {
		Program program = new Program();
		program.setCode("public interface Dave {\n"
				+ "int countLines(File inFile); // not the real signature!\n"
				+ "}");
		program.run();
		assertEquals(3, program.getLinesOfCode());
	}
}
