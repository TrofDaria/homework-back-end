package it.sevenbits.code.formatter.cmd.append.lexeme;

import it.sevenbits.code.formatter.cmd.ICommand;
import it.sevenbits.code.lexer.token.IToken;
import it.sevenbits.code.writer.IWriter;
import it.sevenbits.code.writer.WriterException;

/**
 * Class AppendLexeme.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class AppendLexeme implements ICommand {

    private IToken token;
    private IWriter writer;

    /**
     * Constructor.
     *
     * @param token - IToken from where lexeme is taken.
     * @param writer - IWriter to use.
     */
    public AppendLexeme(final IToken token, final IWriter writer) {
        this.token = token;
        this.writer = writer;
    }

    /**
     * Appends token's lexeme.
     *
     * @throws WriterException - throws when WriterException occurs, and the command cannot be executed.
     */
    @Override
    public void execute() throws WriterException {
        char[] lexeme = token.getLexeme().toCharArray();
        for (char c : lexeme) {
            writer.write(c);
        }
    }
}
