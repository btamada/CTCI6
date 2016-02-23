import java.lang.reflect.Method;

/**
 * Created by Bryan Tamada on 1/7/16.
 */
public class Reflection {
    public static void main(String[] args) {
        Class myClass = "foo".getClass();
        System.out.println("The class of 'foo' is: " + myClass.getName());
        Method[] myMethods = myClass.getDeclaredMethods();
        for(Method m : myMethods) {
            System.out.println("Method Name: " + m.getName());
            Class<?> parameterTypes[] = m.getParameterTypes();
            for(Object o : parameterTypes) {
                System.out.println(o);
            }
        }
    }
}

class ParentClass {
    public void print(String n) {
        System.out.println(n);
    }
}

class ChildClass extends ParentClass {
    private int myAge = 0;
    public String myName = "Bryan";
    public void print(String n) {
        System.out.println(n);
    }
}