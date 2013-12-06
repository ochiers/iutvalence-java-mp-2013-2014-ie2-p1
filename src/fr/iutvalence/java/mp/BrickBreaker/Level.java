package fr.iutvalence.java.mp.BrickBreaker;

/**
 * @author ochiers
 *
 */
public class Level
{
    
    private int idLevel;

    private String nameLevel;

    private Brick[] brickTab;
    
    public Level()
    {
        this.idLevel = 0;
        this.nameLevel = "Unknown";        
    }

    public Level(int id, String name, Brick[] bricks) 
    {
        this.idLevel = id;
        this.nameLevel = name;
        this.brickTab = bricks;        
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

    public Brick[] getBrickTab()
    {
        return this.brickTab;
    }

    public void setBrickTab(Brick[] brickTab)
    {
        this.brickTab = brickTab;
    }

    /*public String[] split(String string)
    {
        return null;
    }*/
    
    

}
