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
 * @author soulierc
 *
 */
public class StatisticsPlayerByListWithTextFile extends StatisticsPlayerByList
{

    /**
     * @see fr.iutvalence.java.mp.BrickBreaker.StatisticsPlayerByList#loadPlayer(java.lang.String)
     */
    public void loadPlayer() throws ImpossibleDataAccess
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
                res.pseudo = str[0];
                res.score = Integer.parseInt(str[1]);
                res.gameNumber = Integer.parseInt(str[2]);
                this.addPlayer(res);
            }
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (AlreadyExists e)
        {
            // TODO Auto-generated catch block
            System.err.println("Abording datas players loading");
            e.printStackTrace();
        }
        
    }
    
    public void savePlayers()
    {
        DataOutputStream out;
        List<Player> listToSave = this.getListe();
        try
        {
            out = new DataOutputStream(new FileOutputStream(new File("players.stats")));
            String str="";
            
            for(int i =0;   i < listToSave.size();   i++)
            {
                str = listToSave.get(i).pseudo + " " + listToSave.get(i).score + " " + listToSave.get(i).gameNumber + "\n";
                out.writeBytes(str);
            }
           out.flush();
           out.close();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        
        
    }
    
}
