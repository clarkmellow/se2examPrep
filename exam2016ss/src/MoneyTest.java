/**
 * Created by Sascha on 12/01/2017.
 */
public class MoneyTest {
    public static void main(String[] args) {
        Money test = new Money.CreateMoney().make(7);
        //Money test1 = new Money.CreateMoney().make(8);
        Money test2 = new Money.CreateMoney().make(5);
        Money test3 = new Money.CreateMoney().make(1);
        System.out.println(test.getCoins());    // OK
        //System.out.println(test1.getCoins());   // OK
        System.out.println(test2.getCoins());   // OK
        //System.out.println(test3.getCoins()); // ERROR -> NullPointerException

        Money test4 = test2.split(3);
        System.out.println(test2.getCoins());
        System.out.println(test4.getCoins());
        Money test5 = test4.clone();
        System.out.println(test5.getCoins());
    }
}
