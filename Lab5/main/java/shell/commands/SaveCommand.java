package shell.commands;

import catalog.CatalogUtil;
import shell.Shell;

import java.io.IOException;

public class SaveCommand extends Command {
    public SaveCommand(String[] argumente) {
        super(argumente);
    }

    @Override
    public void execute() throws InvalidCommandException {
        checkArguments(argumente, 1);

        try {
            CatalogUtil.save(Shell.catalog);
        } catch (IOException exception) {
            System.err.println("Catalogul nu a putut fi salvat!\nMotiv: " + exception.getMessage());
        }
    }
}
