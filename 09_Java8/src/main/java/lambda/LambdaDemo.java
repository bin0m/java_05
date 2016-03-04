package lambda;

import static java.lang.System.out;

/**
 * Лямбда-выражения
 */
public class LambdaDemo {

    public static void main(String[] args) {
        int[] ints = {1, 2, 4};
        Operation op = (x, y) -> x + y;
        out.println("Sum: " + f(ints, op));
        out.println("Mul: " + f(ints, (x, y) -> x * y));
        out.println("Max: " + f(ints, (x, y) -> (x > y) ? x : y));
        out.println("Min: " + f(ints, (x, y) -> (x < y) ? x : y));
        out.println("Max: " + f(ints, Math::max));
    }

    private static int f(int[] arr, Operation op) {
        if (arr.length < 1)
            throw new IllegalArgumentException("Массив должен содержать хотя бы один элемент");
        int res = arr[0];
        for (int i = 1; i < arr.length; i++)
            res = op.apply(res, arr[i]);
        return res;
    }
}