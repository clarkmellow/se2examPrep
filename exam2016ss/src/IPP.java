import java.util.ArrayList;

/**
 * Created by Sascha on 11/01/2017.
 */
public class IPP extends Thread {
    public static final int N = 20;
    private static int counter = 0;
    private IPP previousElem;

    public IPP() {
    }

    public IPP(IPP previousElem) {
        this.previousElem = previousElem;
    }

    public void setPreviousElem(IPP previousElem) {
        this.previousElem = previousElem;
    }

    @Override
    public void run() {
        while (counter < N) {
            while (!interrupted()) {
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    interrupt();
                }
            }
            System.out.println(getName() + " " + counter);
            counter++;
            previousElem.interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final int ringSize = 5;

        ArrayList<IPP> threads = new ArrayList<>();
        threads.add(new IPP());
        for (int i = 0; i < ringSize-1; i++){
            threads.add(new IPP(threads.get(i)));
        }
        threads.get(0).setPreviousElem(threads.get(threads.size()-1));

        for(IPP thread : threads){
            thread.start();
        }

        threads.get(0).interrupt();

    }
}
