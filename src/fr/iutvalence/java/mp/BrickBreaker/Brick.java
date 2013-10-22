package fr.iutvalence.java.mp.BrickBreaker;

/**
 * 
 * Define what is a brick That fix the position of a brick, and this state
 * 
 * @author ochiers soulierc
 * 
 */
public class Brick
{
    /**
     * Width size of the brick (in pixels)
     */
    public final static int DEFAULT_WIDTH = 50;

    /**
     * Height size of the brick (in pixels)
     */
    public final static int DEFAULT_HEIGHT = 44;

    /**
     * That is the normal state of a brick
     */
    private static final int NORMAL_STATE = 3;

    /**
     * That is the second state of a brick That is when the brick was hit
     */
    public static final int TOUCHED_STATE = 2;

    /**
     * That is the third state of a brick That is when the brick was hit
     */
    public static final int DAMAGED_STATE = 1;

    /**
     * That is the laster state of a brick That is when the brick was hit for
     * the last time And then, it is delete of the screen
     */
    public static final int DESTROYED_STATE = 0;

    /**
     * Position of the top left corner (in pixels)
     */
    private Position topLeftCornerPosition;

    /**
     * State of the brick (normal, a bit broken, really broken, destroyed)
     */
    private int state;

    // TODO (fix) finish writing comment
    /**
     * This is the initialization of a brick, a new position is created
     * according to posX and posY
     * 
     * @param posX
     * @param posY
     */
    // TODO (fix) replace x and y by a position
    public Brick(int posX, int posY)
    {
        super();
        this.topLeftCornerPosition = new Position(posX, posY);
        this.state = Brick.NORMAL_STATE;
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        return "{x : " + this.topLeftCornerPosition.getPosX() + ", y : " + this.topLeftCornerPosition.getPosY()
                + ", state :" + this.state + "}";
    }

    /**
     * Return the position of the brick
     * 
     * @return the position of the brick
     */
    public Position getBrickPosition()
    {
        return this.topLeftCornerPosition;
    }

    // TODO (fix) finish writing comment
    /**
     * Return the state of the brick
     * 
     * @return state
     */
    public int getState()
    {
        return this.state;
    }

    // TODO (fix) finish writing comment
    /**
     * Set the current state of the brick
     * 
     * @param state
     */
    public void setState(int state)
    {
        this.state = state;
    }

}
