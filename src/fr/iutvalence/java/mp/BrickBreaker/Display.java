package fr.iutvalence.java.mp.BrickBreaker;

/**
 * Define the interfqce that is used to display the game.
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
     * Display the victory of the game 
     */
    public void displayVictory();
    
    /**
     * Display the loss of the game 
     */
    public void displayLoss();
    
}
