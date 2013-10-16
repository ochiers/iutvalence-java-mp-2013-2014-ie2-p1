package fr.iutvalence.java.mp.BrickBreaker;

/**
 * 
 * Define what is a brick
 * That fix the position of a brick,
 * and this state
 * @author ochiers soulierc
 * 
 */
public class Brick
{
    /**
     * Width size of the brick (in pixels)
     */
    public final static int DEFAULT_WIDTH = 50;

    // TODO (fixed) this intends to be a constant but it is not
    /**
     * Height size of the brick (in pixels)
     */
    public final static int DEFAULT_HEIGHT = 44;
        
    // TODO (fixed) declare constant as a constant
    /**
     * That is the normal state of a brick
     */
    private static final int NORMAL_STATE = 3;
    
    // TODO (fixed) declare constant as a constant
    /**
     * That is the second state of a brick
     * That is when the brick was hit 
     */
    private static final int TOUCHED_STATE = 2;
    
    // TODO (fixed) declare constant as a constant
    /**
     * That is the third state of a brick
     * That is when the brick was hit 
     */
    private static final int DAMAGED_STATE = 1;
    
    // TODO (fixed) declare constant as a constant
    /**
     * That is the laster state of a brick
     * That is when the brick was hit for the last time
     * And then, it is delete of the screen
     */
    private static final int DESTROYED_STATE = 0;
    
    /**
     * Position of the top left corner (in pixels)
     */
    private Position position;
    
    /**
     * State of the brick (normal, a bit broken, really broken, destroyed)
     */
    private int state;
    
    // TODO (fixed) fix comment (no one ask something)
    // TODO (fixed) finish writing comment

    /**
     * This is the initialization of a brick, a new position is created according to posX and posY
     * @param posX
     * @param posY
     */
    public Brick(int posX, int posY)
    {
        super();
        this.position = new Position(posX,posY);
        this.state = Brick.NORMAL_STATE;
    }
    
    /**
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        return"{x : " + this.position.getPosX() +", y : " + this.position.getPosY() + ", state :"+ this.state +"}";
    }

    // TODO (fixed) finish writing comment
    /**
     * Return the position of the brick
     * @return position
     */
    public Position getBrickPosition()
    {
        return this.position;
    }

    // TODO (fixed) finish writing comment
    /**
     * Return the state of the brick
     * @return state
     */
    public int getState()
    {
        return this.state;
    }

    // TODO (fixed) finish writing comment
    /**
     * Set the current state of the brick
     * @param state 
     */
    public void setState(int state)
    {
        this.state = state;
    }
    

}
