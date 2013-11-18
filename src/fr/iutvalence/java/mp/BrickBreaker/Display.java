package fr.iutvalence.java.mp.BrickBreaker;

// TODO (fix) finish writing comment (general description)
/**
 * 
 * @author ochiers
 *
 */
public interface Display
{
    
    /**
     * displays game state (bricks, ball, paddle)
     * @param bricks an array of bricks
     * @param thePaddle a paddle
     * @param theBall a ball
     */
    public void displayGameState(Brick[] bricks, Paddle thePaddle, Ball theBall);
    
    // TODO (fix) finish writing comment (parameter)
    /**
     * Initialize the display
     */
    public void initializeDisplay(Paddle pad);
}
