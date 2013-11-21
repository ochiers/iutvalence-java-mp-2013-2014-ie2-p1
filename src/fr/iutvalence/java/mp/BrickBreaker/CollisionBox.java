package fr.iutvalence.java.mp.BrickBreaker;
 
import java.awt.geom.Rectangle2D;

/**
 * Define a box who is used to determinate collision between different elements
 * of the game
 * 
 * @author ochiers
 * 
 */
public class CollisionBox
{

    /**
     * Define a rectangle2D used to determinate a collision
     */
    private Rectangle2D.Float box;

    /**
     * Constructor of a CollisionBox, it's a new rectangle a positon pos1 with
     * width and height specified
     * 
     * @param pos1 the position of the box
     * @param width width size of the box
     * @param height height size of the box
     */
    public CollisionBox(Position pos1, int width, int height)
    {
        this.box = new Rectangle2D.Float(pos1.getX(), pos1.getY(), width, height);
    }

    /**
     * Return the rectangle associated with this CollisionBox
     * 
     * @return The Rectangle2D associated with this CollisionBox
     */
    public Rectangle2D.Float getBox()
    {
        return this.box;
    }

    /**
     * Update the Rectangle2D associated with this CollisionBox
     * @param box The new rectangle2d who represent the CollisionBox
     */
    public void updateBox(Rectangle2D.Float box)
    {
        this.box = box;
    }

    /**
     * Return a rectangle2D corresponding to the intersection between this
     * CollisionBox and another
     * 
     * @param box2 The other collisionBox to compare
     * @return the rectangle2D corresponding to the intersection between this
     *         CollisionBox and box2
     */
    public Rectangle2D.Float getRectangleFromIntersectionWithOtherCollisionBox(CollisionBox box2)
    {
        Rectangle2D.Float dest = new Rectangle2D.Float();
        Rectangle2D.intersect(this.box, box2.getBox(), dest);
        return dest;
    }

}
