public class Money implements Cloneable {
    public static final int TOTAL = 20;
    private int coins;

    public int getCoins() {
        return coins;
    }

    private void setCoins(int coins) {
        this.coins = coins;
    }

    private Money(int coins) {
        this.coins = coins;
    }

    public static class CreateMoney {
        private static int sumUsedCoins;

        public Money make(int coins) {
            if(coins < 1) return null;
            if (sumUsedCoins + coins > TOTAL) return null;
            else {
                sumUsedCoins += coins;
                return new Money(coins);
            }
        }
    }

    public Money split(int coins){
        if(coins <1) return null;
        if(getCoins()-coins<=1){
            setCoins(1);
        } else{
            setCoins(getCoins()-coins);
        }
        return new CreateMoney().make(coins);
    }

    public Money clone(){
        if(CreateMoney.sumUsedCoins + getCoins() > TOTAL) return null;
        return new CreateMoney().make(getCoins());
    }
}
