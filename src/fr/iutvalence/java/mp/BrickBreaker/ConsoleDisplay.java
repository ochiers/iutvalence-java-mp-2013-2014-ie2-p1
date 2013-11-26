package fr.iutvalence.java.mp.BrickBreaker;
 
/**
 * This class is used to display the game in console mod,
 * the display is a ASCII-ART representation of the game.
 * 
 * @author ochiers
 *
 */
public class ConsoleDisplay implements Display
{
   
    /**
     * Game state is displayed using an ASCII-art representation
     * @see fr.iutvalence.java.mp.BrickBreaker.Display#displayGameState(fr.iutvalence.java.mp.BrickBreaker.Brick[], fr.iutvalence.java.mp.BrickBreaker.Paddle, fr.iutvalence.java.mp.BrickBreaker.Ball)
     */
    public void displayGameState(Brick[] bricks, Paddle thePaddle, Ball theBall)
    {
            System.out.print(" # ");
            for (int i = 0; i < Game.DEFAULT_MAP_WIDTH; i += Game.DEFAULT_MAP_WIDTH / (2 * Ball.DEFAULT_SIZE))
            {
                System.out.print(" # ");
            }
            System.out.println();
            for (int j = 0; j < Game.DEFAULT_MAP_HEIGHT; j += Game.DEFAULT_MAP_HEIGHT / (2 * Ball.DEFAULT_SIZE))
            {
                System.out.println(buildLineForConsoleDisplay(bricks, thePaddle, theBall, j, Game.DEFAULT_MAP_HEIGHT / (2 * Ball.DEFAULT_SIZE)));
            }
        
    }
    
    public void displayVictory()
    {
        System.out.println("Not bad, you win !");
    }
    
    public void displayLoss()
    {
        System.out.println("You loose, you sucks.");
    }
    
    /**
     * Method who build a line of the game, in order to be printed in console
     * 
     * @param bricks The tab of brick who need to be displayed
     * @param thePaddle The paddle who need to be displayed
     * @param theBall The ball who need to be displayed
     * @param pos The part of the game who is represented by this string
     * @param increment The part of the game who is represented by this string
     * @return A string who represent the state of a part of the game
     */
    private String buildLineForConsoleDisplay(Brick[] bricks, Paddle thePaddle, Ball theBall, int pos, int increment)
    {
        String res = " # ";
        boolean aBrickIsWritten = false;
        int count = 0;
        for (int k = 0; k < Game.DEFAULT_MAP_WIDTH; k += Game.DEFAULT_MAP_WIDTH / (2 * Ball.DEFAULT_SIZE))
        {
            if (count < Game.DEFAULT_NUMBER_OF_BRICKS)
            {
                if (Tools.isFloatBetween((float)bricks[count].getCollisionBox().getBox().getY(), pos, pos + increment)
                        || Tools.isFloatBetween((float)bricks[count].getCollisionBox().getBox().getY() + Brick.DEFAULT_WIDTH,
                                pos, pos + increment))
                {
                    aBrickIsWritten = true;
                    if (bricks[count].getState() != BrickState.DESTROYED_STATE)
                        res += " N ";
                    else
                        res += " X ";
                }
                else
                {
                    res += "   ";
                }
                count++;
            }
            else
            {
                res += "   ";
            }

        }
        if (!aBrickIsWritten && Tools.isFloatBetween((float)theBall.getCollisionBox().getBox().getY(), pos, pos + increment))
        {
            res = stringBallInConsole(theBall);
        }

        if (Tools.isFloatBetween((float)thePaddle.getCollisionBox().getBox().getY(), pos, pos + increment))
        {
            res = stringPaddleInConsole(thePaddle);
        }

        return res;
    }
    
    /**
     * Give a string who represent the ball in the game
     * @return A string representing the ball in the game
     */
    private String stringBallInConsole(Ball b)
    {
        String res = " # ";
        for (int i = 0; i < Game.DEFAULT_MAP_WIDTH; i += Game.DEFAULT_MAP_WIDTH / (2 * Ball.DEFAULT_SIZE))
        {

            if (Tools.isFloatBetween((float)b.getCollisionBox().getBox().getX(), i, (i + Game.DEFAULT_MAP_HEIGHT
                    / (2 * Ball.DEFAULT_SIZE))))
            {
                res = res + " B ";
            }
            else
                res = res + "   ";
        }
        return res;
    }

    /**
     * Give a string who represent the paddle in the game
     * @return A string representing the paddle in the game
     */
    private String stringPaddleInConsole(Paddle p)
    {
        String res = " # ";
        for (int i = 0; i < Game.DEFAULT_MAP_WIDTH; i += Game.DEFAULT_MAP_WIDTH / (2 * Ball.DEFAULT_SIZE))
        {

            if (p.getCollisionBox().getBox().getX() + p.getWidth() >= i)
            {
                res = res + " P ";
            }
            else
                res = res + "   ";
        }
        return res;
    }
    
    
    
}
