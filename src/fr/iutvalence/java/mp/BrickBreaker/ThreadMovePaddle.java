package fr.iutvalence.java.mp.BrickBreaker;

/**
 * @author ochiers
 *
 */
public class ThreadMovePaddle extends Thread
{
    // TODO (fix) write comment
    private Paddle pad;
    
    // TODO (fix) finish writing comment
    /**
     * @param pad
     */
    public ThreadMovePaddle(Paddle pad){
        
        super();
        if(pad == null)
            System.out.println("paddle null");
        
       this.pad = pad;
    }
    
    /**
     * @see java.lang.Thread#run()
     */
    public void run()
    {
       while(true)
       {
        if(this.pad.getCollisionBox().getBox().x + this.pad.getWidth() > Game.DEFAULT_MAP_WIDTH)
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
