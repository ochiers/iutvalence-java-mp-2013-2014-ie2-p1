package fr.iutvalence.java.mp.BrickBreaker;

import java.awt.geom.Rectangle2D;

/**
 * This class defines the ball used to destroy bricks
 * 
 * @author ochiers soulierc
 **/
public class Ball extends CollisionBox
{

    /**
     * Ratio of the size of a ball
     */
    public final static int DEFAULT_SIZE = 16;

    /**
     * The ball's trajectory
     */
    private Trajectory trajectory;

    // TODO (fixed) finish writing comment (parameters)
    /**
     * Creates a new ball at new position and set a new trajectory
     * 
     * @param pos The initial position of the ball
     */
    public Ball(Position pos)
    {
        super(pos,DEFAULT_SIZE, DEFAULT_SIZE);
        this.trajectory = new Trajectory(1, 1);
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
        this.setBox(new Rectangle2D.Float(newTopLeftCornerposition.getX(),newTopLeftCornerposition.getY(),Ball.DEFAULT_SIZE,Ball.DEFAULT_SIZE));
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
        Position temp = new Position((float)this.getBox().getX(),(float)this.getBox().getY());
        return "{" + temp.toString() + ", " + this.trajectory.toString() + "}";
    }

    public String stringBallInConsole()
    {
        String res = "#";
        for (int i = 0; i < Game.DEFAULT_MAP_WIDTH; i += Game.DEFAULT_MAP_WIDTH / (2 * Ball.DEFAULT_SIZE))
        {

            if (isFloatBetween((float)this.getBox().getY(), i, (i + Game.DEFAULT_MAP_HEIGHT
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
