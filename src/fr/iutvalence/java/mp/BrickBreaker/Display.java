package fr.iutvalence.java.mp.BrickBreaker;
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
    
    /**
     * Initialize the display
     */
    public void initializeDisplay(Paddle pad);
}
