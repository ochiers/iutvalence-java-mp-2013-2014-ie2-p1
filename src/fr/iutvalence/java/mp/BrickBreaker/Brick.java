package fr.iutvalence.java.mp.BrickBreaker;
 
/**
 * 
 * Define what is a brick That fix the position of a brick, and this state
 * 
 * @author ochiers soulierc
 * 
 */
public class Brick extends GameComponent
{
    /**
     * Width size of the brick
     */
    public static int DEFAULT_WIDTH = 28;

    /**
     * Height size of the brick
     */
    public static int DEFAULT_HEIGHT = 16;

    /**
     * State of the brick (normal, a bit broken, really broken, destroyed)
     */
    private BrickState state;

    /**
     * Creates a new Brick, at a given position
     * 
     * @param position The position of the top left corner of the brick
     * @param state The initial state of a brick
     */
    public Brick(Position position, BrickState state)
    {
        super(position,DEFAULT_WIDTH, DEFAULT_HEIGHT);
        this.state = state;
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
    private void setState(BrickState state)
    {
        this.state = state;
    }
    
    /**
     * Manage the brick's state after a collision has occured
     */
    public void manageBrickStateAfterCollision()
    {
        switch (this.state)
        {
        case DAMAGED_STATE: setState(BrickState.DESTROYED_STATE);
            break;
        case NORMAL_STATE: setState(BrickState.TOUCHED_STATE);
            break;
        case TOUCHED_STATE: setState(BrickState.DAMAGED_STATE);
            break;
        default:
            break;
        
        }
    }
}
