package fr.iutvalence.java.mp.BrickBreaker;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class TextFileLevel extends ListLevel
{
    public void loadLevel() throws DataAccessException
    {
        
        DataInputStream in;
        try
        {
            in = new DataInputStream(new FileInputStream(new File("levels.level")));        
            String id;
            String str[] = new String[3];
            while((id = in.readLine()) != null)
            {
                Level res = new Level();
                str = id.split(" ");
                res.setIdLevel(Integer.parseInt(str[0]));
                res.setNameLevel(str[1]);
                //res.setBrickTab((Bricks[])(str[2]));
                this.addLevel(res);
            }
            in.close();
        }
        catch (IOException e)
        {
            throw new DataAccessException();
        }
        catch (LevelAlreadyExistsException e)
        {
            System.err.println("Abording datas levels loading");
            e.printStackTrace();
        }
        
    }
    
    public void saveLevels() throws DataAccessException
    {
        DataOutputStream out;
        List<Level> listToSave = this.getList();
        try
        {
            out = new DataOutputStream(new FileOutputStream(new File("players.stats")));
            String str="";
            
            for(int i =0;   i < listToSave.size();   i++)
            {
                str = listToSave.get(i).getIdLevel() + " " + listToSave.get(i).getNameLevel() + " " + listToSave.get(i).getBrickTab() + "\n";
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
