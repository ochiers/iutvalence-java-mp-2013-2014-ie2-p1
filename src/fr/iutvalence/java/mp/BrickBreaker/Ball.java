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

    /**
     * It is the top left corner position of the ball
     */
    private Position topLeftCornerPosition;

    /**
     * The ball's trajectory
     */
    private Trajectory trajectory;

    // TODO (think about it) this field seems redundant with the topLeftCornerPosition field
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
        this.trajectory = new Trajectory(1, 1);
        this.collisionBox = new CollisionBox(this.topLeftCornerPosition, DEFAULT_SIZE, DEFAULT_SIZE);

    }

    /**
     * Return a CollisionBox associated with this ball
     * 
     * @return the CollisionBox associated with this ball
     */
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

    // TODO (fix) finish writing comment
    /**
     * Update the ball's position and set a new CollisionBox according to the
     * new position
     * 
     * @param newTopLeftCornerposition
     *            The new position of the ball
     * 
     */
    public void updatePositions(Position newTopLeftCornerposition)
    {
        this.topLeftCornerPosition = newTopLeftCornerposition;
        this.collisionBox = new CollisionBox(this.topLeftCornerPosition, DEFAULT_SIZE, DEFAULT_SIZE);
    }

    /**
     * Return the trajectory associated with this ball
     * 
     * @return trajectory
     */
    public Trajectory getTrajectory()
    {
        return this.trajectory;
    }

    /**
     * Set a new trajectory for the ball
     * 
     * @param trajectory
     *            The new trajectory given for the ball
     */
    public void setTrajectory(Trajectory trajectory)
    {
        this.trajectory = trajectory;
    }

    /**
     * Returns a description of the ball as an ASCII string whose format is
     * "{  Ball's position ,Ball's trajectory }"
     * 
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        return "{" + this.topLeftCornerPosition.toString() + ", " + this.trajectory.toString() + "}";
    }

    public String stringBallInConsole()
    {
        String res = "#";
        for (int i = 0; i < Game.DEFAULT_MAP_WIDTH; i += Game.DEFAULT_MAP_WIDTH / (2 * Ball.DEFAULT_SIZE))
        {

            if (isFloatBetween(this.getTopLeftCornerPosition().getY(), i, (i + Game.DEFAULT_MAP_HEIGHT
                    / (2 * Ball.DEFAULT_SIZE))))
            {
                res = res + "B";
            }
            else
                res = res + " ";
        }
        return res;
    }

    private boolean isFloatBetween(float toCompare, float a, float b)
    {
        return (toCompare >= a && toCompare <= b) || (toCompare >= b && toCompare <= a);
    }

}
