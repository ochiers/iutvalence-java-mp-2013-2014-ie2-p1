package fr.iutvalence.java.mp.BrickBreaker;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class ThreadMovePaddleByMouse extends Thread implements MouseMotionListener
{

    private Game theGame;
    private GUIDisplay d;
    public void run()
    {
        
        this.theGame = new Game(new GUIDisplay());
        
        this.d = (GUIDisplay)(this.theGame.getDisplay());
        this.d.addMouseMotionListener(this);
        
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

    
    
}
