package ex_01.appenders;

import ex_01.interfaces.File;
import ex_01.interfaces.Layout;
import ex_01.models.LogFile;

public class FileAppender extends BaseAppender{

	private File file;
	
	public FileAppender(Layout layout) {
		super(layout);
		this.file = new LogFile();

	}

	@Override
	protected void append(String text) {
		this.file.write(text);
		
	}



}
