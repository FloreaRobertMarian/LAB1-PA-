package TSPgame;


import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Player extends Thread {
    private String name;
    private Set<Token> wallet = new HashSet<>();
    private Game game;

    public Player(String name) {
        this.name = name;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        Set<Token> tokens = game.getTokens();
        while (!tokens.isEmpty()) {
            int i = ThreadLocalRandom.current().nextInt(0, game.n);
            int j = ThreadLocalRandom.current().nextInt(0, game.n);
            int rand = ThreadLocalRandom.current().nextInt(0, 1001);
            Token desiredToken = new Token(i,j,rand);
            if(tokens.remove(desiredToken))
                wallet.add(desiredToken);

            tokens = game.getTokens();
        }
    }

    public void printWallet() {
        System.out.println(name + "'s wallet: ");
        for (var token:wallet)
            System.out.println(token);

        System.out.println();
    }
}
