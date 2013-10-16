package fr.iutvalence.java.mp.BrickBreaker;

/**
 * This class defines the ball used to destroy bricks
 * 
 * @author ochiers soulierc
 **/
public class Ball
{
    
    // TODO (fixed) declare constants before fields
    /**
     *  This is the size of a ball
     */
    public final static int BALL_SIZE = 10;
    
    /**
     * It is the future position of the ball
     */
    private Position position;
    
    // TODO (think about it) consider gathering a and b in a single object 
    /**
     * a is the director coefficient of the ball's trajectory (y=ax+b)
     */
    private float a;
    
    /**
     * b from (y=ax+b)
     */
    private float b;
    
    
    // TODO (fixed) finish writing comment
    /**
     * Create a new ball at new position (x,y) and set fields a and b to 1
     */
    public Ball(float x, float y)
    {
        super();
        this.position = new Position(x,y);
        this.a=1;
        this.b=1;
    }
    
    // TODO (fixed) write comment
    // TODO (fixed) rename method
    /**
     * Set a new position according to x and y
     * @param x
     * @param y
     */
    public void setPosition(float x, float y)
    {
        this.position = new Position(x,y);   
    }
    
    // TODO (fixed) write comment
    // TODO (fixed) rename method
    /**
     * Return the ball's position
     * @return position
     */
    public Position getPosition()
    {     
        return this.position;    
    }

    // TODO (fixed) write comment
    /**
     * Return a field
     * @return a 
     */
    public float getA()
    {
        return a;
    }

    // TODO (fixed) write comment
    /**
     * Set a field
     * @param a
     */
    public void setA(float a)
    {
        this.a = a;
    }

    // TODO (fixed) write comment
    
    /**
     * return b field
     * @return b
     */
    public float getB()
    {
        return b;
    }

    // TODO (fixed) write comment
    /**
     * Set b field
     * @param b
     */
    public void setB(float b)
    {
        this.b = b;
    } 
}
