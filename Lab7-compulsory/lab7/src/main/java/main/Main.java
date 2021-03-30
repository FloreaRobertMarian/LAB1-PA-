package main;

import TSPgame.Game;
import TSPgame.Player;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(10);

        Player player1 = new Player("Ana");
        Player player2 = new Player("Andrei");

        player1.setGame(game);
        player2.setGame(game);

        game.addPlayer(player1);
        game.addPlayer(player2);

        game.start();

        player1.printWallet();
        player2.printWallet();
    }


}
