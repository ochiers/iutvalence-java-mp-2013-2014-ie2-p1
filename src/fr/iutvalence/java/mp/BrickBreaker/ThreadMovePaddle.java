package fr.iutvalence.java.mp.BrickBreaker;

/**
 * Define the thread who move the paddle
 * @author ochiers
 *
 */
public class ThreadMovePaddle extends Thread
{
    // TODO (fixed) write comment
    /**
     * The paddle who is moved
     */
    private Paddle pad;
    
    // TODO (fix) finish writing comment
    /**
     * A thread who move the pad
     * @param pad The pad who will move
     */
    public ThreadMovePaddle(Paddle pad){
        
        super();
        if(pad == null)
            System.out.println("paddle null");
        else
       this.pad = pad;
    }
    
    /**
     * @see java.lang.Thread#run()
     */
    public void run()
    {
       while(true)
       {
        if(this.pad.getCollisionBox().getBox().x + this.pad.getWidth() >= Game.DEFAULT_MAP_WIDTH)
        {
            this.pad.setTopLeftCornerPosition(new Position(0, this.pad.getCollisionBox().getBox().y));
        }
        else
        {
            this.pad.setTopLeftCornerPosition(new Position(++this.pad.getCollisionBox().getBox().x, this.pad.getCollisionBox().getBox().y));
        }
        
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

   
}
