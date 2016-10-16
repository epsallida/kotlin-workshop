package _0Variance;

/*
Task 1.
Complete the method 'foo' in the way to make 'bar' throw ArrayStoreException.
*/

import kotlin.NotImplementedError;

public class Task1_JavaArrays {
    private static void foo(Object[] array) {
        array[0] = 1;
    }

    private static void bar() {
        String[] strings = new String[] { "a", "b", "c" };
        foo(strings);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static void main(String[] args) {
        bar();
    }
}
