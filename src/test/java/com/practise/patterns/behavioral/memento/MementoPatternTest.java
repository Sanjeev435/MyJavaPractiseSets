package com.practise.patterns.behavioral.memento;

import org.junit.Assert;
import org.junit.Test;

public class MementoPatternTest {

	@Test
	public void shouldTestMementoPattern() {

		FileWriterCaretaker caretaker = new FileWriterCaretaker();

		FileWriterUtil fileWriter = new FileWriterUtil("data.txt");
		fileWriter.write("First Set of Data. ");

		Assert.assertEquals("First Set of Data. ", fileWriter.toString());

		// lets save the file
		caretaker.save(fileWriter);
		// now write something else
		fileWriter.write("Second Set of Data. ");

		// checking file contents
		Assert.assertEquals("First Set of Data. Second Set of Data. ", fileWriter.toString());

		// lets undo to last save
		caretaker.undo(fileWriter);

		// checking file content again
		Assert.assertEquals("First Set of Data. ", fileWriter.toString());

	}

}
