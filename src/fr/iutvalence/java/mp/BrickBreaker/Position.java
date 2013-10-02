package fr.iutvalence.java.mp.BrickBreaker;

public class Position
{

    /**
     * Position on horizontal axis
     */
    private static int posX;
    
    /**
     * Position on vertical axis
     */
    private static int posY;
    
    Position(int x, int y)
    {
        this.posX = x;
        this.posY = y;
    }

    
    /**
     * @return x position
     */
    public static int getPosX()
    {
        return posX;
    }

    /**
     * @return y position
     */
    public static int getPosY()
    {
        return posY;
    }
    
    
    
    
}
