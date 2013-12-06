package fr.iutvalence.java.mp.BrickBreaker;

import java.awt.geom.Rectangle2D;
import java.util.Random;

/**
 * Define a game, a game is composed of one ball, a paddle and some bricks
 * 
 * @author ochiers soulierc
 * */
public class Game implements UserPolling
{
    /**
     * Width size of the container
     */
    public static int DEFAULT_MAP_WIDTH = 800;

    /**
     * Height size of the container
     */
    public static int DEFAULT_MAP_HEIGHT = 600;

    /**
     * This number is the number of bricks in the level, But it's a temp
     * constant because this number can change depending on the level
     */
    public static final int DEFAULT_NUMBER_OF_BRICKS = 40;

    /**
     * Maximal number of player's lives
     */
    private static final int MAXIMAL_LIVES = 3;

    /**
     * Paddle initial position
     */
    private static final float PADDLE_INITIAL_POSITION = 550.0F;

    /**
     * Number that specify that there is no collision between ball and brick
     */
    private static final int NO_SIDE_COLLISION = 0;

    /**
     * Number that specify a collision between the ball and the left or the
     * right side of a brick
     */
    private static final int COLLISION_LEFT_RIGHT_SIDE = 1;

    /**
     * Number that specify a collision between the ball and the top or the
     * bottom side of a brick
     */
    private static final int COLLISION_TOP_BOTTOM_SIDE = 2;

    /**
     * Number that specify a collision between the ball and a corner of a brick
     */
    private static final int COLLISION_CORNER = 3;

    /**
     * The object who display this game
     */
    private Display display;
    
    // TODO (fixed) write comment
    /**
     * Indicate if the game is paused or not
     */
    private boolean gamePaused;
    
    // TODO (fixed) write comment
    /**
     * Get the display object used to display the game
     * @return The display of the game
     */
    public Display getDisplay()
    {
        return this.display;
    }
 
    /**
     * Number of lives
     */
    private int currentNumberOfBalls;

    /**
     * The ball that shoots the bricks
     */
    private Ball theBall;

    /**
     * The paddle where the ball bounces
     */
    private Paddle thePaddle;

    /**
     * This tab contains all bricks of the game That save their position, their
     * state
     * 
     */
    private Brick[] bricks;

    
    // TODO (fix) looks like a local variable
    /**
     * This variable is a random number to give another direction to the ball
     */
    private Random rand;

    /**
     * Number of brick currently not in state destroyed
     */
    private int currentNumberOfBricks;

    /**
     * Used to stop the game
     */
    private boolean stopGame;

    // TODO (fixed) write comment
    /**
     * The last position of the paddle, it's used to determinate in which direction the paddle is going
     */
    private Position lastPaddlePosition;

    
    private Player thePlayer;
    
    
    /**
     * This is the procedure where the game find its start It's the
     * initialization of the game : a new paddle, a new ball and a new tab of
     * bricks is created, the number of lifes is 3
     * 
     * @param display The display of the game.
     */
    public Game(Display display, Player thePlayer)
    {
        super();

        int yPositionBricks = 150;
        this.stopGame = false;
        this.gamePaused = false;
        this.currentNumberOfBalls = Game.MAXIMAL_LIVES;
       
        this.theBall = new Ball(new Position(100, 300), new Trajectory(0.5F,0.5F));
        
        // For the tests, the paddle size is the total game size
        this.thePaddle = new Paddle(new Position(0, 0.75F*Game.DEFAULT_MAP_HEIGHT), (int)(0.2F*Game.DEFAULT_MAP_WIDTH));

        this.bricks = new Brick[Game.DEFAULT_NUMBER_OF_BRICKS];
        for (int i = 0; i < Game.DEFAULT_NUMBER_OF_BRICKS; i++)
        {
            this.bricks[i] = new Brick(new Position(i * Brick.DEFAULT_WIDTH, yPositionBricks), BrickState.NORMAL_STATE);
        }
        this.rand = new Random();
        this.currentNumberOfBricks = Game.DEFAULT_NUMBER_OF_BRICKS;
        this.display = display;
        this.display.setMovesPaddleNotify(this);
        this.thePlayer = thePlayer;
    }


