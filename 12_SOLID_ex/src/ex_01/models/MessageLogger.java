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
		// TODO Auto-generated method stub

	}

	@Override
	public void logWarning(String dateTime, String message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void logError(String dateTime, String message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void logCritical(String dateTime, String message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void logFatal(String dateTime, String message) {
		// TODO Auto-generated method stub

	}

	private void logMessage(String dateTime, ReportLevel reportLevel, String message) {
		for (Appender appender : this.appenders) {
			appender.appendMessage(dateTime, reportLevel, message);
		}
	}
}
