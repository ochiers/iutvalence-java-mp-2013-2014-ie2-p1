package fr.iutvalence.java.mp.BrickBreaker;

/**
 * @author ochiers
 *
 */
public class ThreadMovePaddle extends Thread
{
    
    private Paddle pad;
    
    /**
     * @param pad
     */
    public ThreadMovePaddle(Paddle pad){
        
        super();
        if(pad == null)
            System.out.println("paddle null");
        
       this.pad = pad;
    }
    
    public void run()
    {
       while(true)
       {
        if(this.pad.getPaddleBox().getBox().x + this.pad.getWidth() > Game.DEFAULT_MAP_WIDTH)
        {
            this.pad.setTopLeftCornerPosition(new Position(0, this.pad.getPaddleBox().getBox().y));
        }
        else
        {
            this.pad.setTopLeftCornerPosition(new Position(++this.pad.getPaddleBox().getBox().x, this.pad.getPaddleBox().getBox().y));
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
