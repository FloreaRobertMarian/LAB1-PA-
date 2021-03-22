package shell.commands;

import shell.Shell;

import javax.print.attribute.standard.SheetCollate;

public abstract class Command {
    String[] argumente;

    Command(String[] argumente) {
        this.argumente = argumente;
    }

    public static Command buildCommand(String line) throws InvalidCommandException {
        String[] argumente = line.split(" ");

        return switch (argumente[0]) {
            case "load" -> new LoadCommand(argumente);
            case "save" -> new SaveCommand(argumente);
            case "list" -> new ListCommand(argumente);
            case "add" -> new AddCommand(argumente);
            case "play" -> new PlayCommand(argumente);
            case "report" -> new ReportCommand(argumente);
            default -> throw new InvalidCommandException("Comanda nu a fost recunoscuta");
        };
    }

    public static void checkArguments(String[] argumente, int expectedArgc) throws InvalidCommandException {
        if(expectedArgc != argumente.length)
            throw new InvalidCommandException("Numar invalid de argumente");

        if(Shell.catalog == null)
            throw new InvalidCommandException("Nu este incarcat niciun catalog!");
    }

    public abstract void execute() throws InvalidCommandException;
}
