package fr.iutvalence.java.mp.BrickBreaker;

/**
 * Called when a game is created
 * @author ochiers soulierc
 * 
 * */
public class Game
{
    /**
     * Number of life
     */
    int nbBalls; 
    
   /**
    * The ball who shot the bricks
    */
    private Ball balle;
    
    /**
     * All the bricks are stocked in this tab
     * Is Public
     *
     */
    //TODO next time : create Get and Set methods
    Brick tabBrick[];
    
    /**
     * Width size of the container where we play
     */
    private int widthOfGame;
    
    /**
     * Height size of the container where we play
     */
    private int heightOfGame;
    
    
    public Game()
    {
        super();
        this.nbBalls = 3;
        this.widthOfGame = 500;
        this.heightOfGame = 440;
        this.balle = new Ball();
        this.tabBrick = new Brick[10];

        for(int i = 0; i<10; i++)
        {
            tabBrick[i] = new Brick(i*Brick.widthBrick,44);
        }
        
    }
    
    
}
