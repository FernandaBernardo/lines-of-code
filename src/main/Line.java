package main;

import java.util.ArrayList;
import java.util.List;

public class Line {
	private boolean isComment;
	private List<CheckLineProgram> checks = new ArrayList<>();

	public Line(String line) {
		addChecks();
		verify(line);
	}

	private void verify(String line) {
		for (CheckLineProgram checkLineProgram : checks) {
			this.isComment = isComment ? true : checkLineProgram.validate(line);
		}
	}

	public boolean isComment() {
		return isComment;
	}

	private void addChecks() {
		checks.add(new LineOfCode());
		checks.add(new BlockOfCode());
		checks.add(new BlankLine());
	}
}
