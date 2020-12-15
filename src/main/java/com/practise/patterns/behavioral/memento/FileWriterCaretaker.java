package com.practise.patterns.behavioral.memento;

/**
 * @author Sanjeev Kumar
 * 
 *         Memento Pattern Caretaker Class : creates and restores the memento
 *         objects.
 *
 */
public class FileWriterCaretaker {
	private Object obj;

	public void save(FileWriterUtil fileWriter) {
		this.obj = fileWriter.save();
	}

	public void undo(FileWriterUtil fileWriter) {
		fileWriter.undoToLastSave(obj);
	}
}
