package fr.iutvalence.java.mp.BrickBreaker;

public class Position
{
 
    /**
     * Position on horizontal axis
     */
    private float posX;
    
    /**
     * Position on vertical axis
     */
    private float posY;

    
    Position(float x, float y)
    {
        this.posX = x;
        this.posY = y;
    }

    
    /**
     * @return x position
     */
    public float getPosX()
    {
        return posX;
    }

    /**
     * @return y position
     */
    public float getPosY()
    {
        return posY;
    }
    
    
    
    
}
