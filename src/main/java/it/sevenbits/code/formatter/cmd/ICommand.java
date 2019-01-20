package it.sevenbits.code.formatter.cmd;

import it.sevenbits.code.writer.WriterException;

/**
 * Interface ICommand.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public interface ICommand {

    /**
     * Executes this command.
     *
     * @throws WriterException - throws when WriterException occurs, and the command cannot be executed.
     */
    void execute() throws WriterException;
}
