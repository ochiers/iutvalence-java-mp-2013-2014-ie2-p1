package fr.iutvalence.java.mp.BrickBreaker;

import java.awt.geom.Rectangle2D;

/**
 * Define a box who is used to determinate collision between differents elements
 * of the game
 * 
 * @author ochiers
 * 
 */
public class CollisionBox
{

    private Rectangle2D.Float box;

    /**
     * Constructor of a CollisionBox, it's a new rectangle a positon pos1 with
     * width and height specified
     * 
     * @param pos1
     * @param width
     * @param height
     */
    public CollisionBox(Position pos1, int width, int height)
    {
        this.box = new Rectangle2D.Float(pos1.getX(), pos1.getY(), width, height);
    }

    /**
     * Return the rectangle associated with this collisionBox
     * 
     * @return
     */
    public Rectangle2D.Float getBox()
    {
        return box;
    }

    /**
     * @param box2
     * @return
     */
    public Rectangle2D.Float getRectangleFromIntersectionWithOtherCollisionBox(CollisionBox box2)
    {
        Rectangle2D.Float dest = new Rectangle2D.Float();
        Rectangle2D.intersect(this.box, box2.getBox(), dest);
        return dest;
    }

}
