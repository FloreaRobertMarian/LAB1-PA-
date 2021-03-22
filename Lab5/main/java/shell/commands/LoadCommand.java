package shell.commands;

import catalog.CatalogUtil;
import catalog.InvalidCatalogException;
import shell.Shell;

public class LoadCommand extends Command {
    public LoadCommand(String[] argumente) {
        super(argumente);
    }

    @Override
    public void execute() throws InvalidCommandException {
        if(argumente.length != 2)
            throw new InvalidCommandException("Numar invalid de argumente");

        try {
            Shell.catalog = CatalogUtil.load(argumente[1]);
        } catch (InvalidCatalogException exception) {
            throw new InvalidCommandException("Nu s-a putut incarca catalogul\nMotiv " + exception.getMessage());
        }
    }
}
