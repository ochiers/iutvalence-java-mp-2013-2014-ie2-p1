package fr.iutvalence.java.mp.BrickBreaker;

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
    private static final int WIDTH_OF_GAME_PANEL = 500;

    /**
     * Height size of the container
     */
    private static final int HEIGHT_OF_GAME_PANEL = 440;

    // TODO (fixed) comment is confusing
    // default number of bricks?
    /**
     * This number is the number of bricks in the level, But it's a temp
     * constant because this number can change depending on the level
     */
    public static final int DEFAULT_NUMBER_OF_BRICKS = 10;

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
    private static final int NO_SIDE_COLLISION = 1;
    
    /**
     * Number that specify a collision between the ball and the left or the right side of a brick
     */
    private static final int COLLISION_LEFT_RIGHT_SIDE = 1;
    
    /**
     * Number that specify a collision between the ball and the top or the bottom side of a brick
     */
    private static final int COLLISION_TOP_BOTTOM_SIDE = 2;
        
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
     * This is the procedure where the game find its start It's the
     * initialization of the game : a new paddle, a new ball and a new tab of
     * bricks is created, the number of lifes is 3
     * 
     */
    public Game()
    {
        super();
        int yPositionBricks = 44;
        this.currentNumberOfBalls = Game.MAXIMAL_LIVES;

        this.theBall = new Ball(Game.PADDLE_INITIAL_POSITION / 2, Game.PADDLE_INITIAL_POSITION / 2);

        this.thePaddle = new Paddle(Game.PADDLE_INITIAL_POSITION, Paddle.PADDLE_SIZE);

        this.bricks = new Brick[Game.DEFAULT_NUMBER_OF_BRICKS];
        for (int i = 0; i < Game.DEFAULT_NUMBER_OF_BRICKS; i++)
        {
            this.bricks[i] = new Brick(i * Brick.DEFAULT_WIDTH, yPositionBricks);
        }
        this.rand = new Random();
        

    }

    // TODO (fix) simplify this method by moving some inner code in outside
    // private methods
    /**
     * method who move the ball and take care of the game's outlines
     */
    public void go()
    {
        int nbMaxBallMoves = 1000;
        boolean stop = false;
        boolean thereWasAcollision = false;
        int collisionSide = 0;

        for (int i = 0; i < nbMaxBallMoves; i++)
        {
            /**
             * 
             */
            if (!isFloatBetween(this.theBall.getTopLeftCornerPosition().getPosX(), 0, Game.WIDTH_OF_GAME_PANEL)
                    || !isFloatBetween(this.theBall.getTopLeftCornerPosition().getPosX() + Ball.BALL_SIZE, 0,
                            Game.WIDTH_OF_GAME_PANEL))
            {
                this.theBall.setB(-1 * this.theBall.getB());
            }
            /*
             * Si l'ordonnée de la balle est supérieur au bord inférieur du jeu
             * ou si l'ordonnée de la balle est inférieur ou égale au bord
             * supérieur du jeu alors on change l'angle de la trajectoire
             */
            else if (this.theBall.getTopLeftCornerPosition().getPosY() <= 0)
            {
                this.theBall.setA(-1 * this.theBall.getA());
            }
            else if (this.theBall.getTopLeftCornerPosition().getPosY() + Ball.BALL_SIZE >= Paddle.INITIAL_Y_POSITION)
            {
                if (isFloatBetween(this.theBall.getTopLeftCornerPosition().getPosX(), this.thePaddle.getPosition()
                        .getPosX(), this.thePaddle.getPosition().getPosX() + this.thePaddle.getSize())
                        || isFloatBetween(this.theBall.getTopLeftCornerPosition().getPosX() + Ball.BALL_SIZE,
                                this.thePaddle.getPosition().getPosX(), this.thePaddle.getPosition().getPosX()
                                        + this.thePaddle.getSize()))
                {
                    this.theBall.setA(-1 * this.rand.nextFloat());
                }
                else
                {
                    System.out.println("perdu");
                    i = nbMaxBallMoves;
                }
            }

            this.theBall.setPositionsFromTopLeftCorner(this.theBall.getTopLeftCornerPosition().getPosX() + this.theBall.getB(),
                    this.theBall.getTopLeftCornerPosition().getPosY() + this.theBall.getA());

            if (this.currentNumberOfBalls != 0 && this.currentNumberOfBricks == 0)
            {
                stop = true;
                System.out.println("GAGNE !");
            }
            int j;
            thereWasAcollision = false;
            for (j = 0; j < 10; j++)
            {
                if (this.bricks[j].getState() != Brick.DESTROYED_STATE)
                {
                    collisionSide = isBallInCollisionWithBrick(j);
                    if (collisionSide != 0)
                    {
                        this.bricks[j].setState(Brick.DESTROYED_STATE);
                        this.currentNumberOfBricks--;
                        if (!thereWasAcollision)
                        {
                            switch (collisionSide)
                            {
                            case 1:
                                this.theBall.setB(-1 * this.theBall.getB());
                                break;
                            case 2:
                                this.theBall.setA(-1 * this.theBall.getA());
                                break;
                            }
                        }
                        thereWasAcollision = true;
                    }
                }
            }
            System.out.println(this.theBall.toString());
        }
        
    }

    // TODO (fixed) fix comment, return type is not a boolean
    // TODO (fixed) declare constants for returned values
    /**
     * Function who say if the ball is in collision with the brick, in the tab
     * of bricks to the index i
     * 
     * @param i
     *            Index of the brick to compare in the game tab brick
     * @return 
     *            0 if no collision, 1 in case of collision with left or right sides, 2 in case of collision with top or bottom sides
     */
    private int isBallInCollisionWithBrick(int i)
    {
        int res;
        Position posBaLT = this.theBall.getTopLeftCornerPosition();
        Position posBaLB = this.theBall.getBottomLeftCornerPosition();
        Position posBaRT = this.theBall.getTopRightCornerPosition();
        Position posBaRB = this.theBall.getBottomRightCornerPosition();
        Position posBr = this.bricks[i].getBrickPosition();

        if ((!isPositionInRect(posBaLT, posBr, Brick.DEFAULT_WIDTH, Brick.DEFAULT_HEIGHT) && !isPositionInRect(posBaLB,
                posBr, Brick.DEFAULT_WIDTH, Brick.DEFAULT_HEIGHT))
                && (isPositionInRect(posBaRT, posBr, Brick.DEFAULT_WIDTH, Brick.DEFAULT_HEIGHT) || isPositionInRect(
                        posBaRB, posBr, Brick.DEFAULT_WIDTH, Brick.DEFAULT_HEIGHT)))
        {
            res = Game.COLLISION_LEFT_RIGHT_SIDE;
        }
        else if ((!isPositionInRect(posBaRT, posBr, Brick.DEFAULT_WIDTH, Brick.DEFAULT_HEIGHT) && !isPositionInRect(
                posBaRB, posBr, Brick.DEFAULT_WIDTH, Brick.DEFAULT_HEIGHT))
                && (isPositionInRect(posBaLT, posBr, Brick.DEFAULT_WIDTH, Brick.DEFAULT_HEIGHT) || isPositionInRect(
                        posBaLB, posBr, Brick.DEFAULT_WIDTH, Brick.DEFAULT_HEIGHT)))
        {
            res = Game.COLLISION_LEFT_RIGHT_SIDE;
        }
        else if ((!isPositionInRect(posBaLT, posBr, Brick.DEFAULT_WIDTH, Brick.DEFAULT_HEIGHT) && !isPositionInRect(
                posBaRT, posBr, Brick.DEFAULT_WIDTH, Brick.DEFAULT_HEIGHT))
                && (isPositionInRect(posBaLB, posBr, Brick.DEFAULT_WIDTH, Brick.DEFAULT_HEIGHT) || isPositionInRect(
                        posBaRB, posBr, Brick.DEFAULT_WIDTH, Brick.DEFAULT_HEIGHT)))
        {
            res = Game.COLLISION_TOP_BOTTOM_SIDE;
        }
        else if ((!isPositionInRect(posBaLB, posBr, Brick.DEFAULT_WIDTH, Brick.DEFAULT_HEIGHT) && !isPositionInRect(
                posBaRB, posBr, Brick.DEFAULT_WIDTH, Brick.DEFAULT_HEIGHT))
                && (isPositionInRect(posBaLT, posBr, Brick.DEFAULT_WIDTH, Brick.DEFAULT_HEIGHT) || isPositionInRect(
                        posBaRT, posBr, Brick.DEFAULT_WIDTH, Brick.DEFAULT_HEIGHT)))
        {
            res = Game.COLLISION_TOP_BOTTOM_SIDE;
        }
        else
        {
            res = Game.NO_SIDE_COLLISION;
        }

        return res;
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
    // TODO (fixed) rename this method (i see no int)
    private boolean isFloatBetween(float toCompare, float a, float b)
    {
        return (toCompare >= a && toCompare <= b) || (toCompare >= b && toCompare <= a);
    }

    /**
     * Function who say if a position is in a rectangle who can be a brick It is
     * used to simplify the algorithm of collision
     * 
     * @param posBall
     *            Ball's position
     * @param posRect
     *            Top left corner position of a brick
     * @param widthRect
     *            Brick's width
     * @param heightRect
     *            Brick's height
     * @return true if the position is in, false otherwise
     */
    // TODO (fix) move this method where it has to be
    private boolean isPositionInRect(Position posBall, Position posRect, int widthRect, int heightRect)
    {
        return (isFloatBetween(posBall.getPosX(), posRect.getPosX(), posRect.getPosX() + widthRect) && isFloatBetween(
                posBall.getPosY(), posRect.getPosY(), posRect.getPosY() + heightRect));
    }
}
