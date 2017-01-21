/**
 * Created by Sascha on 20/01/2017.
 */
public class Aufgabe1 {
    public static void main(String[] args) {
        StaticClass.Bar test = new Aufgabe1().new StaticClass().new Bar();

        // StaticClass.Bar test1 = new StaticClass.Bar();
    }

    class StaticClass {
        /*static*/ class Bar {
        }

    }
}

