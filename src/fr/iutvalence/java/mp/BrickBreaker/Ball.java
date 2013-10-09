package fr.iutvalence.java.mp.BrickBreaker;

/**
 * This class defines the ball used to destroy bricks
 * 
 * @author ochiers soulierc
 **/
public class Ball
{
    // TODO (FIXED) move this couple of int in a class named Position

    /**
     * It is the future position of the ball
     */
    private Position positionBall;
    
    /**
     * a is the director coefficient of the ball's trajectory (y=ax+b)
     */
    private float a;
    
    /**
     * b from (y=ax+b)
     */
    private float b;
    
    /**
     *  This is the size of a ball
     */
    public final static int BALL_SIZE = 10;
    
    /**
     * It create a ball at position (x,y)
     */

    public Ball(float x, float y)
    {
        super();
        this.positionBall = new Position(x,y);
        this.a=1;
        this.b=1;
    }
    
    public void setPositionBall(float x, float y)
    {
        
        this.positionBall = new Position(x,y);
        
    }
    
    public Position getPositionBall()
    {
        
        return this.positionBall; 
        
    }

    public float getA()
    {
        return a;
    }

    public void setA(float a)
    {
        this.a = a;
    }

    public float getB()
    {
        return b;
    }

    public void setB(float b)
    {
        this.b = b;
    }
    
    
    
}
