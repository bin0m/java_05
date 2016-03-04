import com.sun.javaws.exceptions.InvalidArgumentException;

/**
 * Exception
 * RuntimeException
 */
public class ExceptionDemo {

    public static void main(String[] args) throws Exception {
        //System.setOut(new PrintStream("my.log"));
        System.out.println("Запуск программы");
        f(10);
    }

    private static void f(int i) throws InvalidArgumentException {
        //throw new MyRuntimeException("xx", 2, 1);
        if (i == 0)
            throw new MyRuntimeException("11", 1, 2);
        // InvalidArgumentException(new String[]{"i == 0"});
        f(i - 1);
    }
}
