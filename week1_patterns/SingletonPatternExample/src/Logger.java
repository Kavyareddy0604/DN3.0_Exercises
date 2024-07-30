// Logger.java
public class Logger {
    // Private static instance of the same class that is the only instance of the class.
    private static Logger instance;

    // Private constructor to restrict instantiation of the class from other classes.
    private Logger() {
    }

    // Public static method that returns the instance of the class, creating it if it doesn't already exist.
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // A method to demonstrate logging functionality.
    public void log(String message) {
        System.out.println("Log message: " + message);
    }
}
