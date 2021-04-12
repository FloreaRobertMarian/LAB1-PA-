package TSPgame;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    private List<Token> tokens = new LinkedList<>();
    private final List<Player> players = new ArrayList<>();
    public int n;
    private Player currentPlayer;
    private int timeout;

    public Game(int n, int timeout) {
        this.n = n;
        this.timeout = timeout;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;

                tokens.add(new Token(i, j));
            }

        tokens = Collections.synchronizedList(tokens);
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }

    public synchronized void getToken(Player player) {
        while(!player.equals(currentPlayer) && !tokens.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if(tokens.isEmpty())
            return;

        Token token = player.selectToken(tokens);
        tokens.remove(token);
        player.addToken(token);
        System.out.println(player.getName() + " removed " + token);
        currentPlayer = players.get((players.indexOf(player) + 1) % players.size());
        notifyAll();
    }

    public void start() {
        currentPlayer = players.get(0);
        List<Thread> threads = new ArrayList<>(players);
        threads.forEach(Thread::start);
        TimeKeeperThread timeKeeper = new TimeKeeperThread(timeout);
        timeKeeper.setDaemon(true);
        timeKeeper.start();

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("done");

        printScores();
    }

    public void printScores() {
        players.forEach(Player::computeScore);

        players.sort(Comparator.comparingInt(Player::getScore));
        Collections.reverse(players);

        System.out.println("=====Clasament=====");
        for (int i=0; i<players.size(); i++)
            System.out.println(i + ": " + players.get(i).getName() + " -> " + players.get(i).getScore());

    }
}
