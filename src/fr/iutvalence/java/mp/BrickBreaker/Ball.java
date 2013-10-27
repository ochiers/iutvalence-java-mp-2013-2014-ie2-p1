package fr.iutvalence.java.mp.BrickBreaker;

/**
 * This class defines the ball used to destroy bricks
 * 
 * @author ochiers soulierc
 **/
public class Ball
{

    /**
     * Ratio of the size of a ball
     */
    public final static int DEFAULT_SIZE = 16;

    // TODO (think about it) consider gathering the 4 positions in a single
    // object called BoundingBox
    /**
     * It is the top left corner position of the ball
     */
    private Position topLeftCornerPosition;
    /**
     * It is the Bottom left corner position of the ball
     */
    private Position bottomLeftCornerPosition;
    /**
     * It is the top right corner position of the ball
     */
    private Position topRightCornerPosition;
    /**
     * It is the bottom right corner position of the ball
     */
    private Position bottomRightCornerPosition;

    // TODO (think about it) consider gathering a and b in a single object
    /**
     * The ball's trajectory
     */
    private Trajectory trajectory;

    // TODO (think about it) this field seems redundant with the previous four
    // position fields
    private CollisionBox collisionBox;

    // TODO (fix) finish writing comment (parameters)
    /**
     * Creates a new ball at new position (x,y) and set fields a and b to 1
     * 
     * @param x
     * @param y
     */
    public Ball(float x, float y)
    {
        super();
        this.topLeftCornerPosition = new Position(x, y);
        this.bottomLeftCornerPosition = new Position(x, y + DEFAULT_SIZE);
        this.topRightCornerPosition = new Position(x + DEFAULT_SIZE, y);
        this.bottomRightCornerPosition = new Position(x + DEFAULT_SIZE, y + DEFAULT_SIZE);
        this.trajectory = new Trajectory(1, 1);
        this.collisionBox = new CollisionBox(this.topLeftCornerPosition, DEFAULT_SIZE, DEFAULT_SIZE);

    }

    // TODO (fix) write comment
    public CollisionBox getCollisionBox()
    {
        return this.collisionBox;
    }

    /**
     * Return the ball's top left corner position
     * 
     * @return position
     */
    public Position getTopLeftCornerPosition()
    {
        return this.topLeftCornerPosition;
    }

    /**
     * Return the ball's bottom left corner position
     * 
     * @return position
     */
    public Position getBottomLeftCornerPosition()
    {
        return this.bottomLeftCornerPosition;
    }

    /**
     * Return the ball's top right corner position
     * 
     * @return position
     */
    public Position getTopRightCornerPosition()
    {
        return this.topRightCornerPosition;
    }

    /**
     * Return the ball's bottom right corner position
     * 
     * @return position
     */
    public Position getBottomRightCornerPosition()
    {
        return this.bottomRightCornerPosition;
    }

    // TODO (fix) finish writing comment
    /**
     * Set the four corner's position according to x,d and the bal size
     * 
     * @param newTopLeftCornerposition 
     * 
     */
    public void updatePositions(Position newTopLeftCornerposition)
    {
        this.topLeftCornerPosition = newTopLeftCornerposition;
        this.bottomLeftCornerPosition = newTopLeftCornerposition.translate(0, DEFAULT_SIZE);
        this.topRightCornerPosition = newTopLeftCornerposition.translate(DEFAULT_SIZE, 0);
        this.bottomRightCornerPosition = newTopLeftCornerposition.translate(DEFAULT_SIZE, DEFAULT_SIZE);
        this.collisionBox = new CollisionBox(this.topLeftCornerPosition, DEFAULT_SIZE, DEFAULT_SIZE);
    }

    // TODO (fix) rewrite comment
    /**
     * Return a
     * 
     * @return a
     */
    public Trajectory getTrajectory()
    {
        return this.trajectory;
    }

    // TODO (fix) rewrite comment
    /**
     * Set a field
     * 
     * @param a
     */
    public void setTrajectory(Trajectory a)
    {
        this.trajectory = a;
    }

    // TODO (fix) finish writing comment
    /**
     * Returns a description of the ball as an ASCII string whose format is ...
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        return "{" + this.topLeftCornerPosition.toString() + ", " + this.trajectory.toString() + "}";
    }
}
