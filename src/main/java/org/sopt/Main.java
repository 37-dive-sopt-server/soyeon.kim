package org.sopt;

import org.sopt.cli.AppConfig;
import org.sopt.cli.ConsoleApplication;

public class Main {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        ConsoleApplication application = appConfig.consoleApplication();

        application.run();

    }
}
