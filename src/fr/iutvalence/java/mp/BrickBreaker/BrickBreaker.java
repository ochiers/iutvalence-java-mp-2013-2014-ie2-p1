package fr.iutvalence.java.mp.BrickBreaker;


/**
 * Main class, the program start here and use the other classes
 * 
 * @author ochiers
 * 
 */

public class BrickBreaker
{
    
    private static int brickBreakerWidthSize = 800;
    private static int brickBreakerHeightSize = 640;
    
    
    /**
     * The program start here
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        // tests

        Game newGame = new Game();
        newGame.go();
    }
    
    public static int getBrickBreakerWidthSize() 
    {
        return brickBreakerWidthSize;
    }

    public static void setBrickBreakerWidthSize(int brickBreakerWithSize)
    {
        BrickBreaker.brickBreakerWidthSize = brickBreakerWithSize;
    }

    public static int getBrickBreakerHeightSize() 
    {
        return brickBreakerHeightSize;
    }

    public static void setBrickBreakerHeightSize(int brickBreakerHeightSize) 
    {
        BrickBreaker.brickBreakerHeightSize = brickBreakerHeightSize;
    }
    
}
