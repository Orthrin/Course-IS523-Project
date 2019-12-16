import java.io.*;
import domain.SingletonClass;
import domain.NormalClass;

public class Main {

    // Instantiation
    private static SingletonClass instance = SingletonClass.getInstance(); 

    public static void main(String[] args) {
        
        int inc = 0;

        SingletonClass x = SingletonClass.getInstance();
        SingletonClass y = SingletonClass.getInstance();
        SingletonClass z = SingletonClass.getInstance();
        NormalClass a = new NormalClass();
        NormalClass b = new NormalClass();
        NormalClass c = new NormalClass();
        
        x.doSomething();
        y.doSomething();
        z.doSomething();
        a.doSomething();
        b.doSomething();
        c.doSomething();

    }

    // Command Methods

}
