public class Master {
    int endedThreads;

    public Master(int... inits) {
        for (int init : inits)
            new Slave(this, init).start();
    }

    // Test implementation - not part of exam
    public static void main(String[] args) throws InterruptedException {
        Master test = new Master(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        test.waitFor(7);
    }

    void waitFor(int n) throws InterruptedException {
        while (endedThreads < n) {
            synchronized (this) {
                wait();
            }
        }
    }
}
