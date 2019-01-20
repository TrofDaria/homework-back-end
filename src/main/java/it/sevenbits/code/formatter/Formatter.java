package it.sevenbits.code.formatter;

import it.sevenbits.code.formatter.cmd.CommandRepository;
import it.sevenbits.code.formatter.sm.State;
import it.sevenbits.code.formatter.sm.StateTransition;
import it.sevenbits.code.formatter.cmd.ICommand;
import it.sevenbits.code.lexer.ILexer;
import it.sevenbits.code.lexer.ILexerFactory;
import it.sevenbits.code.lexer.token.IToken;
import it.sevenbits.code.reader.IReader;
import it.sevenbits.code.reader.ReaderException;
import it.sevenbits.code.writer.IWriter;
import it.sevenbits.code.writer.WriterException;

/**
 * Class Formatter formats Java code.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class Formatter implements IFormatter {

    private ILexerFactory lexerFactory;

    /**
     * Constructor.
     *
     * @param lexerFactory - lexerFactory creates lexers.
     **/
    public Formatter(final ILexerFactory lexerFactory) {
        this.lexerFactory = lexerFactory;
    }

    /**
     * Formats white spaces and new lines.
     *
     * @param reader - source of code to format.
     * @param writer - storage for formatted code.
     * @throws ReaderException - throws when reading exception occurs.
     * @throws WriterException - throws when writing exception occurs.
     */
    public void format(final IReader reader, final IWriter writer) throws ReaderException, WriterException {
        StateTransition stateTransition = new StateTransition();
        State state = stateTransition.getStartState();
        ILexer lexer = lexerFactory.createLexer(reader);
        IndentManager indentManager = new IndentManager();
        CommandRepository commandRepository = new CommandRepository(indentManager, writer);

        while (lexer.hasMoreTokens() && state != null) {
            IToken token = lexer.readToken();
            ICommand cmd = commandRepository.getCommand(state, token);
            cmd.execute();
            state = stateTransition.nextState(state, token);
        }
    }
}


