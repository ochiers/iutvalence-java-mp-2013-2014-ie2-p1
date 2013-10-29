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

    // TODO (fixed) declare these constants in an external enumeration called BrickState
    

    /**
     * Position of the top left corner (in pixels)
     */
    private Position topLeftCornerPosition;

  
    /**
     * State of the brick (normal, a bit broken, really broken, destroyed)
     */
    private BrickState state;
    
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
        this.state = BrickState.NORMAL_STATE;
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
    public BrickState getState()
    {
        return this.state;
    }

    // TODO (fixed) finish writing comment
    /**
     * Change the current state of the brick
     * 
     * @param state The new state of the brick
     */
    public void setState(BrickState state)
    {
        this.state = state;
    }
}
