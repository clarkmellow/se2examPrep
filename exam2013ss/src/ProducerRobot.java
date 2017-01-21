public class ProducerRobot extends Thread {
    final MaxSizeQueue<Part> queue;

    public ProducerRobot(MaxSizeQueue<Part> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            Part elem = new Part();
            queue.enqueue(elem);
        }
    }
}
