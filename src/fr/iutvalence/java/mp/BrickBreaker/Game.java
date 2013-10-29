package fr.iutvalence.java.mp.BrickBreaker;

import java.awt.geom.Rectangle2D;
import java.util.Random;

/**
 * Called when a game is created
 * 
 * @author ochiers soulierc
 * */
public class Game
{
    /**
     * Width size of the container
     */
    public static int DEFAULT_MAP_WIDTH = 600;

    /**
     * Height size of the container
     */
    public static int DEFAULT_MAP_HEIGHT = 400;

    /**
     * This number is the number of bricks in the level, But it's a temp
     * constant because this number can change depending on the level
     */
    public static final int DEFAULT_NUMBER_OF_BRICKS = 2;

    /**
     * Maximal number of player's lives
     */
    private static final int MAXIMAL_LIVES = 3;

    /**
     * Paddle initial position
     */
    private static final float PADDLE_INITIAL_POSITION = 250.0F;

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
    public Game()
    {
        super();
        
        // TODO (fixed) declare hard-coded values as constants
        int yPositionBricks = Brick.DEFAULT_HEIGHT;
        this.stopGame = false;
        this.currentNumberOfBalls = Game.MAXIMAL_LIVES;

        this.theBall = new Ball(Game.PADDLE_INITIAL_POSITION / 2, Game.PADDLE_INITIAL_POSITION / 2);

        //For the tests, the paddle size is the total game size
        this.thePaddle = new Paddle(new Position(0,386), Game.DEFAULT_MAP_WIDTH);

        this.bricks = new Brick[Game.DEFAULT_NUMBER_OF_BRICKS];
        for (int i = 0; i < Game.DEFAULT_NUMBER_OF_BRICKS; i++)
        {
            this.bricks[i] = new Brick(new Position (i * Brick.DEFAULT_WIDTH, yPositionBricks));
        }
        this.rand = new Random();
        
        
        // TODO (fixed) use constants
        this.currentNumberOfBricks = Game.DEFAULT_NUMBER_OF_BRICKS;

    }

