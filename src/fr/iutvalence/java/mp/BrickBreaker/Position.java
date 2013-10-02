package fr.iutvalence.java.mp.BrickBreaker;

public class Position
{

    /**
     * Position on horizontal axis
     */
    private int posX;
    
    /**
     * Position on vertical axis
     */
    private int posY;

    
    Position(int x, int y)
    {
        this.posX = x;
        this.posY = y;
    }

    
    /**
     * @return x position
     */
    public int getPosX()
    {
        return posX;
    }

    /**
     * @return y position
     */
    public int getPosY()
    {
        return posY;
    }
    
    
    
    
}
