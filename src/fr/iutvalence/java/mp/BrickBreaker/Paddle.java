package fr.iutvalence.java.mp.BrickBreaker;

// TODO (fixed)(think about it) for plate, you mean "paddle" ?
/**
 * This class define what is a plate
 * @author ochiers soulierc
 *
 */
public class Paddle
{
 // TODO (fixed) move this couple of int in a class named Position
    
    /**
     * position on the paddle
     */
    private Position paddlePosition;
    
    public final static int initialYPosition = 396;
    
    /**
     *  Width size of the paddle (in pixels)
     */
    private int size;
    
    /**
     * Width size of the paddle (in pixels)
     */
    public final static int PADDLE_SIZE = 30;
    
    
    // TODO (fixed) write a comment
    /**
     * That create a paddle with that we can play, X position can be specified
     * @param posX horizontal position of the paddle, vertical is constant
     * @param size  width of the paddle
     */
    public Paddle(float posX, int size)
    {
        super();
        this.paddlePosition = new Position(posX,(float)this.initialYPosition);
        this.size = size;
    }

    /**
     * That create a paddle with that we can play
     */
    // TODO (fixed) write a comment
    public Paddle()
    {
        super();
        this.paddlePosition = new Position(0,this.initialYPosition);
        // TODO (fixed) declare hard-coded value as a constant
        this.size = this.PADDLE_SIZE; 
    }

    public Position getPaddlePosition()
    {
        return this.paddlePosition;
    }
    

    /**
     * @return give the size of paddle
     */
    // TODO (fixed) write a comment
    public int getSize()
    {
        return size;
    }
    
    /**
     * @return set the size of paddle
     */
    // TODO (fixed) write a comment
    public void setSize(int size)
    {
        this.size = size;
    }   
}
