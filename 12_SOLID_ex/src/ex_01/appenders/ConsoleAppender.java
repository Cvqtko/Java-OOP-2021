package ex_01.appenders;

import emuns.ReportLevel;
import ex_01.interfaces.Appender;
import ex_01.interfaces.Layout;

public class ConsoleAppender implements Appender {

	private Layout layout;
	private ReportLevel reportLevel;

	public ConsoleAppender(Layout layout) {
		this.layout = layout;
		this.reportLevel = reportLevel.INFO;
	}

	@Override
	public void appendMessage(String dateTime, ReportLevel reportLevel, String message) {
		
		if (this.reportLevel.ordinal() <= reportLevel.ordinal()) {
			System.out.println(String.format(this.layout.getLayout(), dateTime, reportLevel.toString(), message));

		}
	}

	@Override
	public void setReportLevel(ReportLevel reportLevel) {
		this.reportLevel = reportLevel;

	}

}
