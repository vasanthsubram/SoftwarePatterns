package patterns.behavioural.chainOfCommand;

enum LogLevel {
    INFO,
    DEBUG,
    ERROR
}

abstract class Logger {
    protected LogLevel level;
    protected Logger next;

    public Logger(LogLevel level) {
        this.level = level;
    }

    public void setNext(Logger next) {
        this.next = next;
    }

    public void logMessage(LogLevel level, String message) {
        if (this.level == level) {
            write(message);
        }
        if (next != null) {
            next.logMessage(level, message);
        }
    }

    protected abstract void write(String message);
}

class InfoLogger extends Logger {
    public InfoLogger() {
        super(LogLevel.INFO);
    }

    @Override
    protected void write(String message) {
        System.out.println("INFO: " + message);
    }
}

class DebugLogger extends Logger {
    public DebugLogger() {
        super(LogLevel.DEBUG);
    }

    @Override
    protected void write(String message) {
        System.out.println("DEBUG: " + message);
    }
}

class ErrorLogger extends Logger {
    public ErrorLogger() {
        super(LogLevel.ERROR);
    }

    @Override
    protected void write(String message) {
        System.out.println("ERROR: " + message);
    }
}

public class ChainOfCommandDemo {
    public static void main(String[] args) {
        Logger errorLogger = new ErrorLogger();
        Logger debugLogger = new DebugLogger();
        Logger infoLogger = new InfoLogger();

        errorLogger.setNext(debugLogger);
        debugLogger.setNext(infoLogger);

        errorLogger.logMessage(LogLevel.INFO, "This is an information.");
        errorLogger.logMessage(LogLevel.DEBUG, "This is a debug message.");
        errorLogger.logMessage(LogLevel.ERROR, "This is an error message.");
    }
}