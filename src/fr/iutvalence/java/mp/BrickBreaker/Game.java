package fr.iutvalence.java.mp.BrickBreaker;



import java.util.Random;
/**
 * Called when a game is created
 * @author ochiers soulierc
 * 
 * */
public class Game
{
    
    // TODO (fixed) declare constants before fields
    // TODO (fixed) declare constant as a constant
    /**
     * Width size of the container where we play
     */
    private static final int WIDTH_OF_GAME_PANEL = 500;

    // TODO (fixed) declare constant as a constant
    /**
     * Height size of the container where we play
     */
    private static final int HEIGHT_OF_GAME_PANEL = 440;
    
    // TODO (fixed) declare constant as a constant
    /**
     * This number is the number of bricks in the level,
     * But it's a temp constant because this number can change depending 
     * on the level
     */
    public static final int NUMBER_OF_BRICKS = 10;
    
    // TODO (fixed) declare constant as a constant
    /**
     * this is a test to create a line of bricks with y position who equals to 44
     * 
     */
    private static final int Y_POSITION_BRICKS = 44;
    
    
    // TODO (fixed) this field should not be declared as public
    /**
     * Number of life
     */
    private int nbBalls; 

   /**
    * The ball that shoots the bricks
    */
    private Ball theBall;
    
    // TODO (fixed) fix comment
    /**
     * The paddle where the ball bounce
     */
     private Paddle thePaddle;
    
     // TODO (fixed) this field should not be declared as public
    /**
     * This tab contains all bricks of the game
     * That save their position, their state
     *
     */
    //TODO next time : create Get and Set methods
    private Brick[] bricks;
 
    
    /**
     *  This variable is a random number to give an other direction to the ball
     */
    private Random rand;
    
    
    // TODO (fixed) detail comment (how is the game created)
    /**
     * This is the procedure where the game find his start
     * It's the initialization of the game : a new paddle, a new ball and a new tab of bricks is created,
     * the number of lifes is 3 
     *
     */

    public Game()
    {
        super();
        // TODO (fix) declare hard-coded values as constants
        this.nbBalls = 3;
        // TODO (fix) declare hard-coded values as constants
        this.theBall = new Ball(50,50);
        // TODO (fix) declare hard-coded values as constants
        this.thePaddle = new Paddle(380F,Paddle.PADDLE_SIZE);
        this.bricks = new Brick[Game.NUMBER_OF_BRICKS];
        for(int i = 0; i<Game.NUMBER_OF_BRICKS; i++)
        {
            this.bricks[i] = new Brick(i*Brick.DEFAULT_WIDTH,Game.Y_POSITION_BRICKS);
        }
        this.rand = new Random();
        
        // TODO (fix) remove this call. The constructor is intended to return instantly
        go();
    }
    
    /**
     * method who move the ball and take care of the game's outlines
     */
    private void go()
    {
        /**
         * It is the test to know if the ball arrive at the outline 
         */
        // TODO (fix) declare hard-coded values as constants
        for(int i=0; i<1000; i++)
        {
            /**
             * 
             */
            if(!isIntBetween(this.theBall.getPosition().getPosX(),0,Game.WIDTH_OF_GAME_PANEL) || !isIntBetween(this.theBall.getPosition().getPosX() + Ball.BALL_SIZE,0,Game.WIDTH_OF_GAME_PANEL))
            {
                this.theBall.setB(-1*this.theBall.getB());
            }
            /*
             * Si l'ordonnée de la balle est supérieur au bord inférieur du jeu ou si  l'ordonnée de la balle est inférieur ou égale au bord supérieur du jeu
             * alors on change l'angle de la trajectoire
             */
            else if (this.theBall.getPosition().getPosY() <= 0 )
            {
                this.theBall.setA(-1*this.theBall.getA());
            }
            else if(this.theBall.getPosition().getPosY() + Ball.BALL_SIZE >= Paddle.INITIALYPOSITION)
            {
                if (isIntBetween(this.theBall.getPosition().getPosX(),this.thePaddle.getPosition().getPosX(),this.thePaddle.getPosition().getPosX()+this.thePaddle.getSize())||isIntBetween(this.theBall.getPosition().getPosX()+Ball.BALL_SIZE,this.thePaddle.getPosition().getPosX(),this.thePaddle.getPosition().getPosX()+this.thePaddle.getSize()))
                {
                        this.theBall.setA(-1*this.rand.nextFloat());
                }
                else
                {
                    System.out.println("perdu");
                    i = 1000;
                }
            }
            
            this.theBall.setPosition(this.theBall.getPosition().getPosX() + this.theBall.getB(),this.theBall.getPosition().getPosY() + this.theBall.getA() );

            
            
            System.out.println("{"+this.theBall.getPosition().getPosX()+", "+this.theBall.getPosition().getPosY()+"}");
            
        }
        
    
    }
    
    /**
     * Function who say if the number toCompare is between the number a and the number b
     * @param toCompare
     * @param a 
     * @param b
     * @return
     */
   private boolean isIntBetween(float toCompare, float a, float b)
    {
        return (toCompare >= a && toCompare <= b)||(toCompare >= b && toCompare <= a);
    }
    
}
