package fr.iutvalence.java.mp.BrickBreaker;

/**
 * Main class, the program start here and use the other classes
 * 
 * @author ochiers
 * 
 */
public class RandomPlayerGuiDisplayBrickBreakerGameLauncher
{
    /**
     * Default game launcher 
     * 
     * @param args
     */
    public static void main(String[] args)
    {          
        // TODO (fix) this is a sequential execution
        new ThreadMovePaddleByMouse().run();
    }
}
