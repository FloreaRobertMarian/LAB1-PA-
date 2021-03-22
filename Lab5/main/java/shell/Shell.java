package shell;

import catalog.Catalog;
import shell.commands.Command;
import shell.commands.InvalidCommandException;

import java.util.Scanner;

public class Shell {
    public static Catalog catalog = null;

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Shell-ul a fost pornit. Scrie comanda mai jos");
        while (true) {
            try {
                Command command = Command.buildCommand(scanner.nextLine());
                command.execute();
                System.out.println("Comanda executata cu succes!");
            } catch (InvalidCommandException exception) {
                System.err.println(exception.getMessage());
            }
        }

    }
}
