package biz.innform.nagendra;

import java.lang.reflect.Field;

/**
 * Created by IntelliJ IDEA.
 * User: Nagendra
 * Date: 10/17/11
 * Time: 5:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReflectionDemo {
    public void copyBean(Object o1,Object o2){
        int i=o1.getClass().getDeclaredFields().length;
        int j=o2.getClass().getDeclaredFields().length;
        if(i==j){
            Field[] field2=o2.getClass().getDeclaredFields();
            int k=0;
            for(Field field:o1.getClass().getDeclaredFields()){

            }
        }
    }
}
