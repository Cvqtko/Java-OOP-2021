package ex_01.models;

import ex_01.interfaces.File;

public class LogFile implements File {

	private int size;
	private StringBuilder content;

	public LogFile() {

		this.content = new StringBuilder();
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public void write(String text) {
		this.content.append(text);
		this.size += getMessageSize(text);

	}

	private int getMessageSize(String text) {
		return text.chars().filter(ch -> Character.isAlphabetic(ch)).sum();
	}
}
