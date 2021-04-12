package TSPgame;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Player extends Thread {
    private final String name;
    private final List<Token> wallet = new ArrayList<>();
    private Game game;
    private final int strategy;
    private int score = 0;

    public Player(String name, String strategy) {
        this.name = name;
        if (strategy.equals("manual"))
            this.strategy = 1;
        else
            this.strategy = 0; // bot

        super.setName(name);
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getScore() {
        return score;
    }

    public void addToken(Token token) {
        wallet.add(token);
    }

    @Override
    public void run() {
        List<Token> tokens = game.getTokens();
        while (!tokens.isEmpty()) {
            game.getToken(this);
        }
    }

    public void printWallet() {
        System.out.println(name + "'s wallet: ");
        for (var token : wallet)
            System.out.println(token);

        System.out.println();
    }

    public Token selectToken(List<Token> tokens) {
        if (strategy == 0) { // bot
            return tokens.get(ThreadLocalRandom.current().nextInt(0, tokens.size()));
        } else {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("wanted token: ");
                Token token = new Token(scanner.nextInt(), scanner.nextInt());
                if (tokens.contains(token))
                    return token;
                else
                    System.out.println("Token doesn't exist!");
            }
        }
    }

    public void computeScore() {
        // scorul va fi suma valorilor de pe tokene
        for (Token token : wallet)
            score += token.getValue1() + token.getValue2();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}