package ex_01.appenders;

import emuns.ReportLevel;
import ex_01.interfaces.Appender;
import ex_01.interfaces.Layout;

public abstract class BaseAppender implements Appender {
	private Layout layout;
	private ReportLevel reportLevel;

	public BaseAppender(Layout layout) {
		this.layout = layout;
		this.reportLevel = reportLevel.INFO;
	}

	
	
	@Override
	public void appendMessage(String dateTime, ReportLevel reportLevel, String message) {

		if (this.reportLevel.ordinal() <= reportLevel.ordinal()) {
			String result = String.format(this.layout.getLayout(), dateTime, reportLevel.toString(), message);
			this.append(result);
		}
	}

	
	protected abstract void append(String text);
	
	
	@Override
	public void setReportLevel(ReportLevel reportLevel) {
		this.reportLevel = reportLevel;

	}
}
