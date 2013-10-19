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
     * It is the top left corner position of the ball
     */
    private Position positionLeftTopCorner;
    /**
     * It is the Bottom left corner position of the ball
     */
    private Position positionLeftBottomCorner;
    /**
     * It is the top right corner position of the ball
     */
    private Position positionRightTopCorner;
    /**
     * It is the bottom right corner position of the ball
     */
    private Position positionRightBottomCorner;
    
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
        this.positionLeftTopCorner = new Position(x,y);
        this.positionLeftBottomCorner = new Position(x,y+Ball.BALL_SIZE);
        this.positionRightTopCorner = new Position(x+Ball.BALL_SIZE,y);
        this.positionRightBottomCorner = new Position(x+Ball.BALL_SIZE,y+Ball.BALL_SIZE);
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
        this.positionLeftTopCorner = new Position(x,y);   
    }
    
    // TODO (fixed) write comment
    // TODO (fixed) rename method
    /**
     * Return the ball's top left corner position
     * @return position
     */
    public Position getPositionLeftTopCorner()
    {
        return this.positionLeftTopCorner; 
    }
    /**
     * Return the ball's bottom left corner position
     * @return position
     */
    public Position getPositionLeftBottomCorner() {
        return positionLeftBottomCorner;
    }
    /**
     * Return the ball's top right corner position
     * @return position
     */
    public Position getPositionRightTopCorner() {
        return positionRightTopCorner;
    }
    /**
     * Return the ball's bottom right corner position
     * @return position
     */
    public Position getPositionRightBottomCorner() {
        return positionRightBottomCorner;
    }
    
    
    /**
     * Set the four corner's position according to x,d and the baal size
     * @param x
     * @param d
     */
    public void setPositionBall(float x, float d)
    {
        
        this.positionLeftTopCorner = new Position(x,d);
        this.positionLeftBottomCorner = new Position(x,d+Ball.BALL_SIZE);
        this.positionRightTopCorner = new Position(x+Ball.BALL_SIZE,d);
        this.positionRightBottomCorner = new Position(x+Ball.BALL_SIZE,d+Ball.BALL_SIZE);
        
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
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        return "{X : " + getPositionLeftTopCorner().getPosX() +", Y : " + getPositionLeftTopCorner().getPosY() + ", a : " + getA() + ", b : " + getB() + "}";
    }
}
