package fr.iutvalence.java.mp.BrickBreaker;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ThreadMovePaddleByMouse extends Thread implements MouseMotionListener, MouseListener
{
    // TODO (fix) This class should not depend on Game but on the service provided by Game
    /**
     * The game played in this thread
     */
    private Game theGame;
    
    // TODO (fix) This class should not depend on a display but here be the display
    /**
     * The display for the game
     */
    private GUIDisplay d;
    
    /**
     * @see java.lang.Thread#run()
     */
    public void run()
    {
        // TODO (fix) the game should be instanciated in the Main
        this.theGame = new Game(new GUIDisplay());
        
        this.d = (GUIDisplay)(this.theGame.getDisplay());
        this.d.addMouseMotionListener(this);
        this.d.addMouseListener(this);
        
        this.theGame.play();
    }
    
    
    @Override
    public void mouseDragged(MouseEvent e)
    {
        // TODO Auto-generated method stub
         
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        this.theGame.moveThePaddle(e.getX());
    }


    @Override
    public void mouseClicked(MouseEvent e)
    {
        this.theGame.pauseOrRestartGame();
        
    }


    @Override
    public void mouseEntered(MouseEvent e)
    {
        this.theGame.pauseOrRestartGame();
    }


    @Override
    public void mouseExited(MouseEvent e)
    {
        this.theGame.pauseOrRestartGame();
    }


    @Override
    public void mousePressed(MouseEvent e)
    {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void mouseReleased(MouseEvent e)
    {
        // TODO Auto-generated method stub
        
    }

    
    
}
