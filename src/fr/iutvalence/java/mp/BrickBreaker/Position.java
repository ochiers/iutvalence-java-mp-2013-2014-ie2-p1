package fr.iutvalence.java.mp.BrickBreaker;

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
     * Return a new position translated to deltaX and deltaY
     * 
     * @param deltaX
     * @param deltaY
     * @return A position translated to x+deltaX and y+deltaY
     */
    public Position translate(float deltaX, float deltaY)
    {
        return new Position(this.x + deltaX, this.y + deltaY);
    }

    /**
     * Returns a description of the position as an ASCII string whose format is
     * "[Position's x field, Position's y field]"
     * 
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        return "[" + this.x + ", " + this.y + "]";
    }

}
