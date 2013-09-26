package fr.iutvalence.java.mp.BrickBreaker;

/**
 * This class define what is a plate
 * @author ochiers soulierc
 *
 */
public class Plate
{
    /**
     * Horizontal Position of the top left corner (in pixels)
     */
    private int posX;
    
    /**
     * Vertical Position of the top left corner (in pixels)
     */
    private static final int posY = 396;
    
    /**
     *  Width size of the plate (in pixels)
     */
    private int size;
    
    
    public Plate(int posX, int size)
    {
        super();
        this.posX = posX;
        this.size = size;
    }
    
    public Plate()
    {
        super();
        this.posX = 0;
        this.size = 30;
    }
    
    
    
    public int getPosX()
    {
        return posX;
    }
    public void setPosX(int posX)
    {
        this.posX = posX;
    }
    public int getPosY()
    {
        return posY;
    }

    public int getSize()
    {
        return size;
    }
    public void setSize(int size)
    {
        this.size = size;
    }
    
}
