interface Scwbrb {
    void tick();

    int getTicks();

    void waitForBigRedButton();

    default int stress(final Scwbrb s) {
        Thread counter = new Thread() {
            @Override
            public void run() {
                while (!isInterrupted()) {
                    tick();
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        interrupt();
                    }
                }
            }
        };
        counter.start();
        waitForBigRedButton();
        counter.interrupt();
        return getTicks();
    }
}
