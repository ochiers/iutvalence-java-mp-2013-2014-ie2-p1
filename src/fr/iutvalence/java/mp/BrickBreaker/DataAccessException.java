package fr.iutvalence.java.mp.BrickBreaker;

// TODO (fixed) write comment
/**
 * Define the error who is fired when we can't access to a file
 * @author soulierc
 *
 */
public class DataAccessException extends Exception
{
    // TODO (fixed) write comment
    /**
     * Print an error message in the err stream
     */
    public DataAccessException()
    {
        System.err.println("On ne peut pas accéder au fichier des joueurs.");     
    }

}
