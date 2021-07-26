package ex_01.interfaces;

import emuns.ReportLevel;

public interface Appender {
	void appendMessage(String dateTime, ReportLevel reportLevel, String message);
	void setReportLevel(ReportLevel reportLevel);
}
