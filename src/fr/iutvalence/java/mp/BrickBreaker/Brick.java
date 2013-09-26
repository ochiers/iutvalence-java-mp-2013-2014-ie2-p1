package fr.iutvalence.java.mp.BrickBreaker;

/**
 * 
 * Define what is a brick
 * 
 * @author ochiers soulierc
 *
 */
public class Brick
{
    /**
     * Width size of the brick (in pixels)
     */
    static final int widthBrick = 50;
    
    /**
     * Height size of the brick (in pixels)
     */
    static final int heightBrick = 44;
    
    /**
     * Horizontal Position of the top left corner (in pixels)
     */
    private int posX;
    
    /**
     * Vertical Position of the top left corner (in pixels)
     */
    private int posY;
    
    /**
     * State of the brick (normal, a bit broken, really broken, destroyed)
     */
    private int state;
    
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
    
    public String toString()
    {
        return"{x : " + this.posX +", y : " + this.posY + ", state :"+ this.state +"}";
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

    public void setPosY(int posY)
    {
        this.posY = posY;
    }

    public int getState()
    {
        return state;
    }

    public void setState(int state)
    {
        this.state = state;
    }
    

}
