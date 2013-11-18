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

    /**
     * State of the brick (normal, a bit broken, really broken, destroyed)
     */
    private BrickState state;

    /**
     * The collision box associated with this brick
     * It's used to determinate collisions
     */
    private CollisionBox collisionBox;

    /**
     * Creates a new Brick, at a given position
     * 
     * @param position The position of the top left corner of the brick
     */
    public Brick(Position position)
    {
        this.collisionBox = new CollisionBox(position,DEFAULT_WIDTH, DEFAULT_HEIGHT);
        this.state = BrickState.NORMAL_STATE;
    }
    
    /**
     * Return the CollisionBox associated with this brick
     * @return The brick's CollisionBox
     */
    // TODO (think about it) it is better the same names for similar methods across
    // objects that share some behaviour. Ball, Brick and Paddle share the fact
    // that they have a collision box. so, there is no reason not to name the field
   // collisionBox and the getter getCollisionBox. You should also think about having 
    // common superclass.
    public CollisionBox getCollisionBox()
    {
        return this.collisionBox;
    }

    /**
     * Returns a description of the brick as an ASCII string whose format is "{Position : Brick's position,
     *  state : Brick's state"}"
     * 
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        Position pos = new Position((float)this.getCollisionBox().getBox().getX(),(float)this.getCollisionBox().getBox().getY());
        return "{Position : " + pos.toString() + ", state :"
                + this.state + "}";
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

    /**
     * Change the current state of the brick
     * 
     * @param state
     *            The new state of the brick
     */
    public void setState(BrickState state)
    {
        this.state = state;
    }
}
