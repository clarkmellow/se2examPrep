public class RekursionAlternateChecksum {
    static int altChecksum(int nextNumber, boolean doAdd) {//current result muss initial 0 sein
        int currentResult = 0;
        if (nextNumber > 0) {
            if (doAdd) {
                currentResult = nextNumber % 10;
            } else {
                currentResult = -(nextNumber % 10);
            }
            return currentResult + altChecksum(nextNumber / 10, !doAdd);
        }
        return currentResult;
    }

    public static void main(String[] args) {
        System.out.println(altChecksum(257, true));
    }
}
