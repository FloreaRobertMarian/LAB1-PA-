package shell.commands;

import catalog.InvalidCatalogException;

public class InvalidCommandException extends Exception {
    public InvalidCommandException(String message) {
        super(message);
    }
}
