package fr.iutvalence.java.mp.BrickBreaker;

import java.awt.geom.Rectangle2D;

/**
 * This class define what is a plate
 * 
 * @author ochiers soulierc
 * 
 */
public class Paddle
{
    /**
     * Paddle width
     */
    public final static int DEFAULT_WIDTH = 36;

    /**
     * Paddle height
     */
    public final static int DEFAULT_HEIGHT = 12;

    /**
     * The paddle is always at the same height
     */
    public static final Position DEFAULT_TOP_LEFT_CORNER_POSITION = new Position(50, 50);

    /**
     * Paddle width
     */
    private int width;

    /**
     * The collision box associated with this paddle
     * It's used to determinate collisions
     */
    private CollisionBox paddleBox;
    
    
    /**
     * Create a new paddle and the CollisionBox associated at a given position
     * and with the given width size
     * 
     * @param pos
     *            Paddle's initial position of the top left corner
     * @param width
     *            Paddle's width size
     */
    public Paddle(Position pos, int width)
    {
        this.paddleBox = new CollisionBox(pos,width,Paddle.DEFAULT_HEIGHT);
        this.width = width;
    }

    /**
     * creates a paddle initially at DEFAULT_TOP_LEFT_CORNER_POSITION and with
     * the default width size DEFAULT_WIDTH and the CollisionBox associated
     */
    public Paddle()
    {
        this.paddleBox = new CollisionBox(Paddle.DEFAULT_TOP_LEFT_CORNER_POSITION,Paddle.DEFAULT_WIDTH,Paddle.DEFAULT_HEIGHT);
        this.width = Paddle.DEFAULT_WIDTH;
    }

    /**
     * Return the CollisionBox associated with this paddle
     * @return The paddle's CollisionBox
     */
    public CollisionBox getPaddleBox()
    {
        return this.paddleBox;
    }
    
    /**
     * Return the paddle's size
     * 
     * @return give the size of paddle
     */
    public int getWidth()
    {
        return this.width;
    }

    /**
     * Set a new paddle width
     * 
     * @param width
     *            New width of the paddle
     */
    public void setWidth(int width)
    {
        this.width = width;
    }

    /**
     * Update the position of the paddle and his collisionBox
     * @param newPos   
     *              New position of the paddle
     */
    public void setTopLeftCornerPosition(Position newPos)
    {
        this.paddleBox.updateBox(new Rectangle2D.Float(newPos.getX(), newPos.getY(), this.width, Paddle.DEFAULT_HEIGHT));
    }

    /**
     * Returns a description of the paddle as an ASCII string whose format is
     * "{Paddle's position, size : Paddle's width}" 
     * 
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        Position pos = new Position((float)this.paddleBox.getBox().getX(),(float)this.paddleBox.getBox().getY());
        return "{" + pos.toString() + ", size : " + this.width + "}";
    }

    /**
     * Give a string who represent the paddle in the game
     * @return A string representing the paddle in the game
     */
    public String stringPaddleInConsole()
    {
        String res = " # ";
        for (int i = 0; i < Game.DEFAULT_MAP_WIDTH; i += Game.DEFAULT_MAP_WIDTH / (2 * Ball.DEFAULT_SIZE))
        {

            if (this.paddleBox.getBox().getX() + this.width >= i)
            {
                res = res + " P ";
            }
            else
                res = res + "   ";
        }
        return res;
    }


}
