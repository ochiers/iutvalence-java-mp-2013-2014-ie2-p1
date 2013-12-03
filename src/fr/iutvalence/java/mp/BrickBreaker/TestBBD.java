package fr.iutvalence.java.mp.BrickBreaker;

public class TestBBD
{

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

        for(int i=0; stats.getList().size() > i;i++)
        System.out.println(stats.getList().get(i).toString());
    }

}
