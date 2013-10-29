package fr.iutvalence.java.mp.BrickBreaker;

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
     * Position of top left corner of the paddle
     */
    private Position topLeftCornerPosition;

    /**
     * CollisionBox associated with this paddle
     */
    private CollisionBox collisionBox;

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
        super();
        this.topLeftCornerPosition = topLeftCornerPosition;
        this.width = width;
        this.collisionBox = new CollisionBox(this.topLeftCornerPosition, this.width, DEFAULT_HEIGHT);
    }

    /**
     * creates a paddle initially at DEFAULT_TOP_LEFT_CORNER_POSITION and with
     * the default width size DEFAULT_WIDTH and the CollisionBox associated
     */
    public Paddle()
    {
        super();
        this.topLeftCornerPosition = DEFAULT_TOP_LEFT_CORNER_POSITION;
        this.width = Paddle.DEFAULT_WIDTH;
        this.collisionBox = new CollisionBox(this.topLeftCornerPosition, this.width, DEFAULT_HEIGHT);
    }

    /**
     * Return a CollisionBox associated with this paddle
     * 
     * @return the CollisionBox associated with this paddle
     */
    public CollisionBox getCollisionBox()
    {
        return this.collisionBox;
    }

    /**
     * Return the paddle's position
     * 
     * @return position
     */
    public Position getTopLeftCornerPosition()
    {
        return this.topLeftCornerPosition;
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
        this.topLeftCornerPosition = newTopLeftCornerPosition;
        this.collisionBox = new CollisionBox(this.topLeftCornerPosition, this.width, this.width);
    }

    /**
     * Returns a description of the paddle as an ASCII string whose format is
     * "{Paddle's position, size : Paddle's width}"
     * 
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        return "{" + this.topLeftCornerPosition.toString() + ", size : " + this.width + "}";
    }

    public String stringPaddleInConsole()
    {
        String res = "#";
        for (int i = 0; i < Game.DEFAULT_MAP_WIDTH; i += Game.DEFAULT_MAP_WIDTH / (2 * Ball.DEFAULT_SIZE))
        {

            if (isFloatBetween(this.getTopLeftCornerPosition().getY(), i, (i + Game.DEFAULT_MAP_HEIGHT
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
