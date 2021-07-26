package ex_01.models;

import emuns.ReportLevel;
import ex_01.interfaces.Appender;
import ex_01.interfaces.Logger;

public class MessageLogger implements Logger {
	private Appender[] appenders;

	public MessageLogger(Appender... appenders) {
		this.appenders = appenders;
	}

	@Override
	public void logInfo(String dateTime, String message) {
		this.logMessage(dateTime, ReportLevel.INFO, message);

	}

	@Override
	public void logWarning(String dateTime, String message) {
		this.logMessage(dateTime, ReportLevel.WARNING, message);

	}

	@Override
	public void logError(String dateTime, String message) {
		this.logMessage(dateTime, ReportLevel.ERROR, message);
	}

	@Override
	public void logCritical(String dateTime, String message) {
		this.logMessage(dateTime, ReportLevel.CRITICAL, message);

	}

	@Override
	public void logFatal(String dateTime, String message) {
		this.logMessage(dateTime, ReportLevel.FATAL, message);

	}

	private void logMessage(String dateTime, ReportLevel reportLevel, String message) {
		for (Appender appender : this.appenders) {
			appender.appendMessage(dateTime, reportLevel, message);
		}
	}

	public String getLogInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("Logger info");
		for (Appender appender : this.appenders) {
			sb.append(System.lineSeparator()).append(appender);

		}
		return sb.toString();
	}

}
