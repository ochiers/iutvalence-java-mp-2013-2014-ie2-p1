package fr.iutvalence.java.mp.BrickBreaker;

public class TestBDD
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        StatisticsPlayerByList stat = new StatisticsPlayerByListWithTextFile();
       
        try
        {
            stat.loadPlayer();
            
            for(int i =0; i < stat.getListe().size(); i++)
            {
                System.out.println(stat.getListe().get(i));
            }
           stat.addPlayer(new Player("Bidule"));
            
            stat.updateScore("moi", 1487523345);
            stat.updateNumberGame("lui");
            //stat.savePlayers(); // It works
        }
        catch (ImpossibleDataAccess e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (AlreadyExists e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Nouveaux players : ");
        for(int i =0; i < stat.getListe().size(); i++)
        {
            System.out.println(stat.getListe().get(i));
        }
     }
    
}