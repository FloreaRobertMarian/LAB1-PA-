package shell.commands;

import catalog.CatalogUtil;
import item.Item;
import shell.Shell;

public class PlayCommand extends Command {
    public PlayCommand(String[] argumente) {
        super(argumente);
    }

    @Override
    public void execute() throws InvalidCommandException {
        checkArguments(argumente, 2);

        Item item = Shell.catalog.findById(argumente[1]);
        if(item == null)
            throw new InvalidCommandException("Nu exista acel item in catalog!");


        CatalogUtil.view(item);
    }
}