    /**
     * Main loop of the game, at each loop, the ball move and the collision are tested
     * 
     */
    public void play()
    {
        boolean thereWasAcollision = false;
        int collisionSide = 0;
        this.thePlayer.setNumberOfGamesPlayed();
        while (!this.stopGame)
        {
           this.display.displayGameState(this.bricks, this.thePaddle, this.theBall);

            while(this.gamePaused)// If the game is paused, we do nothing.
            {
                try
                {
                    Thread.sleep(1);
                }
                catch (InterruptedException e){}
            }
            
            
            if (!manageCollisionWithGamePanelSides())
            {
                manageCollisionWithPaddle();
            }
            
            Position temp = new Position((float)this.theBall.getCollisionBox().getBox().getX(),(float)this.theBall.getCollisionBox().getBox().getY());
            this.theBall.updatePosition(temp.translate(
                    this.theBall.getTrajectory().getBCoefficient(), this.theBall.getTrajectory().getACoefficient()));

            if (this.currentNumberOfBalls != 0 && this.currentNumberOfBricks == 0)
            {
                onVictory();
            }
            
            thereWasAcollision = false;
            if (!this.stopGame)
            {
                for (int j = 0; j < Game.DEFAULT_NUMBER_OF_BRICKS; j++)
                {
                    if (this.bricks[j].getState() != BrickState.DESTROYED_STATE)
                    {
                        collisionSide = isBallInCollisionWithBrick(this.bricks[j]);
                       
                        if(collisionSide != NO_SIDE_COLLISION)
                        {
                            onCollisionWithBrick(thereWasAcollision, j, collisionSide);
                            thereWasAcollision = true;
                        }
                    }
                }
            }
            try
            {
                Thread.sleep(3);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

    }

    /**
     * Called when the ball collide a brick
     * 
     * @param thereWasAcollision
     *            true if the ball collide at least two bricks in the same time
     * @param indexOfBrick
     *            index of the brick who is collided
     * @param collisionSide
     *            side collided
     */
    private void onCollisionWithBrick(boolean thereWasAcollision, int indexOfBrick, int collisionSide)
    {
            this.bricks[indexOfBrick].manageBrickStateAfterCollision();
            if( this.bricks[indexOfBrick].getState() == BrickState.DESTROYED_STATE)
                this.currentNumberOfBricks--;
                this.thePlayer.setScore(this.thePlayer.getScore() + 1000);
            
            if(!thereWasAcollision)
            {
                switch (collisionSide)
                {
                case COLLISION_LEFT_RIGHT_SIDE:
                    this.theBall.getTrajectory().reverseBCoefficient();
                    break;
                case COLLISION_TOP_BOTTOM_SIDE:
                    this.theBall.getTrajectory().reverseACoefficient();
                    break;
                case COLLISION_CORNER:
                    this.theBall.getTrajectory().reverseACoefficient();
                    this.theBall.getTrajectory().reverseBCoefficient();
                    break;
                }
            }
    }

    /**
     * Called when the player win the game
     */
    private void onVictory()
    {
        this.display.displayVictory();
        this.stopGame = true;

    }

    /**
     * Called when the player lose the game
     */
    private void onLoose()
    {
        if (this.currentNumberOfBalls == 0)
        {
            this.stopGame = true;
            this.display.displayLoss();
        }
        else
        {
            this.currentNumberOfBalls--;
            this.theBall = new Ball(new Position(300, 100), new Trajectory(0.5F,0.5F));
            pauseOrRestartGame();
        }
    }

    /**
     * Function that says if the ball is in collision with the brick, in the tab
     * of bricks to the index i
     * 
     * @param brick
     *            The brick to compare in the game tab brick
     * @return 0 if no collision, 1 in case of collision with left or right
     *         sides, 2 in case of collision with top or bottom sides
     */
    private int isBallInCollisionWithBrick(Brick brick)
    {
        int result = NO_SIDE_COLLISION;
        Rectangle2D.Float dest = new Rectangle2D.Float();
        dest = this.theBall.getCollisionBox().getRectangleFromIntersectionWithOtherCollisionBox(brick.getCollisionBox());
        if (dest.getWidth() < 0 && dest.getHeight() < 0)
        {
            return NO_SIDE_COLLISION;
        }
        if ((int)dest.getWidth() == 1 && (int)dest.getHeight() == 1)
        {
            result = COLLISION_CORNER;
        }
        else if ((int)dest.getWidth() == 1 && dest.getHeight() > 1)
        {
            result = COLLISION_LEFT_RIGHT_SIDE;
        }
        else if (dest.getWidth() > 1 && (int)dest.getHeight() == 1)
        {
            result = COLLISION_TOP_BOTTOM_SIDE;
        }
        return result;
    }

    /**
     * Method who manages collisions between ball and paddle, if the ball
     * doesn't hit the paddle the player loses
     */
    private void manageCollisionWithPaddle()
    {
        
        if (this.theBall.getCollisionBox().getBox().getY() + this.theBall.getCollisionBox().getBox().getHeight() <= this.thePaddle
                .getCollisionBox().getBox().getY())
        {
            Rectangle2D.Float dest = this.theBall.getCollisionBox().getRectangleFromIntersectionWithOtherCollisionBox(
                    this.thePaddle.getCollisionBox());
            if (dest.getWidth() >= 0 && dest.getHeight() >= 0)
            {
                /* La paddle va vers la droite */
                if (this.thePaddle.getCollisionBox().getBox().getX() - this.lastPaddlePosition.getX() > 0)
                {
                    if( this.theBall.getTrajectory().getBCoefficient() < 0 && (Tools.isFloatBetween((float)this.theBall.getCollisionBox().getBox().getX(), 
                            (float)this.thePaddle.getCollisionBox().getBox().getX()+(float)(this.thePaddle.getCollisionBox().getBox().getWidth()*2/3), 
                            (float)this.thePaddle.getCollisionBox().getBox().getX()+(float)(this.thePaddle.getCollisionBox().getBox().getWidth())) 
                            || (Tools.isFloatBetween((float)(this.theBall.getCollisionBox().getBox().getX())+(float)(this.theBall.getCollisionBox().getBox().getWidth()), 
                                    (float)this.thePaddle.getCollisionBox().getBox().getX()+(float)(this.thePaddle.getCollisionBox().getBox().getWidth()*2/3), 
                                    (float)this.thePaddle.getCollisionBox().getBox().getX()+(float)(this.thePaddle.getCollisionBox().getBox().getWidth())))))
                    {
                        this.theBall.setTrajectory(new Trajectory(-1*this.theBall.getTrajectory().getACoefficient(), -1*this.theBall.getTrajectory().getBCoefficient()));
                    }
                    else
                    {
                        this.theBall.setTrajectory(new Trajectory(-1*Tools.chooseRandomBetwwen(0.2F, 0.8F), this.theBall.getTrajectory().getBCoefficient()));
                    }

                }
                else /* la paddle va vers la gauche */
                {
                    if( this.theBall.getTrajectory().getBCoefficient() > 0 && (Tools.isFloatBetween((float)this.theBall.getCollisionBox().getBox().getX(), 
                            (float)this.thePaddle.getCollisionBox().getBox().getX(), 
                            (float)this.thePaddle.getCollisionBox().getBox().getX()+(float)(this.thePaddle.getCollisionBox().getBox().getWidth())*1/3) 
                            || (Tools.isFloatBetween((float)(this.theBall.getCollisionBox().getBox().getX())+(float)(this.theBall.getCollisionBox().getBox().getWidth()), 
                                    (float)this.thePaddle.getCollisionBox().getBox().getX(), 
                                    (float)this.thePaddle.getCollisionBox().getBox().getX()+(float)(this.thePaddle.getCollisionBox().getBox().getWidth())*1/3))))
                    {
                        this.theBall.setTrajectory(new Trajectory(-1*this.theBall.getTrajectory().getACoefficient(), -1*this.theBall.getTrajectory().getBCoefficient()));
                    }
                    else
                    {
                        this.theBall.setTrajectory(new Trajectory(-1*Tools.chooseRandomBetwwen(0.2F, 0.8F), this.theBall.getTrajectory().getBCoefficient()));
                    }
                }
            }
        }
        else
        {
            onLoose();
        }
    }

    /**
     * Method who manage collision between the ball and the sides of the game
     * panel, change the ball's direction when collided and return true
     * 
     * @return true if the ball hit a side
     */
    private boolean manageCollisionWithGamePanelSides()
    {
        boolean thereIsCollision = false;
        if (!Tools.isFloatBetween((float)this.theBall.getCollisionBox().getBox().getX(), 0, Game.DEFAULT_MAP_WIDTH)
                || !Tools.isFloatBetween((float)this.theBall.getCollisionBox().getBox().getX() + (float)this.theBall.getCollisionBox().getBox().width, 0,
                        Game.DEFAULT_MAP_WIDTH))
        {
            this.theBall.getTrajectory().reverseBCoefficient();
            thereIsCollision = true;
        }
        else if (this.theBall.getCollisionBox().getBox().getY() <= 0)
        {
            this.theBall.getTrajectory().reverseACoefficient();
            thereIsCollision = true;
        }
        return thereIsCollision;
    }


    /**
     * @see fr.iutvalence.java.mp.BrickBreaker.UserPolling#isGamePaused()
     */
    public boolean isGamePaused()
    {
        return this.gamePaused;
    }
    
    
    /**
     * @see fr.iutvalence.java.mp.BrickBreaker.UserPolling#moveThePaddle(int)
     */
    public void moveThePaddle(int posX)
    {
        this.lastPaddlePosition = new Position((float)this.thePaddle.getCollisionBox().getBox().getX(),(float)this.thePaddle.getCollisionBox().getBox().getY());
        
        if(posX < Game.DEFAULT_MAP_WIDTH - this.thePaddle.getWidth()/2 && posX - this.thePaddle.getWidth()/2>= 0)
            this.thePaddle.setTopLeftCornerPosition(new Position(posX - this.thePaddle.getWidth()/2, this.thePaddle.getCollisionBox().getBox().y));
    }


    /**
     * @see fr.iutvalence.java.mp.BrickBreaker.UserPolling#pauseOrRestartGame()
     */
    public void pauseOrRestartGame()
    {
        this.gamePaused = !this.gamePaused;
        
    }
}
