package fr.iutvalence.java.mp.BrickBreaker;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ThreadMovePaddleByMouse extends Thread implements MouseMotionListener, MouseListener
{

    /**
     * The game played in this thread
     */
    private Game theGame;
    
    /**
     * The display for the game
     */
    private GUIDisplay d;
    
    
    public void run()
    {
        
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
