package fr.iutvalence.java.mp.BrickBreaker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ochiers
 *
 */
public class Level
{
    
    private int idLevel;

    private String nameLevel;

    private List<Brick> brickTab;
    
    public List<Brick> getBrickTab()
    {
        return brickTab;
    }

    public void setBrickTab(List<Brick> brickTab)
    {
        this.brickTab = brickTab;
    }

    public Level()
    {
        this.idLevel = 0;
        this.nameLevel = "Unknown";        
        this.brickTab = new ArrayList<Brick>();
    }

    public Level(int id, String name) 
    {
        this.idLevel = id;
        this.nameLevel = name;
        this.brickTab = new ArrayList<Brick>();
    }

    public int getIdLevel()
    {
        return this.idLevel;
    }

    public void setIdLevel(int idLevel)
    {
        this.idLevel = idLevel;
    }

    public String getNameLevel()
    {
        return this.nameLevel;
    }

    public void setNameLevel(String nameLevel)
    {
        this.nameLevel = nameLevel;
    }

    /*public String[] split(String string)
    {
        return null;
    }*/
    
    

}
