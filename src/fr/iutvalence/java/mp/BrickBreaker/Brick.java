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
     * Width size of the brick 
     */
    public static int DEFAULT_WIDTH = 24;

    /**
     * Height size of the brick 
     */
    public static int DEFAULT_HEIGHT = 12;

    // TODO (fix) declare these constants in an external enumeration called BrickState
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
    
    // TODO (fix) write comment
    // TODO (think about it) seems redudant with position field
    private CollisionBox collisionBox;

    // TODO (fix) finish writing comment (parameters
    /**
     * Creates a new Brick, at a given position
     * 
     * @param topLeftCornerposition 
     */
    // TODO (fix) replace x and y by a position
    public Brick(Position topLeftCornerposition)
    {
        super();
        this.topLeftCornerPosition = topLeftCornerposition;
        this.state = Brick.NORMAL_STATE;
        this.collisionBox = new CollisionBox(this.topLeftCornerPosition, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    // TODO (fix) write comment
    // TODO (think about it) maybe you should take into account the fact that several objects share 
    // the concept of having a collision box
    public CollisionBox getCollisionBox()
    {
        return this.collisionBox;
    }

    // TODO (fix) finish writing comment
    /**
     * Returns a description of the brick as an ASCII string whose format is ...
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        return "{x : " + this.topLeftCornerPosition.getX() + ", y : " + this.topLeftCornerPosition.getY()
                + ", state :" + this.state + "}";
    }

    // TODO (fix) detail comment
    /**
     * Return the position of the brick
     * 
     * @return the position of the brick
     */
    public Position getTopLeftCornerPosition()
    {
        return this.topLeftCornerPosition;
    }

    /**
     * Return the current state of the brick
     * 
     * @return the current state of the brick
     */
    public int getState()
    {
        return this.state;
    }

    // TODO (fix) finish writing comment
    /**
     * Set the current state of the brick
     * 
     * @param state the state of the brick
     */
    public void setState(int state)
    {
        this.state = state;
    }

    
    // TODO (fix) move this method where it should be
    // if it applies to no particular object, consider declaring a utility class and make this method become static
    /**
     * Function who say if the number toCompare is between the number a and the
     * number b
     * 
     * @param toCompare
     *            Number to compare
     * @param a
     *            Bound of comparison
     * @param b
     *            Bound of comparison
     * @return true if the number is in, false otherwise
     */
    private boolean isFloatBetween(float toCompare, float a, float b)
    {
        return (toCompare >= a && toCompare <= b) || (toCompare >= b && toCompare <= a);
    }

}
