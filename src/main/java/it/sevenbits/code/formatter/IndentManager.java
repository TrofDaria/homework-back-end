package it.sevenbits.code.formatter;

/**
 * Class IndentManager manages indents.
 *
 * @author Daria Trofimova
 * @version 1.0
 * @since 2018-11-1
 */
public class IndentManager {

    private int currentIndent;
    private int defaultIndent = 4;

    /**
     * Constructor.
     */
    public IndentManager() {
        currentIndent = 0;
    }

    /**
     * Decreases current indent on default indent value.
     */
    public void decreaseIndent() {
        currentIndent -= defaultIndent;
    }

    /**
     * Increases current indent on default indent value.
     */
    public void increaseIndent() {
        currentIndent += defaultIndent;
    }

    /**
     * Returns current indent value.
     *
     * @return current indent value.
     */
    public int getCurrentIndent() {
        return currentIndent;
    }
}
