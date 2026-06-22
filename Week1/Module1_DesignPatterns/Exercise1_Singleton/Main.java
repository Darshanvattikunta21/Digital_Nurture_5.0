public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Singleton pattern example started.");
        logger2.log("Both logger references point to the same object: " + (logger1 == logger2));
    }
}
