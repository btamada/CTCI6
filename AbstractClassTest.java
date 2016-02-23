/**
 * Created by User1 on 1/7/16.
 */
public class AbstractClassTest extends Hello implements myInterface {
    static String myFirstName;
    static String mySSN;
    public static void main(String[] args) {
        AbstractClassTest act = new AbstractClassTest();
        act.setFirstName("Bryan");
        System.out.println(myFirstName);
        act.setSSN("234-56-7890");
        System.out.println(act.getSSN());
        System.out.println(act.divisorSum(6));
    }

    @Override
    void setFirstName(String fn) {
        this.myFirstName = fn;
    }

    @Override
    public void setSSN(String SSN) {
        this.mySSN = SSN;
    }

    public String getSSN() {
        return this.mySSN;
    }

    @Override
    public int divisorSum(int n) {
        int sumDivisors = 0;
        for(int i = 1; i <= n; ++i) {
            if(n % i == 0) sumDivisors += i;
        }
        return sumDivisors;
    }
}

interface myInterface {
    void setSSN(String SSN);
    int divisorSum(int n);
}

abstract class Hello {
    String firstName;
    String lastName;
    abstract void setFirstName(String fn);
    String getFirstName() {
        return this.firstName;
    }
}
