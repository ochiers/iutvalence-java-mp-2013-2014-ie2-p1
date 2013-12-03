package fr.iutvalence.java.mp.BrickBreaker;

/**
 * This class is used to test DataBanks
 * 
 * @author soulierc
 * 
 */
public class DataBaseTest
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        ListPlayersStatistics stat = new TextFilePlayersStatistics();

        try
        {
            stat.loadPlayers();

            for (int i = 0; i < stat.getList().size(); i++)
            {
                System.out.println(stat.getList().get(i));
            }
            stat.addPlayer(new Player("Bidule"));

            stat.updateScore("moi", 1487523345);
            stat.updateNumberGame("lui");
            System.out.println("Le meilleur joueur est " + stat.bestScore().getPseudo());
            System.out.println("Le pire joueur est " + stat.worstScore().getPseudo());

            // stat.savePlayers(); // It works
        }
        catch (DataAccessException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (PlayerAlreadyExistsException e)
        {
        }

        /*
         * System.out.println("Nouveaux players : "); for(int i =0; i <
         * stat.getListe().size(); i++) {
         * System.out.println(stat.getListe().get(i)); }
         */

    }

}