package it.sevenbits.code.lexer.cmd.append;

import it.sevenbits.code.lexer.cmd.ICommand;
import it.sevenbits.code.lexer.cmd.ICommandFactory;
import it.sevenbits.code.lexer.token.TokenBuilder;

/**
 * Class AppendFactory.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class AppendFactory implements ICommandFactory {

    /**
     * Creates Append command.
     *
     * @param tokenBuilder  - TokenBuilder to pass to Append command.
     * @param c - char to pass to Append command.
     */
    @Override
    public ICommand createCommand(final TokenBuilder tokenBuilder, final char c) {
        return new Append(tokenBuilder, c);
    }
}
