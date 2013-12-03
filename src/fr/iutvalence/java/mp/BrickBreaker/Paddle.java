package fr.iutvalence.java.mp.BrickBreaker;
 
import java.awt.geom.Rectangle2D;

/**
 * This class define what is a plate
 * 
 * @author ochiers soulierc
 * 
 */
public class Paddle extends GameComponent
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
        super(pos,width,Paddle.DEFAULT_HEIGHT);
        this.setWidth(width);
    }

    
    // TODO (fix) remove this (inherited!)
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
    public float getWidth()
    {
        return this.getCollisionBox().getBox().width;
    }

    /**
     * Set a new paddle width
     * 
     * @param width
     *            New width of the paddle
     */
    public void setWidth(int width)
    {
        this.getCollisionBox().getBox().width = width;
    }

    /**
     * Update the position of the paddle and his collisionBox
     * @param newPos   
     *              New position of the paddle
     */
    public void setTopLeftCornerPosition(Position newPos)
    {
        this.collisionBox.updateBox(new Rectangle2D.Float(newPos.getX(), newPos.getY(), this.getWidth(), Paddle.DEFAULT_HEIGHT));
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
        return "{" + pos.toString() + ", size : " + this.getWidth() + "}";
    }

}
