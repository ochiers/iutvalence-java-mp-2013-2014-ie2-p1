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
    // TODO (think about it) this feld seems redundant with the collision box
    // (the information can surely be retrieved using the collision box)
    private int width;

    /**
     * The collision box associated with this paddle
     * It's used to determinate collisions
     */
    private CollisionBox collisionBox;
    
    
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
        this.collisionBox = new CollisionBox(pos,width,Paddle.DEFAULT_HEIGHT);
        this.width = width;
    }

    /**
     * creates a paddle initially at DEFAULT_TOP_LEFT_CORNER_POSITION and with
     * the default width size DEFAULT_WIDTH and the CollisionBox associated
     */
    // TODO (think about it) is it useful to have a default collisionBox if
    // area dimensions are not known?
    public Paddle()
    {
        this.collisionBox = new CollisionBox(Paddle.DEFAULT_TOP_LEFT_CORNER_POSITION,Paddle.DEFAULT_WIDTH,Paddle.DEFAULT_HEIGHT);
        this.width = Paddle.DEFAULT_WIDTH;
    }

    /**
     * Return the CollisionBox associated with this paddle
     * @return The paddle's CollisionBox
     */
    public CollisionBox getCollisionBox()
    {
        return this.collisionBox;
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
        this.collisionBox.updateBox(new Rectangle2D.Float(newPos.getX(), newPos.getY(), this.width, Paddle.DEFAULT_HEIGHT));
    }

    /**
     * Returns a description of the paddle as an ASCII string whose format is
     * "{Paddle's position, size : Paddle's width}" 
     * 
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        Position pos = new Position((float)this.collisionBox.getBox().getX(),(float)this.collisionBox.getBox().getY());
        return "{" + pos.toString() + ", size : " + this.width + "}";
    }

    


}
