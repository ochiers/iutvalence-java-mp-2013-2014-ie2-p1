package fr.iutvalence.java.mp.BrickBreaker;


import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * @author soulierc
 *
 */
public class StatisticsPlayerByListWithTextFile extends StatisticsPlayerByList
{

    /**
     * @see fr.iutvalence.java.mp.BrickBreaker.StatisticsPlayerByList#loadPlayer(java.lang.String)
     */
    public void loadPlayer(String pseudo) throws ImpossibleDataAccess
    {
        Player res = null;
        DataInputStream in;
        try
        {
            in = new DataInputStream(new FileInputStream(new File("player.txt")));        
            String player;
            String str[] = new String[3];
            while((player = in.readLine()) != null)
            {
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
            e.printStackTrace();
        }
        
    }
    
    
}
