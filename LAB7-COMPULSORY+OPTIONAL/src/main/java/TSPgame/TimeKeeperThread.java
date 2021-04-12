package TSPgame;

public class TimeKeeperThread extends Thread {
    private final long timeout;

    public TimeKeeperThread(int timeout) {
        this.timeout = timeout * (long) 1e+9; // nanoseconds
    }

    @Override
    public void run() {
        long start = System.nanoTime();

        while (true) {
            if (System.nanoTime() - start > timeout) {
                System.err.println("Time limit exceeded!");
                System.exit(0);
            }
        }
    }
}
