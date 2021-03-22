package shell.commands;

import catalog.InvalidCatalogException;
import item.Book;
import item.Song;
import shell.Shell;

public class AddCommand extends Command {
    public AddCommand(String[] argumente) {
        super(argumente);
    }

    @Override
    public void execute() throws InvalidCommandException {
        checkArguments(argumente, 4);

        try {
            Shell.catalog.add(
                    switch (argumente[1]) {
                        case "book" -> new Book(argumente[2], argumente[3]);
                        case "song" -> new Song(argumente[2], argumente[3]);
                        default -> throw new InvalidCommandException("Nu exista acel tip de item");
                    }
            );
        } catch (InvalidCatalogException exception) {
            throw new InvalidCommandException("Nu a fost putut adaugat item-ul\n Motiv: " + exception.getMessage());
        }
    }
}
