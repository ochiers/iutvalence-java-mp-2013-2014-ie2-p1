package fr.iutvalence.java.mp.BrickBreaker;

// TODO (fixed) write comment
/**
 * Describe a position of an object on the screen
 * 
 * @author soulierc
 * 
 */
public class Position
{

    /**
     * Position on horizontal axis
     */
    private float x;

    /**
     * Position on vertical axis
     */
    private float y;

    /**
     * Create a new position according to given coordinates
     * 
     * @param x
     *            Horizontal position
     * @param y
     *            Vertical position
     */
    Position(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Return the horizontal position
     * 
     * @return x coordinate
     */
    public float getX()
    {
        return this.x;
    }

    /**
     * Return the vertical position
     * 
     * @return y coordinate
     */
    public float getY()
    {
        return this.y;
    }

    // TODO (fix) finish writing comment
    /**
     * Return a new position translated to deltaX ad deltaY
     * 
     * @param deltaX
     * @param deltaY
     * @return a position translated to x+deltaX and y+deltaY
     */
    public Position translate(float deltaX, float deltaY)
    {
        return new Position(this.x + deltaX, this.y + deltaY);
    }

    // TODO (fix) finish writing comment
    /**
     * Returns a description of the position as an ASCII string whose format is ...
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        return "Pos X : " + this.x + ", Pos Y : " + this.y;
    }

}
