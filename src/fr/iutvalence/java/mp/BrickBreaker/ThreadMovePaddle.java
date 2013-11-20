package fr.iutvalence.java.mp.BrickBreaker;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;


/**
 * Define the thread who move the paddle
 * @author ochiers
 *
 */
public class ThreadMovePaddle extends Thread implements MouseMotionListener
{
    // TODO (fixed) write comment
    /**
     * The paddle who is moved
     */
    private Paddle pad;
    
    // TODO (fixed) finish writing comment
    /**
     * A thread who move the pad
     * @param pad The pad who will move
     * @param pan The JPanel who catch the mouse events
     */
    public ThreadMovePaddle(Paddle pad, JPanel pan){
        
        super();
        if(pad == null)
            System.err.println("paddle null");
        else
       this.pad = pad;
      pan.addMouseMotionListener(this);
    }
    
    /**
     * @see java.lang.Thread#run()
     */
    public void run()
    {
       while(true)
       {
           try
           {
               Thread.sleep(5);
           }
           catch (InterruptedException e)
           {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
       }
    }

    @Override
    public void mouseDragged(MouseEvent arg0)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseMoved(MouseEvent arg0)
    {
        if(arg0.getX() < Game.DEFAULT_MAP_WIDTH - pad.getWidth()/2 && arg0.getX() - pad.getWidth()/2>= 0)
        pad.setTopLeftCornerPosition(new Position(arg0.getX() - pad.getWidth()/2, (float) pad.getCollisionBox().getBox().getY()));
        
    }

   
}
