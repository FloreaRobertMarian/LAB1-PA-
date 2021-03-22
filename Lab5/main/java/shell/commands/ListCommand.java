package shell.commands;

import shell.Shell;

public class ListCommand extends Command {
    public ListCommand(String[] argumente) {
        super(argumente);
    }

    @Override
    public void execute() throws InvalidCommandException {
        checkArguments(argumente, 1);

        Shell.catalog.list();
    }
}
