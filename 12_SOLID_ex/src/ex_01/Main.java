package ex_01;

import java.util.Scanner;

import ex_01.appenders.ConsoleAppender;
import ex_01.interfaces.Appender;
import ex_01.interfaces.Layout;
import ex_01.interfaces.Logger;
import ex_01.layouts.SimpleLayout;
import ex_01.models.MessageLogger;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Layout simpleLayout = new SimpleLayout();
		Appender consoleAppender = new ConsoleAppender(simpleLayout);
		Logger logger = new MessageLogger(consoleAppender);

		logger.logError("3/26/2015 2:08:11 PM", "Error parsing JSON.");
		logger.logInfo("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");

	}

}
