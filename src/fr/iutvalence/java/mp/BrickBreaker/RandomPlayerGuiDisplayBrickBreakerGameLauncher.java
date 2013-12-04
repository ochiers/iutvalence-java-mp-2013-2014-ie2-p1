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

        try
        {
            stats.loadPlayers();
        }
        catch (DataAccessException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
                
        Game theGame = new Game(new GUIDisplay(), stats.getList().get(0));
                
        theGame.play();
        
        System.out.println(stats.getList().get(0).getScore());
        
    }
}
