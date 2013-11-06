package fr.iutvalence.java.mp.BrickBreaker;

import java.awt.geom.Rectangle2D;

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
     * The ball's trajectory
     */
    private Trajectory trajectory;

    /**
     * The collision box associated with this Ball
     * It's used to determinate collisions
     */
    private CollisionBox ballBox;
    
    // TODO (fixed) finish writing comment (parameters)
    /**
     * Creates a new ball at new position and set a new trajectory
     * 
     * @param pos The initial position of the ball
     */
    public Ball(Position pos)
    {
        this.trajectory = new Trajectory(1, 1);
        this.ballBox = new CollisionBox(pos, Ball.DEFAULT_SIZE, Ball.DEFAULT_SIZE);
    }
    
    /**
     * Return the CollisionBox associated with this ball
     * @return The ball's CollisionBox
     */
    public CollisionBox getBallBox()
    {
        return this.ballBox;
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
        this.ballBox.updateBox(new Rectangle2D.Float(newTopLeftCornerposition.getX(),newTopLeftCornerposition.getY(),Ball.DEFAULT_SIZE,Ball.DEFAULT_SIZE));
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
        Position temp = new Position((float)this.ballBox.getBox().getX(),(float)this.ballBox.getBox().getY());
        return "{" + temp.toString() + ", " + this.trajectory.toString() + "}";
    }

    /**
     * Give a string who represent the ball in the game
     * @return A string representing the ball in the game
     */
    public String stringBallInConsole()
    {
        String res = " # ";
        for (int i = 0; i < Game.DEFAULT_MAP_WIDTH; i += Game.DEFAULT_MAP_WIDTH / (2 * Ball.DEFAULT_SIZE))
        {

            if (Tools.isFloatBetween((float)this.ballBox.getBox().getX(), i, (i + Game.DEFAULT_MAP_HEIGHT
                    / (2 * Ball.DEFAULT_SIZE))))
            {
                res = res + " B ";
            }
            else
                res = res + "   ";
        }
        return res;
    }


}
