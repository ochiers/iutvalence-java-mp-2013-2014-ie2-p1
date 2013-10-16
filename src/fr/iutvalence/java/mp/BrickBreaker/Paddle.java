package fr.iutvalence.java.mp.BrickBreaker;

// TODO (fixed)(think about it) for plate, you mean "paddle" ?
/**
 * This class define what is a plate
 * @author ochiers soulierc
 *
 */
public class Paddle
{   
    
    // TODO (fix) declare constants before fields
    /**
     * Width size of the paddle (in pixels)
     */
    public final static int PADDLE_SIZE = 30;

    
    // TODO (fixed) declare constant as a constant
    // TODO (fixed) comply with naming conventions
    /**
     * The paddle is always at the same height : 396
     */
    public static final int INITIALYPOSITION = 396;
    
    /**
     *  Width size of the paddle (in pixels)
     */
    private int size;

    /**
     * position on the paddle
     */
    private Position position;
    
    /**
     * That create a paddle with that we can play, X position can be specified
     * @param posX horizontal position of the paddle, vertical is constant
     * @param size  width of the paddle
     */
    public Paddle(float posX, int size)
    {
        super();
        this.position = new Position(posX,(float)Paddle.INITIALYPOSITION);
        this.size = size;
    }

    /**
     * That create a paddle with that we can play
     */
    public Paddle()
    {
        super();
        this.position = new Position(0,Paddle.INITIALYPOSITION);
        // TODO (fixed) declare hard-coded value as a constant
        this.size = Paddle.PADDLE_SIZE; 
    }

    // TODO (fix) write comment
    // TODO (fix) rename method
    /**
     * Return the paddle's position
     * @return position
     */
    public Position getPosition()
    {
        return this.position;
    }
    

    /**
     * Return the paddle's size
     * @return give the size of paddle
     */
    // TODO (fixed) finish writing a comment
    public int getSize()
    {
        return this.size;
    }

    // TODO (fixed) finish writing a comment

    /**
     * Set the paddle's size
     * @param size
     */
    public void setSize(int size)
    {
        this.size = size;
    }   
}
