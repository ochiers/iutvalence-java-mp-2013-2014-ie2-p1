package fr.iutvalence.java.mp.BrickBreaker;

// TODO (think about it) for plate, you mean "board" ?
/**
 * This class define what is a plate
 * @author ochiers soulierc
 *
 */
public class Plate
{
    // TODO (fix) move this couple of int in a class named Position
    /**
     * Horizontal Position of the top left corner (in pixels)
     */
    private int posX;
    
    // TODO (fix) respect naming conventions
    /**
     * Vertical Position of the top left corner (in pixels)
     */
    private static final int posY = 396;
    
    /**
     *  Width size of the plate (in pixels)
     */
    private int size;
    
    // TODO (fix) write a comment
    public Plate(int posX, int size)
    {
        super();
        this.posX = posX;
        this.size = size;
    }

    // TODO (fix) write a comment
    public Plate()
    {
        super();
        this.posX = 0;
        // TODO (fix) declare hard-coded value as a constant
        this.size = 30;
    }
    
    // TODO (fix) write a comment
    public int getPosX()
    {
        return posX;
    }

    // TODO (fix) write a comment
    public void setPosX(int posX)
    {
        this.posX = posX;
    }
    
    // TODO (fix) write a comment
    public int getPosY()
    {
        return posY;
    }

    // TODO (fix) write a comment
    public int getSize()
    {
        return size;
    }
    
    // TODO (fix) write a comment
    public void setSize(int size)
    {
        this.size = size;
    }   
}
