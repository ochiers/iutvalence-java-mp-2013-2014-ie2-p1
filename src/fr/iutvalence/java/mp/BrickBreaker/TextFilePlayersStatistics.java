package fr.iutvalence.java.mp.BrickBreaker;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


/**
 * This class use files and lists in order to manages players
 * @author soulierc
 */
public class TextFilePlayersStatistics extends ListPlayersStatistics
{

    // TODO (fix) fix comment
    /**
     * This method load player from a file
     * @see fr.iutvalence.java.mp.BrickBreaker.ListPlayersStatistics#loadPlayer(java.lang.String)
     */
    public void loadPlayers() throws DataAccessException
    {
        
        DataInputStream in;
        try
        {
            in = new DataInputStream(new FileInputStream(new File("players.stats")));        
            String player;
            String str[] = new String[3];
            while((player = in.readLine()) != null)
            {
                Player res = new Player();
                str = player.split(" ");
                res.setPseudo(str[0]);
                res.setScore(Integer.parseInt(str[1]));
                res.setGameNumber(Integer.parseInt(str[2]));
                this.addPlayer(res);
            }
            in.close();
        }
        catch (IOException e)
        {
            throw new DataAccessException();
        }
        catch (PlayerAlreadyExistsException e)
        {
            System.err.println("Abording datas players loading");
            e.printStackTrace();
        }
        
    }
    
    /**
     * Players are stocked into a file
     * @see fr.iutvalence.java.mp.BrickBreaker.ListPlayersStatistics#savePlayers()
     */
    public void savePlayers() throws DataAccessException
    {
        DataOutputStream out;
        List<Player> listToSave = this.getList();
        try
        {
            out = new DataOutputStream(new FileOutputStream(new File("players.stats")));
            String str="";
            
            for(int i =0;   i < listToSave.size();   i++)
            {
                str = listToSave.get(i).getPseudo() + " " + listToSave.get(i).getScore() + " " + listToSave.get(i).getGameNumber() + "\n";
                out.writeBytes(str);
            }
           out.flush();
           out.close();
        }
        catch (IOException e)
        {
            throw new DataAccessException();
        }
        
    }
    
}
