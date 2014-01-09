package fr.iutvalence.java.mp.BrickBreaker;

/**
 * @author ochiers
 *
 */
public class LevelAlreadyExistsException extends Exception
{
    /**
     * Print an error message in the console by the err stream
     */
    public LevelAlreadyExistsException()
    {
        System.out.println("Le niveau est déjà éxistant.");
    }
}
