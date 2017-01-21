public class InnerClassExample {
    public static void main(String[] args) {
        StaticClass.Bar test = new InnerClassExample().new StaticClass().new Bar();

        // StaticClass.Bar test1 = new StaticClass.Bar();
    }

    class StaticClass {
        /*static*/ class Bar {
        }

    }
}

