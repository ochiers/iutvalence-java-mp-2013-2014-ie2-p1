package fr.iutvalence.java.mp.BrickBreaker;
 
import java.awt.geom.Rectangle2D;

/**
 * This class defines the ball used to destroy bricks
 * 
 * @author ochiers soulierc
 **/
public class Ball extends GameComponents
{

    /**
     * Ratio of the size of a ball
     */
    public final static int DEFAULT_SIZE = 16;

    /**
     * The ball's trajectory
     */
    private Trajectory trajectory;
    
    /**
     * Creates a new ball at new position and set a new trajectory
     * 
     * @param pos The initial position of the ball
     * @param traj The initial trajectory of the ball
     */
    public Ball(Position pos, Trajectory traj)
    {
        super(pos, Ball.DEFAULT_SIZE, Ball.DEFAULT_SIZE);
        this.trajectory = traj;
    }
    
    /**
     * Return the CollisionBox associated with this ball
     * @return The ball's CollisionBox
     */
    public CollisionBox getCollisionBox()
    {
        return this.collisionBox;
    }
    
    
    // TODO (fix) finish writing comment
    /**
     * Update the ball's position and set a new CollisionBox according to the
     * new position
     * 
     * @param newTopLeftCornerPosition
     *            The new position of the ball
     * 
     */
    public void updatePosition(Position newTopLeftCornerPosition)
    {
        this.collisionBox.updateBox(new Rectangle2D.Float(newTopLeftCornerPosition.getX(),newTopLeftCornerPosition.getY(),Ball.DEFAULT_SIZE,Ball.DEFAULT_SIZE));
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
        Position temp = new Position((float)this.collisionBox.getBox().getX(),(float)this.collisionBox.getBox().getY());
        return "{" + temp.toString() + ", " + this.trajectory.toString() + "}";
    }

    


}
