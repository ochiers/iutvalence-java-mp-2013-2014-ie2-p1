package fr.iutvalence.java.mp.BrickBreaker;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUIDisplay extends JPanel implements Display
{

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
       JFrame window = new JFrame();
       
       this.thePaddle = pad;
       new ThreadMovePaddle(this.thePaddle).start();
       
        window.setSize(Game.DEFAULT_MAP_WIDTH, Game.DEFAULT_MAP_HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(this);
        window.setVisible(true);
        
    }
    
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
            g.fillRect((int)this.bricks[i].getBrickBox().getBox().x, (int)this.bricks[i].getBrickBox().getBox().y, Brick.DEFAULT_WIDTH, Brick.DEFAULT_HEIGHT);
        }
    }
    
    private void paintBall(Graphics g){
        g.setColor(Color.red);
        g.fillOval((int)this.theBall.getBallBox().getBox().x, (int)this.theBall.getBallBox().getBox().y, Ball.DEFAULT_SIZE, Ball.DEFAULT_SIZE);
    }
    
    private void paintPaddle(Graphics g){
        g.setColor(Color.green);
        g.fillRect((int)this.thePaddle.getPaddleBox().getBox().x, (int)this.thePaddle.getPaddleBox().getBox().y, this.thePaddle.getWidth(), Paddle.DEFAULT_HEIGHT);
    }
}
