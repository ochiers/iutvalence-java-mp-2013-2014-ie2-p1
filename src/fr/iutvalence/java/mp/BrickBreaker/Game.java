package fr.iutvalence.java.mp.BrickBreaker;

import java.util.Random;

/**
 * Called when a game is created
 * @author ochiers soulierc
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
    
    /**
     * Maximal number of player's lives
     */
    private static final int MAXIMAL_LIVES = 3;
    
    /**
     * Paddle initial position
     */
    private static final float PADDLE_INITIAL_POSITION = 250.0F;
    
    /**
     * Constant for tests, number maximal of ball's moves
     */
    private static final int NB_MAX_BALL_MOVES = 1000;    
    
    // TODO (fixed) this field should not be declared as public
    /**
     * Number of lives
     */
    private int currentNbBalls; 

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
    
    
    /**
     * Number of brick currently not in state destroyed
     */
    private int currentNbBricks;
    
    
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
        // TODO (fixed) declare hard-coded values as constants
        this.currentNbBalls = Game.MAXIMAL_LIVES;
        // TODO (fixed) declare hard-coded values as constants
        this.theBall = new Ball(Game.PADDLE_INITIAL_POSITION/2,Game.PADDLE_INITIAL_POSITION/2);
        // TODO (fixed) declare hard-coded values as constants
        this.thePaddle = new Paddle(Game.PADDLE_INITIAL_POSITION,Paddle.PADDLE_SIZE);
        this.bricks = new Brick[Game.NUMBER_OF_BRICKS];
        for(int i = 0; i<Game.NUMBER_OF_BRICKS; i++)
        {
            this.bricks[i] = new Brick(i*Brick.DEFAULT_WIDTH,Game.Y_POSITION_BRICKS);
        }
        this.rand = new Random();
        
    }
    
    /**
     * method who move the ball and take care of the game's outlines
     */
    public void go()
    {
        boolean stop = false;
        boolean thereWasAcollision = false;
        int collisionSide = 0;
        
        // TODO (fix) declare hard-coded values as constants
        for(int i=0; i<Game.NB_MAX_BALL_MOVES; i++)
        {
            /**
             * 
             */
            if(!isIntBetween(this.theBall.getPositionLeftTopCorner().getPosX(),0,Game.WIDTH_OF_GAME_PANEL) || !isIntBetween(this.theBall.getPositionLeftTopCorner().getPosX() + Ball.BALL_SIZE,0,Game.WIDTH_OF_GAME_PANEL))
            {
                this.theBall.setB(-1*this.theBall.getB());
            }
            /*
             * Si l'ordonnée de la balle est supérieur au bord inférieur du jeu ou si  l'ordonnée de la balle est inférieur ou égale au bord supérieur du jeu
             * alors on change l'angle de la trajectoire
             */
            else if (this.theBall.getPositionLeftTopCorner().getPosY() <= 0 )
            {
                this.theBall.setA(-1*this.theBall.getA());
            }
            else if(this.theBall.getPositionLeftTopCorner().getPosY() + Ball.BALL_SIZE >= Paddle.INITIALYPOSITION)
            {
                if (isIntBetween(this.theBall.getPositionLeftTopCorner().getPosX(),this.thePaddle.getPosition().getPosX(),this.thePaddle.getPosition().getPosX()+this.thePaddle.getSize())||isIntBetween(this.theBall.getPositionLeftTopCorner().getPosX()+Ball.BALL_SIZE,this.thePaddle.getPosition().getPosX(),this.thePaddle.getPosition().getPosX()+this.thePaddle.getSize()))
                {
                        this.theBall.setA(-1*this.rand.nextFloat());
                }
                else
                {
                    System.out.println("perdu");
                    i = Game.NB_MAX_BALL_MOVES;
                }
            }
            
            this.theBall.setPosition(this.theBall.getPositionLeftTopCorner().getPosX() + this.theBall.getB(),this.theBall.getPositionLeftTopCorner().getPosY() + this.theBall.getA() );

            if(this.currentNbBalls !=0 && this.currentNbBricks ==0)
            {
                stop = true;
                System.out.println("GAGNE !");
            }
            int j;
            thereWasAcollision = false;
            for(j=0; j <10;j++)
            {
                if(this.bricks[j].getState() != Brick.DESTROYED_STATE)
                {
                    collisionSide = isBallInColisionToBrick(j);
                    if(collisionSide != 0)
                    {
                        this.bricks[j].setState(Brick.DESTROYED_STATE);
                        this.currentNbBricks--;
                        if(!thereWasAcollision)
                        {
                        switch (collisionSide)
                            {
                            case 1: this.theBall.setB(-1*this.theBall.getB()); break;
                            case 2: this.theBall.setA(-1*this.theBall.getA()); break;
                            }
                        }
                        thereWasAcollision = true;
                    }
                }
            }
            System.out.println(this.theBall.toString());
        }
        
    
    }
    
 
    /**
     * Function who say if the ball is in collision with the brick, in the tab of bricks to the index i
     * @param i Index of the brick to compare in the game tab brick
     * @return true in case of collision, false otherwise
     */
    private int isBallInColisionToBrick(int i)
    {
        int res;
        Position posBaLT = this.theBall.getPositionLeftTopCorner();
        Position posBaLB = this.theBall.getPositionLeftBottomCorner();
        Position posBaRT = this.theBall.getPositionRightTopCorner();
        Position posBaRB = this.theBall.getPositionRightBottomCorner();
        Position posBr = this.bricks[i].getBrickPosition();
        
        if((!isPositionInRect(posBaLT,posBr,Brick.DEFAULT_WIDTH,Brick.DEFAULT_HEIGHT) && !isPositionInRect(posBaLB,posBr,Brick.DEFAULT_WIDTH,Brick.DEFAULT_HEIGHT)) && (isPositionInRect(posBaRT,posBr,Brick.DEFAULT_WIDTH,Brick.DEFAULT_HEIGHT) || isPositionInRect(posBaRB,posBr,Brick.DEFAULT_WIDTH,Brick.DEFAULT_HEIGHT)) )
        {
            res = 1;
        }
        else if((!isPositionInRect(posBaRT,posBr,Brick.DEFAULT_WIDTH,Brick.DEFAULT_HEIGHT) && !isPositionInRect(posBaRB,posBr,Brick.DEFAULT_WIDTH,Brick.DEFAULT_HEIGHT)) && (isPositionInRect(posBaLT,posBr,Brick.DEFAULT_WIDTH,Brick.DEFAULT_HEIGHT) || isPositionInRect(posBaLB,posBr,Brick.DEFAULT_WIDTH,Brick.DEFAULT_HEIGHT)) )
        {
            res = 1;
        }
        else if((!isPositionInRect(posBaLT,posBr,Brick.DEFAULT_WIDTH,Brick.DEFAULT_HEIGHT) && !isPositionInRect(posBaRT,posBr,Brick.DEFAULT_WIDTH,Brick.DEFAULT_HEIGHT)) && (isPositionInRect(posBaLB,posBr,Brick.DEFAULT_WIDTH,Brick.DEFAULT_HEIGHT) || isPositionInRect(posBaRB,posBr,Brick.DEFAULT_WIDTH,Brick.DEFAULT_HEIGHT)) )
        {
            res = 2;
        }
        else if((!isPositionInRect(posBaLB,posBr,Brick.DEFAULT_WIDTH,Brick.DEFAULT_HEIGHT) && !isPositionInRect(posBaRB,posBr,Brick.DEFAULT_WIDTH,Brick.DEFAULT_HEIGHT)) && (isPositionInRect(posBaLT,posBr,Brick.DEFAULT_WIDTH,Brick.DEFAULT_HEIGHT) || isPositionInRect(posBaRT,posBr,Brick.DEFAULT_WIDTH,Brick.DEFAULT_HEIGHT)) )
        {
            res = 2;
        }
        else
        {
            res = 0;
        }
        
        return res;
    }
    
    /**
     * Function who say if the number toCompare is between the number a and the number b
     * @param toCompare Number to compare
     * @param a Bound of comparison
     * @param b Bound of comparison
     * @return true if the number is in, false otherwise
     */
   private boolean isIntBetween(float toCompare, float a, float b)
    {
        return (toCompare >= a && toCompare <= b)||(toCompare >= b && toCompare <= a);
    }
   
   /**
    * Function who say if a position is in a rectangle who can be a brick
    * It is used to simplify the algorithm of collision
     * @param posBall Ball's position
     * @param posRect Top left corner position of a brick
     * @param widthRect Brick's width
     * @param heightRect Brick's height
     * @return true if the position is in, false otherwise
 */
private boolean isPositionInRect(Position posBall, Position posRect, int widthRect, int heightRect)
   {
       return (isIntBetween(posBall.getPosX(),posRect.getPosX(),posRect.getPosX()+widthRect) && isIntBetween(posBall.getPosY(), posRect.getPosY(),posRect.getPosY()+heightRect));
   }
}
