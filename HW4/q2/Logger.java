import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private String className;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SS");

    //constructor
    private Logger(String className) {
        this.className = className;
    }

    /**
     * Our method to create new object of Logger class.
     * @param className
     * @return
     */
    public static Logger newLogger(String className) {
        return new Logger(className);
    }

    /**
     * This method is for log in info mode.
     * @param str1
     * @param array
     */
    public void info(String str1, String[] array) {
        String date = LocalDateTime.now().format(formatter);
        System.out.println(date + " [INFO] " + className);
        if (array == null) {
            System.out.println(str1);
            return;
        }
        String[] inputs = str1.split("\\{}");
        String output = "";
        for (int i = 0; i < inputs.length; i++) {
            output += inputs[i];
            if (i < array.length) {
                output +=  array[i];
            }
        }
        System.out.println(output);
    }

    /**
     * This method is for log in error mode.
     * @param str1
     * @param array
     */
    public void error(String str1, String[] array) {
        String date = LocalDateTime.now().format(formatter);
        System.out.println(date + " [ERROR] " + className);
        if (array == null) {
            System.out.println(str1);
            return;
        }
        String[] inputs = str1.split("\\{}");
        String output = "";
        for (int i = 0; i < inputs.length; i++) {
            output += inputs[i];
            if (i < array.length) {
                output +=  array[i];
            }
        }
        System.out.println(output);
    }

    /**
     * This method is for log in warn mode.
     * @param str1
     * @param array
     */
    public void warn(String str1, String[] array) {
        String date = LocalDateTime.now().format(formatter);
        System.out.println(date + " [WARN] " + className);
        if (array == null) {
            System.out.println(str1);
            return;
        }
        String[] inputs = str1.split("\\{}");
        String output = "";
        for (int i = 0; i < inputs.length; i++) {
            output += inputs[i];
            if (i < array.length) {
                output +=  array[i];
            }
        }
        System.out.println(output);
    }
}