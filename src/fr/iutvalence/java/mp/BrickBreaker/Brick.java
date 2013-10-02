package fr.iutvalence.java.mp.BrickBreaker;

// TODO (fix) write a "real" comment
/**
 * 
 * Define what is a brick
 * 
 * @author ochiers soulierc
 *
 */
public class Brick
{
    // TODO (fixed) this intends to be a constant but it is not
    /**
     * Width size of the brick (in pixels)
     */
    public final static int WIDTH_BRICK = 50;

    // TODO (fix) this intends to be a constant but it is not
    /**
     * Height size of the brick (in pixels)
     */
    public final static int HEIGHT_BRICK = 44;
    
    // TODO (fix) move this couple of int in a class named Position
    /**
     * Horizontal Position of the top left corner (in pixels)
     */
    private int posX;
    
    /**
     * Vertical Position of the top left corner (in pixels)
     */
    private int posY;
    
    // TODO (fix) declare constants for brick states
    /**
     * State of the brick (normal, a bit broken, really broken, destroyed)
     */
    private int state;
    
    // TODO (fix) write a "real" comment (how is the resulting brick)
    /**
     * This is a constructor of a brick
     */
    public Brick(int posX, int posY)
    {
        super();
        this.posX = posX;
        this.posY = posY;
        this.state = 0;
    }
    
    /**
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        return"{x : " + this.posX +", y : " + this.posY + ", state :"+ this.state +"}";
    }

    // TODO (fix) write comment
    public int getPosX()
    {
        return posX;
    }

    // TODO (fix) write comment
    public void setPosX(int posX)
    {
        this.posX = posX;
    }

    // TODO (fix) write comment
    public int getPosY()
    {
        return posY;
    }

    // TODO (fix) write comment
    public void setPosY(int posY)
    {
        this.posY = posY;
    }

    // TODO (fix) write comment
    public int getState()
    {
        return state;
    }

    // TODO (fix) write comment
    public void setState(int state)
    {
        this.state = state;
    }
    

}
