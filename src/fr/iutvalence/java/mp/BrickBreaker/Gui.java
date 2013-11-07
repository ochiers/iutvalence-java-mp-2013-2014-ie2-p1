package fr.iutvalence.java.mp.BrickBreaker;
/**
 * 
 * @author ochiers
 *
 */
public interface Gui
{
    
    /**
     * The method create an ASCII-art representation of the game
     * @param bricks The tab of brick who need to be displayed
     * @param thePaddle The paddle who need to be displayed
     * @param theBall The ball who need to be displayed
     */
    public void displayConsoleScreen(Brick[] bricks, Paddle thePaddle, Ball theBall);
}
