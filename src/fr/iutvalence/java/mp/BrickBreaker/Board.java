package fr.iutvalence.java.mp.BrickBreaker;

// TODO (fixed)(think about it) for plate, you mean "board" ?
/**
 * This class define what is a plate
 * @author ochiers soulierc
 *
 */
public class Board
{
 // TODO (fixed) move this couple of int in a class named Position
    
    /**
     * position on the board
     */
    private Position boardPosition;
    
    private final static int initialYPosition = 396;
    
    /**
     *  Width size of the plate (in pixels)
     */
    private int size;
    
    // TODO (fix) write a comment
    
    public Board(int posX, int size)
    {
        super();
        this.boardPosition = new Position(posX,this.initialYPosition);
        this.size = size;
    }

    // TODO (fix) write a comment
    public Board()
    {
        super();
        this.boardPosition = new Position(0,this.initialYPosition);
        // TODO (fix) declare hard-coded value as a constant
        this.size = 30;
    }

    public Position getBoardPosition()
    {
        return this.boardPosition;
    }
    

    /**
     * @return give the size of board
     */
    // TODO (fixed) write a comment
    public int getSize()
    {
        return size;
    }
    
    /**
     * @return set the size of board
     */
    // TODO (fixed) write a comment
    public void setSize(int size)
    {
        this.size = size;
    }   
}
