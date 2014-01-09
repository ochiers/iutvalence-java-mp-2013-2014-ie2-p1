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
    public void loadLevels() throws DataAccessException
    {
        
        DataInputStream in;
        try
        {
            in = new DataInputStream(new FileInputStream(new File("levels.level")));        
            String level;
            String str[] = new String[3];
            String str2[] = new String[500];
            while((level = in.readLine()) != null)
            {
                Level res = new Level();
                str = level.split(" ");
                res.setIdLevel(Integer.parseInt(str[0]));
                res.setNameLevel(str[1]);
                str2 = str[2].split("\\|");
                
                
                for(int i=0; i < str2.length; i++)
                {
                    String brick[] = new String[3];
                    brick = str2[i].split(",");                    
                    Position tempPos = new Position(Float.parseFloat(brick[0])*Brick.DEFAULT_WIDTH,Float.parseFloat(brick[1])*Brick.DEFAULT_HEIGHT);
                    if(brick[2].equals("NORMAL_STATE"))
                        res.getBrickTab().add(new Brick(tempPos, BrickState.NORMAL_STATE));
                    else if (brick[2].equals("TOUCHED_STATE"))
                        res.getBrickTab().add(new Brick(tempPos, BrickState.TOUCHED_STATE)); 
                    else
                        res.getBrickTab().add(new Brick(tempPos, BrickState.DAMAGED_STATE));
                }
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
    
    /**Don't work
     * @throws DataAccessException
     */
    public void saveLevels() throws DataAccessException
    {
        DataOutputStream out;
        List<Level> listToSave = this.getList();
        try
        {
            out = new DataOutputStream(new FileOutputStream(new File("levels.level")));
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
