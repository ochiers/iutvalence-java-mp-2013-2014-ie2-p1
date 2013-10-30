package fr.iutvalence.java.mp.BrickBreaker;

import java.awt.geom.Rectangle2D;

/**
 * This class define what is a plate
 * 
 * @author ochiers soulierc
 * 
 */
public class Paddle extends CollisionBox
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
     * Create a new paddle and the CollisionBox associated at a given position
     * and with the given width size
     * 
     * @param topLeftCornerPosition
     *            Paddle's initial position of the top left corner
     * @param width
     *            Paddle's width size
     */
    public Paddle(Position topLeftCornerPosition, int width)
    {
        super(topLeftCornerPosition,width, DEFAULT_HEIGHT);
        this.width = width;
    }

    /**
     * creates a paddle initially at DEFAULT_TOP_LEFT_CORNER_POSITION and with
     * the default width size DEFAULT_WIDTH and the CollisionBox associated
     */
    public Paddle()
    {
        super(DEFAULT_TOP_LEFT_CORNER_POSITION, Paddle.DEFAULT_WIDTH, DEFAULT_HEIGHT);
        this.width = Paddle.DEFAULT_WIDTH;
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

    public void setTopLeftCornerPosition(Position newTopLeftCornerPosition)
    {
        this.setBox(new Rectangle2D.Float(newTopLeftCornerPosition.getX(), newTopLeftCornerPosition.getY(), this.width, Paddle.DEFAULT_HEIGHT));
    }

    /**
     * Returns a description of the paddle as an ASCII string whose format is
     * "{Paddle's position, size : Paddle's width}"
     * 
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        Position pos = new Position(this.getBox().x,this.getBox().y);
        return "{" + pos.toString() + ", size : " + this.width + "}";
    }

    public String stringPaddleInConsole()
    {
        String res = "#";
        for (int i = 0; i < Game.DEFAULT_MAP_WIDTH; i += Game.DEFAULT_MAP_WIDTH / (2 * Ball.DEFAULT_SIZE))
        {

            if (isFloatBetween((float)this.getBox().getY(), i, (i + Game.DEFAULT_MAP_HEIGHT
                    / (2 * Ball.DEFAULT_SIZE))))
            {
                res = res + "P";
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
