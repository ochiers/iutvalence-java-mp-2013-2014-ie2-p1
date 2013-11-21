package fr.iutvalence.java.mp.BrickBreaker;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.MemoryImageSource;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
    public static int GAME_WIDTH_OFFSET = 0;
    
    /**
     * 
     */
    public static int GAME_HEIGHT_OFFSET = 0;

    /**
     * Ratio for x position of components
     */
    private float xRatioGeneralDisplay;
    /**
     * Ratio for y position of components
     */
    private float yRatioGeneralDisplay;

    
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
        int[] pixels = new int[16 * 16];
        Image image = Toolkit.getDefaultToolkit().createImage(new MemoryImageSource(16, 16, pixels, 0, 16));
        Cursor transparentCursor = Toolkit.getDefaultToolkit().createCustomCursor(image, new Point(0, 0), "invisibleCursor");
        
        
        this.window = new JFrame();
        this.thePaddle = (Paddle)obj;
        this.window.setCursor(transparentCursor);
        
        this.window.setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
        this.setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
        this.window.setResizable(false);
        this.window.setContentPane(this);
        
        this.xRatioGeneralDisplay =  (float)window.getContentPane().getSize().width / (float)Game.DEFAULT_MAP_WIDTH;
        this.yRatioGeneralDisplay =  (float)window.getContentPane().getSize().height / (float)Game.DEFAULT_MAP_HEIGHT;
        
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setVisible(true);
        
    }
    
    /**
     * @see fr.iutvalence.java.mp.BrickBreaker.Display#displayVictory()
     */
    public void displayVictory()
    {
        Image win = null;
        try {
            win = ImageIO.read(new File("G:/Images/Win.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        this.getGraphics().drawImage(win,0,0,null);
        
    }
    
    /**
     * @see fr.iutvalence.java.mp.BrickBreaker.Display#displayLoss()
     */
    public void displayLoss()
    {
        /*Image loss = null;
        try {
            loss = ImageIO.read(new File("G:/Images/Screamer_by_Meshmonkey.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        this.getGraphics().drawImage(loss,0,0,null);*/
    }
    /**
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    public void paintComponent(Graphics g)
    {
        
        int xGame = (int)(GUIDisplay.GAME_WIDTH_OFFSET * this.xRatioGeneralDisplay) ;
        int yGame = (int)(GUIDisplay.GAME_HEIGHT_OFFSET * this.yRatioGeneralDisplay);
        int wGame = (int)(this.window.getWidth() - 2*GUIDisplay.GAME_WIDTH_OFFSET);
        int hGame = (int)(this.window.getHeight() - 2*GUIDisplay.GAME_HEIGHT_OFFSET);
        
        //System.out.println(wGame + " " + hGame);
        
        g.setColor(Color.white);
        //On vide l'ecran
        g.fillRect(xGame, yGame, wGame, hGame);
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
        int xBrick;
        int yBrick;
        int wBrick;
        int hBrick;
        
        g.setColor(Color.blue);
        for(int i=0; i<this.bricks.length; i++)
        {
            if(this.bricks[i].getState() != BrickState.DESTROYED_STATE)
            {
                xBrick = (int)((this.bricks[i].getCollisionBox().getBox().x + GUIDisplay.GAME_WIDTH_OFFSET) *this.xRatioGeneralDisplay);
                yBrick = (int)((this.bricks[i].getCollisionBox().getBox().y + GUIDisplay.GAME_HEIGHT_OFFSET)*this.yRatioGeneralDisplay);
                wBrick = (int)(Brick.DEFAULT_WIDTH *this.xRatioGeneralDisplay);
                hBrick = (int)(Brick.DEFAULT_HEIGHT*this.yRatioGeneralDisplay);
                //A remplacer par l'affichage d'une image
                Image brick = null;
                
                try {
                    brick = ImageIO.read(new File("G:/Images/brick.png"));
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
                g.drawImage(brick, xBrick,yBrick,wBrick,hBrick, null);
                
            }
    
        }
    }
    private void paintBall(Graphics g){
        
        int xball = (int)((this.theBall.getCollisionBox().getBox().x )*this.xRatioGeneralDisplay);
        int yball = (int)((this.theBall.getCollisionBox().getBox().y )*this.yRatioGeneralDisplay);
        int tball = (int)(theBall.getCollisionBox().getBox().width *this.xRatioGeneralDisplay);
        
        g.setColor(Color.red);
        g.fillOval(xball, yball, tball, tball);
    }
    
    private void paintPaddle(Graphics g){
        
        
        int xPad = (int)((this.thePaddle.getCollisionBox().getBox().x + GUIDisplay.GAME_WIDTH_OFFSET)*this.xRatioGeneralDisplay);
        int yPad = (int)((this.thePaddle.getCollisionBox().getBox().y + GUIDisplay.GAME_HEIGHT_OFFSET)*this.yRatioGeneralDisplay);
        int wPad = (int)(this.thePaddle.getWidth()*this.xRatioGeneralDisplay);
        int hPad = (int)(Paddle.DEFAULT_HEIGHT);
        
        g.setColor(Color.green);
        g.fillRect(xPad, yPad, wPad, hPad);
    }
}
