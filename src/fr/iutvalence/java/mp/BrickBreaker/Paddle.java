package fr.iutvalence.java.mp.BrickBreaker;

// TODO (fixed)(think about it) for plate, you mean "paddle" ?
/**
 * This class define what is a plate
 * 
 * @author ochiers soulierc
 * 
 */
public class Paddle
{
    /**
     *  Paddle width 
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

    // TODO (fix) write comment
    private CollisionBox collisionBox;

    // TODO (fix) write comment
    public Paddle(Position topLeftCornerPosition, int width)
    {
        super();
        this.topLeftCornerPosition = topLeftCornerPosition;
        this.width = width;
        this.collisionBox = new CollisionBox(this.topLeftCornerPosition, this.width, DEFAULT_HEIGHT);
    }

    
    // TODO (fix) finish writing comment
    /**
     * creates a paddle initially ...
     */
    public Paddle()
    {
        super();
        this.topLeftCornerPosition = DEFAULT_TOP_LEFT_CORNER_POSITION;
        this.width = Paddle.DEFAULT_WIDTH;
        this.collisionBox = new CollisionBox(this.topLeftCornerPosition, this.width, DEFAULT_HEIGHT);
    }

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

    // TODO (fix) finish xriting comment
    /**
     * Set the paddle width
     * 
     * @param width
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

    // TODO (fix) finish writing comment
    /**
     * Returns a description of the paddle as an ASCII string whose format is ...
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        return "{" + this.topLeftCornerPosition.toString() + ", size : " + this.width + "}";
    }

}
