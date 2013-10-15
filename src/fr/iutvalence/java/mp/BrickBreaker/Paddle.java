package fr.iutvalence.java.mp.BrickBreaker;

// TODO (fixed)(think about it) for plate, you mean "paddle" ?
/**
 * This class define what is a plate
 * @author ochiers soulierc
 *
 */
public class Paddle
{   
    /**
     * position on the paddle
     */
    private Position position;
    
    // TODO (fix) declare constant as a constant
    // TODO (fix) comply with naming conventions
    public final static int initialYPosition = 396;
    
    /**
     *  Width size of the paddle (in pixels)
     */
    private int size;
    
    // TODO (fix) declare constants before fields
    /**
     * Width size of the paddle (in pixels)
     */
    public final static int PADDLE_SIZE = 30;
    
    
    /**
     * That create a paddle with that we can play, X position can be specified
     * @param posX horizontal position of the paddle, vertical is constant
     * @param size  width of the paddle
     */
    public Paddle(float posX, int size)
    {
        super();
        this.position = new Position(posX,(float)this.initialYPosition);
        this.size = size;
    }

    /**
     * That create a paddle with that we can play
     */
    public Paddle()
    {
        super();
        this.position = new Position(0,this.initialYPosition);
        // TODO (fixed) declare hard-coded value as a constant
        this.size = this.PADDLE_SIZE; 
    }

    // TODO (fix) write comment
    // TODO (fix) rename method
    public Position getPaddlePosition()
    {
        return this.position;
    }
    

    /**
     * @return give the size of paddle
     */
    // TODO (fix) finish writing a comment
    public int getSize()
    {
        return size;
    }
    
    /**
     * @return set the size of paddle
     */
    // TODO (fix) finish writing a comment
    public void setSize(int size)
    {
        this.size = size;
    }   
}
