public class LoggingTest {
    public static void main(String[] args) {
        
        Logger logger = Logger.newLogger("LoggingTest.main");

        
        // info method test
        String[] strings1 = {"Parham Ahmadi", "123456"};
        logger.info("Authentication request is: name:{}, Password:{}", strings1);

        // warn method test
        String[] strings2 = {"Parham", "Roufarshbaf"};
        logger.warn("User: {} with password: {} is trying to access to invalid index", strings2);

        // error method test
        String[] Strings2 = {"Parham Ahmadi", "123456"};
        logger.error("The user:{} with password:{} has entered invalid index", Strings2);

    }
}