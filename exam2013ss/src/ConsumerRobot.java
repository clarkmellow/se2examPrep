/**
 * Created by Sascha on 02/01/2017.
 */
public class ConsumerRobot extends Thread {
    final MaxSizeQueue<Part> queue;

    public ConsumerRobot(MaxSizeQueue<Part> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            queue.dequeue();
        }
    }
}
