package br.com.sample;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class LoggerSample {

    public static void main (final String... args) {
        final System.Logger logger = System.getLogger("br.com.sample.LoggerSample.CustomLogger");
        logger.log(System.Logger.Level.INFO, "Test message");
    }

    public static class CustomLoggerFinder extends System.LoggerFinder {

        @Override
        public System.Logger getLogger (final String name, final Module module) {
            return new CustomLogger();
        }
    }

    static class CustomLogger implements System.Logger {

        @Override
        public String getName () {
            return this.getClass().getName();
        }

        @Override
        public boolean isLoggable (final Level level) {
            return true;
        }

        @Override
        public void log (final Level level, final ResourceBundle bundle, final String msg, final Throwable thrown) {
            System.out.println(MessageFormat.format("{0}: [{1}] - {2}{3}", this.getName(), level, msg, thrown));
        }

        @Override
        public void log (final Level level, final ResourceBundle bundle, final String format, final Object... params) {
            System.out.printf("%s: [%s] - %s", this.getName(), level, MessageFormat.format(format, params));
        }
    }
}
