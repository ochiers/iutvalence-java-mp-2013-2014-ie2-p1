package fr.iutvalence.java.mp.BrickBreaker;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.MemoryImageSource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// TODO (fixed) finish writing comment
/**
 * This class is used to display the game by graphics
 * @author soulierc
 * 
 */
public class GUIDisplay extends JPanel implements Display, MouseMotionListener, MouseListener, ActionListener
{

    /**
     * Tab of images who will used for the display, they are loaded one time in
     * order to release IOs
     */
    private final Image[] images;

    /**
     * Ratio for x position of components
     */
    private float xRatioGeneralDisplay;

    /**
     * Ratio for y position of components
     */
    private float yRatioGeneralDisplay;

    // TODO (fixed) write comment
    /**
     * The window where the game is displayed
     */
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
    private List<Brick> bricks;
    
    
    private UserPolling movesPaddleNotify;
    
    public String state;

    public void setMovesPaddleNotify(UserPolling movesPaddleNotify)
    {
        this.movesPaddleNotify = movesPaddleNotify;
        
    }

    /**
     * Initialize the display
     */
    public GUIDisplay()
    {
        this.state = "builded";
        this.images = new Image[7];
        this.window = new JFrame();
        /* ---------- Hide the cursor ---------- */
        /*
         * 
         * int[] pixels = new int[16 * 16]; Image image =
         * Toolkit.getDefaultToolkit().createImage(new MemoryImageSource(16, 16,
         * pixels, 0, 16)); Cursor transparentCursor =
         * Toolkit.getDefaultToolkit().createCustomCursor(image, new Point(0,
         * 0), "invisibleCursor"); this.window.setCursor(transparentCursor);
         */

        /* ---------- Set up of the JFrame ------------- */

        this.window.setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
        this.setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
        this.window.setResizable(false);
        this.window.setContentPane(this);

        this.xRatioGeneralDisplay = (float) this.window.getContentPane().getSize().width / (float) Game.DEFAULT_MAP_WIDTH;
        //System.out.println(xRatioGeneralDisplay);
        this.yRatioGeneralDisplay = (float) this.window.getContentPane().getSize().height / (float) Game.DEFAULT_MAP_HEIGHT;

        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setVisible(true);

        /* --------- Loading images who will be displayed ---------- */

        try
        {
            this.images[0] = ImageIO.read(new File("resources/images/brickNormal.png"));
            this.images[1] = ImageIO.read(new File("resources/images/brickTouched.png"));
            this.images[2] = ImageIO.read(new File("resources/images/brickDamaged.png"));
            this.images[3] = ImageIO.read(new File("resources/images/Win.png"));
            this.images[4] = ImageIO.read(new File("resources/images/Loss.jpg"));
            this.images[5] = null;
            this.images[6] = null;

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
    }

    /**
     * @see fr.iutvalence.java.mp.BrickBreaker.Display#displayGameState(fr.iutvalence.java.mp.BrickBreaker.Brick[],
     *      fr.iutvalence.java.mp.BrickBreaker.Paddle,
     *      fr.iutvalence.java.mp.BrickBreaker.Ball)
     */
    public void displayGameState(List<Brick> bricks, Paddle thePaddle, Ball theBall)
    {
        
        this.thePaddle = thePaddle;
        this.theBall = theBall;
        this.bricks = bricks;
        this.repaint();
    }

    /**
     * @see fr.iutvalence.java.mp.BrickBreaker.Display#displayVictory()
     */
    public void displayVictory()
    {
        this.getGraphics().drawImage(this.images[3], 0, 0, this.window.getContentPane().getSize().width,
                this.window.getContentPane().getSize().height, null);
    }

    /**
     * @see fr.iutvalence.java.mp.BrickBreaker.Display#displayLoss()
     */
    public void displayLoss()
    {
        this.getGraphics().drawImage(this.images[4], 0, 0, this.window.getContentPane().getSize().width,
                this.window.getContentPane().getSize().height, null);
    }

    /**
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    public void paintComponent(Graphics g)
    {

        int xGame = 0;
        int yGame = 0;
        int wGame = (int) (this.window.getWidth());
        int hGame = (int) (this.window.getHeight());

        // Clear screen :
        g.setColor(Color.white);
        g.fillRect(xGame, yGame, wGame, hGame);

        // On repaint of all game components
        if (this.bricks != null) paintBricks(g);
        if (this.theBall != null) paintBall(g);
        if (this.thePaddle != null) paintPaddle(g);
    }

    // TODO (fixed) finish writing comment
    /**
     * Method who paint the tab of bricks in the window
     */
    private void paintBricks(Graphics g)
    {
        int xBrick;
        int yBrick;
        int wBrick;
        int hBrick;
        
        g.setColor(Color.blue);
        for (int i = 0; i < this.bricks.size(); i++)
        {
            if (this.bricks.get(i).getState() != BrickState.DESTROYED_STATE)
            {
                xBrick = (int) ((this.bricks.get(i).getCollisionBox().getBox().x) * this.xRatioGeneralDisplay);
                yBrick = (int) ((this.bricks.get(i).getCollisionBox().getBox().y) * this.yRatioGeneralDisplay);
                wBrick = (int) (Brick.DEFAULT_WIDTH * this.xRatioGeneralDisplay);
                hBrick = (int) (Brick.DEFAULT_HEIGHT * this.yRatioGeneralDisplay);

                switch (this.bricks.get(i).getState())
                {
                case DAMAGED_STATE:
                    g.drawImage(this.images[2], xBrick, yBrick, wBrick, hBrick, null);
                    break;
                case NORMAL_STATE:
                    g.drawImage(this.images[0], xBrick, yBrick, wBrick, hBrick, null);
                    break;
                case TOUCHED_STATE:
                    g.drawImage(this.images[1], xBrick, yBrick, wBrick, hBrick, null);
                    break;
                default:
                    break;

                }
            }
        }
    }

    // TODO (fixed) write comment
    /**
     * Method who paint the ball in the window
     */
    private void paintBall(Graphics g)
    {

        
        //System.out.println(this.theBall.getCollisionBox().getBox().x);
        
        if (this.theBall == null) System.out.println("theBall is null");
        if (this.theBall.getCollisionBox() == null) System.out.println("theBall.getCollisionBox() is null");
        if (this.theBall.getCollisionBox().getBox() == null) System.out.println("theBall.getCollisionBox().getBox() is null");
        int xball = (int) ((this.theBall.getCollisionBox().getBox().getX()) * this.xRatioGeneralDisplay);
                
        int yball = (int) ((this.theBall.getCollisionBox().getBox().y) * this.yRatioGeneralDisplay);
        int tball = (int) (this.theBall.getCollisionBox().getBox().width * this.xRatioGeneralDisplay);

        g.setColor(Color.red);
        g.fillOval(xball, yball, tball, tball);
    }

    // TODO (fixed) write comment
    /**
     * Method who paint the paddle in the window
     */
    private void paintPaddle(Graphics g)
    {

        
        int xPad = (int) ((this.thePaddle.getCollisionBox().getBox().x) * this.xRatioGeneralDisplay);
        int yPad = (int) ((this.thePaddle.getCollisionBox().getBox().y) * this.yRatioGeneralDisplay);
        int wPad = (int) (this.thePaddle.getWidth() * this.xRatioGeneralDisplay);
        int hPad = (int) (Paddle.DEFAULT_HEIGHT);

        g.setColor(Color.green);
        g.fillRect(xPad, yPad, wPad, hPad);
    }


    @Override
    public void mouseMoved(MouseEvent e)
    {
        if(this.movesPaddleNotify != null)
        this.movesPaddleNotify.moveThePaddle(e.getX());
    }


    @Override
    public void mouseClicked(MouseEvent e)
    {
       // if(this.movePaddle.isGamePaused())
        if(this.movesPaddleNotify != null)
        this.movesPaddleNotify.pauseOrRestartGame();
        
    }


    @Override
    public void mouseEntered(MouseEvent e)
    {
       // this.theGame.pauseOrRestartGame();
    }


    @Override
    public void mouseExited(MouseEvent e)
    {
       // this.theGame.pauseOrRestartGame();
    }


    @Override
    public void mousePressed(MouseEvent e){}

    @Override
    public void mouseReleased(MouseEvent e){}

    @Override
    public void mouseDragged(MouseEvent e){}

 
    
    public void init()
    {
        this.window.setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
        this.setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
        this.window.setResizable(false);
        this.window.setContentPane(this);

        this.xRatioGeneralDisplay = (float) this.window.getContentPane().getSize().width / (float) Game.DEFAULT_MAP_WIDTH;
        this.yRatioGeneralDisplay = (float) this.window.getContentPane().getSize().height / (float) Game.DEFAULT_MAP_HEIGHT;

        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setVisible(true);
        
        this.removeAll();
        
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        
        
        
    }

    @Override
    public void displayMenu()
    {
        this.state = "Menu";
        
        this.removeMouseMotionListener(this);
        this.removeMouseListener(this);
        
        
        JButton newGame = new JButton("New game");
        newGame.addActionListener(this);
        newGame.setName("bt_newGame");
        this.add(newGame);
         
        JButton exit = new JButton("Exit");
        exit.addActionListener(this);
        exit.setName("bt_exit");
        this.add(exit);
        
        this.window.setTitle("Menu");
        this.window.setSize(300, 300);

        this.getGraphics().setColor(Color.white);
        this.getGraphics().fillRect(0, 0, 400, 400);
        this.repaint();
        this.updateUI();
    }
 
    @Override
    public void actionPerformed(ActionEvent arg0)
    {
        if((arg0.getSource()) instanceof JButton)
        {
            JButton b = (JButton) arg0.getSource();
            
            if(b.getName().equals("bt_newGame"))
            {
                this.state = "newGame";
            }
            else if(b.getName().equals("bt_exit"))
            {
                this.state = "closed";
                this.window.dispose();
            }
        }    
        
    }
}
