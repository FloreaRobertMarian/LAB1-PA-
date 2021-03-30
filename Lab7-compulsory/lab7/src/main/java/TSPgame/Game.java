package TSPgame;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    private Set<Token> tokens = new HashSet<>();
    private List<Player> players = new ArrayList<>();
    public int n;

    public Game(int n) {
        this.n = n;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;

                tokens.add(new Token(i, j, ThreadLocalRandom.current().nextInt(0, 1001)));
            }

        tokens = Collections.synchronizedSet(tokens);
    }

    public Set<Token> getTokens() {
        return tokens;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void start() {
        for (Player player : players)
            player.start();
    }
}
