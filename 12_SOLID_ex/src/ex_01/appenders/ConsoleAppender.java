package ex_01.appenders;

import emuns.ReportLevel;
import ex_01.interfaces.Appender;
import ex_01.interfaces.Layout;

public class ConsoleAppender implements Appender {

	private Layout layout;

	public ConsoleAppender(Layout layout) {
		this.layout = layout;
	}

	@Override
	public void appendMessage(String dateTime, ReportLevel reportLevel, String message) {
		System.out.println(String.format(this.layout.getLayout(), dateTime, reportLevel.toString(), message));

	}

}
