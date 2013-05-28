package biz.innform.nagendra;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
        public static void main(String[] args) {
            int bitmask = 0x00FF;
            int val = 0x2222;
            // prints "2"
            System.out.println(val & bitmask);
        }

/*
    public static void main(String[] args) {
        System.out.println( "Hello World!" );
        try {
            System.out.println(stringCompare("abcdefghijklmn","abc","jkl"));
            System.out.println(stringCompare("abcdefghijklmn","jkl","abc"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String stringCompare(String s1, String s2, String s3) {
    String tmp = "";
    int i = s1.indexOf(s2, 0);
    int j = s1.indexOf(s3, 0);
    if (i > j) {
        System.out.println(i);
        System.out.println(j);
        tmp = s1.substring(s3.length(), i);
    } else if (j > i) {
        System.out.println(i);
        System.out.println(j);
        tmp = s1.substring(s2.length(), j);
    }

    for (Field field : s1.getClass().getDeclaredFields()) {
        System.out.println(field.getType().getName());
    }
    return tmp;
}
*/
}
