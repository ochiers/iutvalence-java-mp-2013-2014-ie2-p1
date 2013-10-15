package fr.iutvalence.java.mp.BrickBreaker;

/**
 * This class defines the ball used to destroy bricks
 * 
 * @author ochiers soulierc
 **/
public class Ball
{
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
    
    // TODO (fix) declare constants before fields
    /**
     *  This is the size of a ball
     */
    public final static int BALL_SIZE = 10;
    
    
    // TODO (fix) finish writing comment
    /**
     * It create a ball at position (x,y)
     */
    public Ball(float x, float y)
    {
        super();
        this.position = new Position(x,y);
        this.a=1;
        this.b=1;
    }
    
    // TODO (fix) write comment
    // TODO (fix) rename method
    public void setPositionBall(float x, float y)
    {
        this.position = new Position(x,y);   
    }
    
    // TODO (fix) write comment
    // TODO (fix) rename method
    public Position getPositionBall()
    {     
        return this.position;    
    }

    // TODO (fix) write comment
    public float getA()
    {
        return a;
    }

    // TODO (fix) write comment
    public void setA(float a)
    {
        this.a = a;
    }

    // TODO (fix) write comment
    public float getB()
    {
        return b;
    }

    // TODO (fix) write comment
    public void setB(float b)
    {
        this.b = b;
    } 
}
