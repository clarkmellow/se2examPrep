public class Slave extends Thread {
    private final int init;
    private final Master master;

    public Slave(Master m, int i) {
        master = m;
        init = i;
    }

    @Override
    public void run() {
        // do something
        try {
            sleep(init * 5_000);
        } catch (InterruptedException e) {
        }
        // end do something

        synchronized (master) {
            master.endedThreads++;
            master.notifyAll();
        }
    }
}


