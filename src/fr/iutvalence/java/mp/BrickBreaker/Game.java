package fr.iutvalence.java.mp.BrickBreaker;

import java.awt.geom.Rectangle2D;
import java.util.Random;

// TODO (fixed) rewrite comment
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
    public static final int DEFAULT_NUMBER_OF_BRICKS = 15;

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
    
   
    
    public Display getDisplay()
    {
        return display;
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

    /**
     * This is the procedure where the game find its start It's the
     * initialization of the game : a new paddle, a new ball and a new tab of
     * bricks is created, the number of lifes is 3
     * 
     */
    public Game(Display display)
    {
        super();

        int yPositionBricks = Brick.DEFAULT_HEIGHT;
        this.stopGame = false;
        this.currentNumberOfBalls = Game.MAXIMAL_LIVES;

        // TODO (think about it) why not having a constructor with 2 parameters?
        this.theBall = new Ball(new Position(100, 300));
        this.theBall.setTrajectory(new Trajectory(0.5F,0.5F));
        
        // For the tests, the paddle size is the total game size
        this.thePaddle = new Paddle(new Position(0, 0.75F*Game.DEFAULT_MAP_HEIGHT), (int)(0.1F*Game.DEFAULT_MAP_WIDTH));

        this.bricks = new Brick[Game.DEFAULT_NUMBER_OF_BRICKS];
        for (int i = 0; i < Game.DEFAULT_NUMBER_OF_BRICKS; i++)
        {
            this.bricks[i] = new Brick(new Position(i * Brick.DEFAULT_WIDTH, yPositionBricks));
        }
        this.rand = new Random();
        this.currentNumberOfBricks = Game.DEFAULT_NUMBER_OF_BRICKS;
        this.display = display;
        display.initializeDisplay(this.thePaddle);
    }


    /**
     * Main loop of the game, at each loop, the ball move and the collision are tested
     * 
     */
    // TODO (explain) i do not understand how the paddle moves are handled
    //By the mouse (with a thread), if a graphical display is set. If not, the paddle don't move but we are working on ...
    public void play()
    {
        boolean thereWasAcollision = false;
        int collisionSide = 0;

        while (!this.stopGame)
        {
            this.display.displayGameState(this.bricks, this.thePaddle, this.theBall);
            if (!manageCollisionWithGamePanelSides())
            {
                manageCollisionWithPaddle();
            }
            
            Position temp = new Position((float)this.theBall.getCollisionBox().getBox().getX(),(float)this.theBall.getCollisionBox().getBox().getY());
            this.theBall.updatePositions(temp.translate(
                    this.theBall.getTrajectory().getBCoefficient(), this.theBall.getTrajectory().getACoefficient()));

            if (this.currentNumberOfBalls != 0 && this.currentNumberOfBricks == 0)
            {
                onVictory();
            }

            if (!this.stopGame)
            {
                int j;
                thereWasAcollision = false;
                for (j = 0; j < Game.DEFAULT_NUMBER_OF_BRICKS; j++)
                {
                    if (this.bricks[j].getState() != BrickState.DESTROYED_STATE)
                    {
                        collisionSide = isBallInCollisionWithBrick(this.bricks[j]);
                        onCollisionWithBrick(thereWasAcollision, j, collisionSide);
                        if (collisionSide != NO_SIDE_COLLISION)
                            thereWasAcollision = true;
                    }
                }
                // System.out.println(this.theBall.toString());
            }

            try
            {
                Thread.sleep(3);
            }
            catch (InterruptedException e)
            {
                // TODO Auto-generated catch block
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
        if (collisionSide != NO_SIDE_COLLISION)
        {
            this.bricks[indexOfBrick].setState(BrickState.DESTROYED_STATE);
            this.currentNumberOfBricks--;
            if (!thereWasAcollision)
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
    private void onLose()
    {
        if (this.currentNumberOfBalls == 0)
        {
            this.stopGame = true;
            this.display.displayLoss();
        }
        else
        {
            this.currentNumberOfBalls--;
            this.theBall = new Ball(new Position(300, 100));
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
        if (this.theBall.getCollisionBox().getBox().getY() + Ball.DEFAULT_SIZE <= this.thePaddle
                .getCollisionBox().getBox().getY())
        {
            Rectangle2D.Float dest = this.theBall.getCollisionBox().getRectangleFromIntersectionWithOtherCollisionBox(
                    this.thePaddle.getCollisionBox());
            if (dest.getWidth() >= 0 && dest.getHeight() >= 0)
            {
                this.theBall.setTrajectory(new Trajectory(-1 * Tools.chooseRandomBetwwen(0.3F, 1.0F), this.theBall.getTrajectory()
                        .getBCoefficient()));
            }
        }
        else
        {
            onLose();
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
     * 
     */
    public void moveThePaddle(int posX)
    {
        if(posX < Game.DEFAULT_MAP_WIDTH - thePaddle.getWidth()/2 && posX - thePaddle.getWidth()/2>= 0)
            thePaddle.setTopLeftCornerPosition(new Position(posX - thePaddle.getWidth()/2, thePaddle.getCollisionBox().getBox().y));
    }


}