    // TODO (fixed) simplify this method by moving some inner code in outside
    // private methods
    /**
     * method who move the ball and take care of collisions
     */
    public void play()
    {
        boolean thereWasAcollision = false;
        int collisionSide = 0;
        
        while(!this.stopGame)
        {
            printInConsole(true);
            if (!manageCollisionWithGamePanelSides())
            {
                manageCollisionWithPaddle();
            }

            this.theBall.updatePositions(this.theBall.getTopLeftCornerPosition().translate(
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
                //System.out.println(this.theBall.toString());
            }
            
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
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
    // TODO (fixed) if this method is called when a collision occurs, why passing a boolean as parameter
    // that indicates if there was a collision?
    //Parcequ'on parcourt le tableau de briques pour detecter les collisions, si la balle entre en collsion avec une premiere brique
    //on inverse le coefficient de la trajectoire, puis on test la collsion sur une deuxieme brique, si il y a aussi une collision on inverse le coefficient :
    // au final on a rien fait puisqu'on a inversé deux fois le coefficient, et la balle va continuer comme elle venue, 
    //ce n'est pas ce que l'on veut. Il faut donc un booléen permettant de savoir si il y a déjà eu collision pour empècher d'inverser le coefficient plusieurs fois
    private void onCollisionWithBrick(boolean thereWasAcollision, int indexOfBrick, int collisionSide)
    {
        if (collisionSide != NO_SIDE_COLLISION)
        {
            this.bricks[indexOfBrick].setState(BrickState.DESTROYED_STATE);
            this.currentNumberOfBricks--;
            if (!thereWasAcollision)
            {
                System.out.println("Brick(s) hited");
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
        System.out.println("GAGNE !");
        this.stopGame = true;
    }

    /**
     * Called when the player lose the game
     */
    private void onLose()
    {
        if (this.currentNumberOfBalls == 0)
        {
            System.out.println("perdu");
            this.stopGame = true;
        }
        else
        {
            this.currentNumberOfBalls--;
            this.theBall = new Ball(Game.PADDLE_INITIAL_POSITION, Game.PADDLE_INITIAL_POSITION);
        }
    }

    // TODO (fixed) rewrite comment (parameter types have changed)
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
        if (dest.getWidth() == 1 && dest.getHeight() == 1)
        {
            result = COLLISION_CORNER;
        }
        // TODO (fix) simplify
        //I don't know to simplify ...
        else if (dest.getWidth() == 1 && dest.getHeight() > 1)
        {
            result = COLLISION_LEFT_RIGHT_SIDE;
        }
        
        // TODO (fix) simplify
        //I don't know to simplify ...
        else if (dest.getWidth() > 1 && dest.getHeight() == 1)
        {
            result = COLLISION_TOP_BOTTOM_SIDE;
        }
        return result;
    }

    /**
     * Method who manages collisions between ball and paddle, if the ball doesn't
     * hit the paddle the player loses
     */
    private void manageCollisionWithPaddle()
    {
        if (this.theBall.getTopLeftCornerPosition().getY() + this.theBall.DEFAULT_SIZE <= this.thePaddle.getTopLeftCornerPosition().getY())
        {
            Rectangle2D.Float dest = this.theBall.getCollisionBox().getRectangleFromIntersectionWithOtherCollisionBox(
                    this.thePaddle.getCollisionBox());
            if (dest.getWidth() >= 0 && dest.getHeight() >= 0)
            {
                this.theBall.setTrajectory(new Trajectory(-1 * this.rand.nextFloat(), this.theBall.getTrajectory()
                        .getBCoefficient()));
                System.out.println("Paddle hited");
            }
        }
        else
        {
            onLose();
        }
    }

    /**
     * Method who manage collsion between the ball and the sides of the game
     * panel, change the ball's direction when collided and return true
     * 
     * @return true if the ball hit a side
     */
    private boolean manageCollisionWithGamePanelSides()
    {
        boolean thereIsCollision = false;
        if (!isFloatBetween(this.theBall.getTopLeftCornerPosition().getX(), 0, Game.DEFAULT_MAP_WIDTH)
                || !isFloatBetween(this.theBall.getTopLeftCornerPosition().getX() + Ball.DEFAULT_SIZE, 0,
                        Game.DEFAULT_MAP_WIDTH))
        {
            this.theBall.getTrajectory().reverseBCoefficient();
            System.out.println("Game Side Left or Right hited");
            thereIsCollision = true;
        }
        else if (this.theBall.getTopLeftCornerPosition().getY() <= 0)
        {
            this.theBall.getTrajectory().reverseACoefficient();
            System.out.println("Game Side Top or Bottom hited");
            thereIsCollision = true;
        }
        return thereIsCollision;
    }

    /**
     * Function who say if the number toCompare is between the number a and the
     * number b
     * 
     * @param toCompare
     *            Number to compare
     * @param a
     *            Bound of comparison
     * @param b
     *            Bound of comparison
     * @return true if the number is in, false otherwise
     */
    private boolean isFloatBetween(float toCompare, float a, float b)
    {
        return (toCompare >= a && toCompare <= b) || (toCompare >= b && toCompare <= a);
    }

    
    /**
     * Method who build a line of the game, in order to be printed in console
     * @param pos
     * @param increment
     * @return
     */
    public String printLineInConsole(float pos, float increment)
    {
        String res = "#";
        boolean aBrickIsWritten = false;
        int count = 0;
        for(int k =0; k < Game.DEFAULT_MAP_WIDTH; k += Game.DEFAULT_MAP_WIDTH/(2*Ball.DEFAULT_SIZE))
        {
            if(count < Game.DEFAULT_NUMBER_OF_BRICKS)
            {
                if(isFloatBetween(this.bricks[count].getTopLeftCornerPosition().getY(), pos, pos + increment) ||
                        isFloatBetween(this.bricks[count].getTopLeftCornerPosition().getY() + Brick.DEFAULT_WIDTH, pos, pos + increment))
                {
                    aBrickIsWritten = true;
                    if(this.bricks[count].getState() != BrickState.DESTROYED_STATE)
                        res += "N";
                    else
                        res += "X";
                }
                else
                {
                    res +=  " " ;
                }
                count++;
            }
            else
            {
                res += " ";
            }
            
            
        }
        if(!aBrickIsWritten && isFloatBetween(theBall.getTopLeftCornerPosition().getY(), pos, pos + increment))
        {
            res = theBall.stringBallInConsole();
        }
        
        if(isFloatBetween(thePaddle.getTopLeftCornerPosition().getY(), pos, pos + increment))
        {
            res = thePaddle.stringPaddleInConsole();
        }
            
        return res;
    }
    
    
    
    /**
     * Print the game in the console
     * @param isGraphic
     */
    public void printInConsole(boolean isGraphic)
    {
        if(isGraphic)
        {
            System.out.print("#");
            for(int i = 0; i < Game.DEFAULT_MAP_WIDTH; i += Game.DEFAULT_MAP_WIDTH/(2*Ball.DEFAULT_SIZE))
            {
                System.out.print("#");
            }
            System.out.println();
           for(int j =0; j < Game.DEFAULT_MAP_HEIGHT; j+= Game.DEFAULT_MAP_HEIGHT/(2*Ball.DEFAULT_SIZE)) 
            {   
               System.out.println(printLineInConsole(j,Game.DEFAULT_MAP_HEIGHT/(2*Ball.DEFAULT_SIZE)));
            }
        }
        else
        {
            System.out.println("Ball" + theBall);
            System.out.println("Paddle" + thePaddle);

            
        }
    }
    
    
    
}
