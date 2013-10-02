package fr.iutvalence.java.mp.BrickBreaker;

/**
 * Called when a game is created
 * @author ochiers soulierc
 * 
 * */
public class Game
{
    // TODO (fix) declare field visibility
    // TODO (fix) rename field (there is more than one life)
    /**
     * Number of life
     */
    int nbBalls; 

    // TODO (fix) rename field 
   /**
    * The ball that shoots the bricks
    */
    private Ball balle;
    
    // TODO (fix) declare field visibility
    // TODO (fix) write a comment that really describe what this field is
    /**
     * All the bricks are stocked in this tab
     * Is Public
     *
     */
    //TODO next time : create Get and Set methods
    Brick tabBrick[];
    
    // TODO (fix) rename field (game has no width)
    /**
     * Width size of the container where we play
     */
    private int widthOfGame;

    // TODO (fix) rename field (game has no height)
    /**
     * Height size of the container where we play
     */
    private int heightOfGame;
    
    // TODO (fix) write a comment
    public Game()
    {
        super();
        this.nbBalls = 3;
        // TODO declare hard-coded value as constant
        this.widthOfGame = 500;
        // TODO declare hard-coded value as constant
        this.heightOfGame = 440;
        this.balle = new Ball();
        // TODO declare hard-coded value as constant
        this.tabBrick = new Brick[10];

        // TODO declare hard-coded value as constant
        for(int i = 0; i<10; i++)
        {
            // TODO declare hard-coded value as constant
            // TODO qualifiy field access
            tabBrick[i] = new Brick(i*Brick.widthBrick,44);
        }
        
    }
    
    
}
