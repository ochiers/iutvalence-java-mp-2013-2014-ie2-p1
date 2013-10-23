package fr.iutvalence.java.mp.BrickBreaker;

/**
 * This class defines the ball used to destroy bricks
 * 
 * @author ochiers soulierc
 **/
public class Ball
{

    /**
     * Size of a ball
     */
    public final static int BALL_SIZE = 10;

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

    /**
     * Creates a new ball at new position (x,y) and set fields a and b to 1
     */
    public Ball(float x, float y)
    {
        super();
        this.topLeftCornerPosition = new Position(x, y);
        this.bottomLeftCornerPosition = new Position(x, y + Ball.BALL_SIZE);
        this.topRightCornerPosition = new Position(x + Ball.BALL_SIZE, y);
        this.bottomRightCornerPosition = new Position(x + Ball.BALL_SIZE, y + Ball.BALL_SIZE);
        this.trajectory = new Trajectory(1,1);
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

    /**
     * Set the four corner's position according to x,d and the baal size
     * 
     * @param x
     * @param y
     */
    // TODO (fix) consider having a single position as parameter
    public void setPositionsFromTopLeftCorner(float x, float y)
    {
        this.topLeftCornerPosition  = new Position(x, y);
        this.bottomLeftCornerPosition = new Position(x, y + Ball.BALL_SIZE);
        this.topRightCornerPosition = new Position(x + Ball.BALL_SIZE, y);
        this.bottomRightCornerPosition = new Position(x + Ball.BALL_SIZE, y + Ball.BALL_SIZE);
    }

    /**
     * Return a
     * 
     * @return a
     */
    public Trajectory getTrajectory()
    {
        return this.trajectory;
    }

    /**
     * Set a field
     * 
     * @param a
     */
    public void setTrajectory(Trajectory a)
    {
        this.trajectory = a;
    }


    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        return "{" + this.topLeftCornerPosition.toString() + ", " + this.trajectory.toString() + "}";
    }
}
