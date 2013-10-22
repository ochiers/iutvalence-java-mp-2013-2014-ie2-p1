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

    // TODO (fix) comply with naming conventions
    /**
     * The paddle is always at the same height : 396
     */
    public static final int INITIALYPOSITION = 396;

    /**
     * Width size of the paddle (in pixels)
     */
    private int size;

    /**
     * position on the paddle
     */
    // TODO (explain) what is precisely this position?
    private Position position;

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
        this.position = new Position(posX, (float) Paddle.INITIALYPOSITION);
        this.size = size;
    }

    /**
     * That create a paddle with that we can play
     */
    public Paddle()
    {
        super();
        this.position = new Position(0, Paddle.INITIALYPOSITION);
        this.size = Paddle.PADDLE_SIZE;
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
}
