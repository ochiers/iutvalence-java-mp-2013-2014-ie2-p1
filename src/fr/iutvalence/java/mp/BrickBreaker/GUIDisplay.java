package fr.iutvalence.java.mp.BrickBreaker;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author soulierc
 *
 */
public class GUIDisplay extends JPanel implements Display
{
    /**
     * 
     */
    public static float GAME_WIDTH_OFFSET = 10F;
    
    /**
     * 
     */
    public static float GAME_HEIGHT_OFFSET = 10F;

    /**
     * Ratio of the brick's width for the display
     */
    public static float RATIO_WIDTH_BRICK = 0.05F;
    /**
     * Ratio of the brick's height for the display
     */
    public static float RATIO_HEIGHT_BRICK = 0.005F;
    /**
     * Ratio of the ball's size for the display
     */
    public static float RATIO_SIZE_BALL = 0.04F;

    /**
     * Ratio of the paddle's width for the display
     */
    public static float RATIO_WIDTH_PADDLE = 0.03F;
    /**
     * Ratio of the paddle's height for the display
     */
    public static float RATIO_HEIGHT_PADDLE = 0.001F;
    
    private JFrame window;
    
    /**
     * The ball displayed
     */
    private Ball theBall;

    /**
     * The paddle displayed
     */
    private Paddle thePaddle;

    /**
     * The bricks displayed
     * 
     */
    private Brick[] bricks;
    
    
    
    
    /**
     * @see fr.iutvalence.java.mp.BrickBreaker.Display#displayGameState(fr.iutvalence.java.mp.BrickBreaker.Brick[], fr.iutvalence.java.mp.BrickBreaker.Paddle, fr.iutvalence.java.mp.BrickBreaker.Ball)
     */
    public void displayGameState(Brick[] bricks, Paddle thePaddle, Ball theBall)
    {
        this.theBall = theBall;
        this.bricks = bricks;
        this.repaint();
    }


    /**
     * @see fr.iutvalence.java.mp.BrickBreaker.Display#initializeDisplay()
     */
    public void initializeDisplay(Object obj)
    {
       this.window = new JFrame();
       
       this.thePaddle = (Paddle)obj;
       new ThreadMovePaddle(this.thePaddle, this).start();
       
        this.window.setSize(Game.DEFAULT_MAP_WIDTH + 2*(int)this.GAME_WIDTH_OFFSET,Game.DEFAULT_MAP_HEIGHT + 2*(int)this.GAME_HEIGHT_OFFSET);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setContentPane(this);
        this.window.setVisible(true);
        
    }
    
    /**
     * @see fr.iutvalence.java.mp.BrickBreaker.Display#displayVictory()
     */
    public void displayVictory()
    {
    }
    
    /**
     * @see fr.iutvalence.java.mp.BrickBreaker.Display#displayLoss()
     */
    public void displayLoss()
    {
    }
    /**
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.white);
        //On vide l'ecran
        g.fillRect((int)this.GAME_WIDTH_OFFSET, + (int)this.GAME_HEIGHT_OFFSET, (int) (Game.DEFAULT_MAP_WIDTH), Game.DEFAULT_MAP_HEIGHT);
        //On redessine un a un chaque composant de notre partie.
        paintBricks(g);
        paintBall(g);
        paintPaddle(g);
    }
    
    /**
     * @param g
     */
    private void paintBricks(Graphics g)
    {
        g.setColor(Color.blue);
        for(int i=0; i<this.bricks.length; i++)
        {
            if(this.bricks[i].getState() != BrickState.DESTROYED_STATE)
            {
                //A remplacer par l'affichage d'une image
                g.setColor(Color.blue);
                g.fillRect((int)this.bricks[i].getCollisionBox().getBox().x + (int)this.GAME_WIDTH_OFFSET, (int)this.bricks[i].getCollisionBox().getBox().y + (int)this.GAME_HEIGHT_OFFSET, Brick.DEFAULT_WIDTH, Brick.DEFAULT_HEIGHT);
                
            }
    
        }
    }
    private void paintBall(Graphics g){
        g.setColor(Color.red);
        g.fillOval((int)this.theBall.getCollisionBox().getBox().x + (int)this.GAME_WIDTH_OFFSET, (int)this.theBall.getCollisionBox().getBox().y + (int)this.GAME_HEIGHT_OFFSET, (int)theBall.getCollisionBox().getBox().width,  (int)theBall.getCollisionBox().getBox().width);
    }
    
    private void paintPaddle(Graphics g){
        g.setColor(Color.green);
        g.fillRect((int)this.thePaddle.getCollisionBox().getBox().x + (int)this.GAME_WIDTH_OFFSET, (int)this.thePaddle.getCollisionBox().getBox().y + (int)this.GAME_HEIGHT_OFFSET, this.thePaddle.getWidth(), Paddle.DEFAULT_HEIGHT);
    }
}
