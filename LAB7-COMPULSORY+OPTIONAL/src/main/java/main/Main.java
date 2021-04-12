package main;

import TSPgame.Game;
import TSPgame.Player;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        simulateSmallGame();
        //simulateLargeContest();
    }

    public static void simulateSmallGame() {
        Game game = new Game(3, 10);

        Player player1 = new Player("1", "bot");
        Player player2 = new Player("2", "manual");

        game.addPlayer(player1);
        game.addPlayer(player2);

        game.start();

        // player1.printWallet();
        // player2.printWallet();
    }

    public static void simulateLargeContest() {
        Game game = new Game(100, 100);

        IntStream.range(0, 100).mapToObj(i -> new Player("" + i, "bot")).forEach(game::addPlayer);

        game.start();
    }

}
