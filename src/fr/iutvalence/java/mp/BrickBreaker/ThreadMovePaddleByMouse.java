package fr.iutvalence.java.mp.BrickBreaker;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ThreadMovePaddleByMouse extends Thread implements MouseMotionListener, MouseListener
{

    private Game theGame;
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
        System.out.println("hh");
        this.theGame.pauseOrRestartGame();
        System.out.println(this.theGame.gamePaused);
        
    }


    @Override
    public void mouseEntered(MouseEvent e)
    {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void mouseExited(MouseEvent e)
    {
        // TODO Auto-generated method stub
        
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
