package ex_01.appenders;

import emuns.ReportLevel;
import ex_01.interfaces.Appender;
import ex_01.interfaces.Layout;

public class ConsoleAppender extends BaseAppender {

	public ConsoleAppender(Layout layout) {
		super(layout);

	}

	@Override
	protected void append(String text) {
		System.out.println(text);

	}

}
