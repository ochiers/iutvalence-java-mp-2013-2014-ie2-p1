package fr.iutvalence.java.mp.BrickBreaker;

// TODO (fixed)(think about it) for plate, you mean "paddle" ?
/**
 * This class define what is a plate
 * 
 * @author ochiers soulierc
 * 
 */
public class Paddle
{

    /**
     * Width size of the paddle (in pixels)
     */
    public final static int PADDLE_SIZE = 30;
    
    /**
     * Height size of the paddle (in pixels)
     */
    public final static int PADDLE_HEIGHT = 10;
    
    
    // TODO (fixed) comply with naming conventions
    /**
     * The paddle is always at the same height : 396
     */
    public static final int INITIAL_Y_POSITION = 396;

    /**
     * Width size of the paddle (in pixels)
     */
    private int size;

    /**
     * Position of top left corner of the paddle, in fact only the x will change with the mouse's position
     */
    // TODO (explain) what is precisely this position?
    private Position position;
    

    /**
     * 
     */
    private CollisionBox paddleBox;

    public CollisionBox getPaddleBox()
    {
        return paddleBox;
    }

    /**
     * That create a paddle with that we can play, X position can be specified
     * 
     * @param posX
     *            horizontal position of the paddle, vertical is constant
     * @param size
     *            width of the paddle
     */
    public Paddle(float posX, int size)
    {
        super();
        this.position = new Position(posX, (float) Paddle.INITIAL_Y_POSITION);
        this.size = size;
        this.paddleBox = new CollisionBox(this.position, this.size, PADDLE_HEIGHT);
    }

    /**
     * That create a paddle with that we can play
     */
    public Paddle()
    {
        super();
        this.position = new Position(0, Paddle.INITIAL_Y_POSITION);
        this.size = Paddle.PADDLE_SIZE;
        this.paddleBox = new CollisionBox(this.position, this.size, PADDLE_HEIGHT);
    }

    /**
     * Return the paddle's position
     * 
     * @return position
     */
    public Position getPosition()
    {
        return this.position;
    }

    /**
     * Return the paddle's size
     * 
     * @return give the size of paddle
     */
    public int getSize()
    {
        return this.size;
    }

    /**
     * Set the paddle's size
     * 
     * @param size
     */
    public void setSize(int size)
    {
        this.size = size;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        return "{" + this.position.toString() + ", size : " + this.size + "}";
    }
    
}
