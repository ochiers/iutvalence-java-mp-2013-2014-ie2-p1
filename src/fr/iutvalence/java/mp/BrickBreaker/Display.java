package fr.iutvalence.java.mp.BrickBreaker;

// TODO (fixed) finish writing comment (general description)
/**
 * Define the interfqce who is used to display the game.
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
    
    // TODO (fixed) finish writing comment (parameter)
    /**
     * Initialize the display
     * @param obj Must be initialized in some case
     */
    public void initializeDisplay(Object obj);
    
    /**
     * Display the victory of the game 
     */
    public void displayVictory();
    
    /**
     * Display the loss of the game 
     */
    public void displayLoss();
    
}
