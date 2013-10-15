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
        
    // TODO (fix) declare constant as a constant
    /**
     * That is the normal state of a brick
     */
    private final int NORMAL_STATE = 3;
    
    // TODO (fix) declare constant as a constant
    /**
     * That is the second state of a brick
     * That is when the brick was hit 
     */
    private final int TOUCHED_STATE = 2;
    
    // TODO (fix) declare constant as a constant
    /**
     * That is the third state of a brick
     * That is when the brick was hit 
     */
    private final int DAMAGED_STATE = 1;
    
    // TODO (fix) declare constant as a constant
    /**
     * That is the laster state of a brick
     * That is when the brick was hit for the last time
     * And then, it is delete of the screen
     */
    private final int DESTROYED_STATE = 0;
    
    /**
     * Position of the top left corner (in pixels)
     */
    private Position position;
    
    /**
     * State of the brick (normal, a bit broken, really broken, destroyed)
     */
    private int state;
    
    // TODO (fix) fix comment (no one ask something)
    // TODO (fix) finish writing comment
    /**
     * This is the initialization of a brick who ask the position of the brick
     */
    public Brick(int posX, int posY)
    {
        super();
        this.position = new Position(posX,posY);
        this.state = this.NORMAL_STATE;
    }
    
    /**
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        return"{x : " + this.position.getPosX() +", y : " + this.position.getPosY() + ", state :"+ this.state +"}";
    }

    // TODO (fix) finish writing comment
    /**
     * 
     * @return the position of the brick
     */
    public Position getBrickPosition()
    {
        return this.position;
    }

    // TODO (fix) finish writing comment
    /**
     * @return the state of the brick
     */
    public int getState()
    {
        return this.state;
    }

    // TODO (fix) finish writing comment
    /**
     * set the current state of the brick
     * @param state 
     */
    public void setState(int state)
    {
        this.state = state;
    }
    

}
