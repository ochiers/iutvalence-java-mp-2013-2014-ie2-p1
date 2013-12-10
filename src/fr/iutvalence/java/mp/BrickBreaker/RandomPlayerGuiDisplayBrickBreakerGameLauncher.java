package fr.iutvalence.java.mp.BrickBreaker;

/**
 * Main class, the program start here and use the other classes
 * 
 * @author ochiers
 *  
 */
public class RandomPlayerGuiDisplayBrickBreakerGameLauncher
{
    /**
     * Default game launcher 
     * 
     * @param args
     */
    public static void main(String[] args)
    {          
        
        ListPlayersStatistics stats = new TextFilePlayersStatistics();
        TextFileLevel levels = new TextFileLevel ();
        

        
        try
        {
            stats.loadPlayers();
            levels.loadLevels();
        }
        catch (DataAccessException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        if(args[0].equals("GUI"))
        {
            GUIDisplay display = new GUIDisplay();
            display.displayMenu();
            
            if(display.state == null)System.out.println("1");
            
            while(!display.state.equals("closed"))
            {
                if(display.state.equals("newGame"))
                {
                    display.init();
                    Game theGame = new Game(display, stats.getList().get(0), levels.getList());
                    theGame.play();
                    
                    try{Thread.sleep(1000);}
                    catch (InterruptedException e){e.printStackTrace();}
                    
                    display.displayMenu();
                }
              }
        }
        try
        {
            stats.savePlayers();
        }
        catch (DataAccessException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
