package fr.iutvalence.java.mp.BrickBreaker;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUIDisplay extends JPanel implements Display
{

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
    public void initializeDisplay(Paddle pad)
    {
       this.window = new JFrame();
       
       this.thePaddle = pad;
       new ThreadMovePaddle(this.thePaddle).start();
       
        this.window.setSize(Game.DEFAULT_MAP_WIDTH, Game.DEFAULT_MAP_HEIGHT);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setContentPane(this);
        this.window.setVisible(true);
        
    }
    
    /**
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.white);
        g.fillRect(0, 0, Game.DEFAULT_MAP_WIDTH, Game.DEFAULT_MAP_HEIGHT);
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
                g.fillRect((int)this.bricks[i].getCollisionBox().getBox().x, (int)this.bricks[i].getCollisionBox().getBox().y, Brick.DEFAULT_WIDTH, Brick.DEFAULT_HEIGHT);
                g.setColor(Color.black);
                g.fillRect((int)this.bricks[i].getCollisionBox().getBox().x, (int)this.bricks[i].getCollisionBox().getBox().y, Brick.DEFAULT_WIDTH, Brick.DEFAULT_HEIGHT/10);
                g.fillRect((int)this.bricks[i].getCollisionBox().getBox().x, (int)this.bricks[i].getCollisionBox().getBox().y, Brick.DEFAULT_WIDTH/10, Brick.DEFAULT_HEIGHT); 
                g.fillRect((int)this.bricks[i].getCollisionBox().getBox().x + (Brick.DEFAULT_WIDTH - Brick.DEFAULT_WIDTH/10), (int)this.bricks[i].getCollisionBox().getBox().y, Brick.DEFAULT_WIDTH/10, Brick.DEFAULT_HEIGHT);
                g.fillRect((int)this.bricks[i].getCollisionBox().getBox().x , (int)this.bricks[i].getCollisionBox().getBox().y + (Brick.DEFAULT_HEIGHT - Brick.DEFAULT_HEIGHT/10), Brick.DEFAULT_WIDTH, Brick.DEFAULT_HEIGHT/10);
            }
    
        }
    }
    private void paintBall(Graphics g){
        g.setColor(Color.red);
        g.fillOval((int)this.theBall.getCollisionBox().getBox().x, (int)this.theBall.getCollisionBox().getBox().y, (int)(this.window.getWidth()*GUIDisplay.RATIO_SIZE_BALL),  (int)(this.window.getHeight()*GUIDisplay.RATIO_SIZE_BALL));
    }
    
    private void paintPaddle(Graphics g){
        g.setColor(Color.green);
        g.fillRect((int)this.thePaddle.getCollisionBox().getBox().x, (int)this.thePaddle.getCollisionBox().getBox().y, this.thePaddle.getWidth(), Paddle.DEFAULT_HEIGHT);
    }
}
