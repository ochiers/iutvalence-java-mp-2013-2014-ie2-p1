package fr.iutvalence.java.mp.BrickBreaker;

// TODO (fixed) write comment
/**
 * Describe a position of an object on the screen
 * @author soulierc
 *
 */
public class Position
{

    /**
     * Position on horizontal axis
     */
    private float posX;

    /**
     * Position on vertical axis
     */
    private float posY;

    // TODO (fixed) write comment
    /**
     * Create a new position according to given coordinates
     * @param x Horizontal position
     * @param y Vertical position
     */
    Position(float x, float y)
    {
        this.posX = x;
        this.posY = y;
    }

    // TODO (fixed) finish writing comment
    /**
     * Return the horizontal position
     * @return x position
     */
    public float getPosX()
    {
        return this.posX;
    }

    // TODO (fixed) finish writing comment
    /**
     * Return the vertical position
     * @return y position
     */
    public float getPosY()
    {
        return this.posY;
    }

}
