package fr.iutvalence.java.mp.BrickBreaker;

/**
 * Called when a game is created
 * @author ochiers soulierc
 * 
 * */

import java.util.Random;

public class Game
{
    // TODO (fix) this field should not be declared as public
    /**
     * Number of life
     */
    public int nbBalls; 

   /**
    * The ball that shoots the bricks
    */
    private Ball theBall;
    
    // TODO (fix) fix comment
    /**
     * The ball that shoots the bricks
     */
     private Paddle thePaddle;
    
     // TODO (fix) this field should not be declared as public
    /**
     * This tab contains all bricks of the game
     * That save their position, their state
     *
     */
    //TODO next time : create Get and Set methods
    public Brick[] bricks;
    
    // TODO (fix) declare constants before fields
    // TODO (fix) declare constant as a constant
    /**
     * Width size of the container where we play
     */
    private final int WIDTH_OF_GAME_PANEL = 500;

    // TODO (fix) declare constant as a constant
    /**
     * Height size of the container where we play
     */
    private final int HEIGHT_OF_GAME_PANEL = 440;
    
    // TODO (fix) declare constant as a constant
    /**
     * This number is the number of bricks in the level,
     * But it's a temp constant because this number can change depending 
     * on the level
     */
    public final int NUMBER_OF_BRICKS = 10;
    
    // TODO (fix) declare constant as a constant
    /**
     * this is a test to create a line of bricks with y position who equals to 44
     * 
     */
    private final int Y_POSITION_BRICKS = 44;
    
    
    /**
     *  This variable is a random number to give an other direction to the ball
     */
    private Random rand;
    
    
    // TODO (fix) detail comment (how is the game created)
    /**
     * This is the procedure where the game find his start
     * It's the initialization of the game
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
        this.bricks = new Brick[this.NUMBER_OF_BRICKS];
        for(int i = 0; i<this.NUMBER_OF_BRICKS; i++)
        {
            this.bricks[i] = new Brick(i*Brick.DEFAULT_WIDTH,this.Y_POSITION_BRICKS);
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
            if(!isIntBetween(this.theBall.getPositionBall().getPosX(),0,this.WIDTH_OF_GAME_PANEL) || !isIntBetween(this.theBall.getPositionBall().getPosX() + Ball.BALL_SIZE,0,this.WIDTH_OF_GAME_PANEL))
            {
                this.theBall.setB(-1*this.theBall.getB());
            }
            /*
             * Si l'ordonnée de la balle est supérieur au bord inférieur du jeu ou si  l'ordonnée de la balle est inférieur ou égale au bord supérieur du jeu
             * alors on change l'angle de la trajectoire
             */
            else if (this.theBall.getPositionBall().getPosY() <= 0 )
            {
                this.theBall.setA(-1*this.theBall.getA());
            }
            else if(this.theBall.getPositionBall().getPosY() + Ball.BALL_SIZE >= Paddle.initialYPosition)
            {
                if (isIntBetween(this.theBall.getPositionBall().getPosX(),thePaddle.getPaddlePosition().getPosX(),thePaddle.getPaddlePosition().getPosX()+thePaddle.getSize())||isIntBetween(this.theBall.getPositionBall().getPosX()+theBall.BALL_SIZE,thePaddle.getPaddlePosition().getPosX(),thePaddle.getPaddlePosition().getPosX()+thePaddle.getSize()))
                {
                        this.theBall.setA(-1*rand.nextFloat());
                }
                else
                {
                    System.out.println("perdu");
                    i = 1000;
                }
            }
            
            this.theBall.setPositionBall(this.theBall.getPositionBall().getPosX() + this.theBall.getB(),this.theBall.getPositionBall().getPosY() + this.theBall.getA() );

            
            
            System.out.println("{"+this.theBall.getPositionBall().getPosX()+", "+this.theBall.getPositionBall().getPosY()+"}");
            
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
