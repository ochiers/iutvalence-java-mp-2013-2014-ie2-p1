package fr.iutvalence.java.mp.BrickBreaker;

// TODO (fixed) write comment
/**
 * Define the error fired when we try to add a new player but he already exists
 * @author soulierc
 *
 */
public class PlayerAlreadyExistsException extends Exception
{
    // TODO (fixed) write comment
    /**
     * Print an error message in the console by the err stream
     */
    public PlayerAlreadyExistsException()
    {
        System.err.println("Le joueur est déjà éxistant.");
    }
}
