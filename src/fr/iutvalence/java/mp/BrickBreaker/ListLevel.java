package fr.iutvalence.java.mp.BrickBreaker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListLevel implements LevelLoading
{
    private List<Level> list;
    
    public ListLevel()
    {
        super();
        this.list = new ArrayList<Level>();
    }

    public List<Level> getList()
    {
        return this.list;
    }
    
    public void addLevel(Level level) throws DataAccessException, LevelAlreadyExistsException
    {
        if(!isLevelAlreadyExists(level.getNameLevel()))
            this.list.add(level);
            else
                throw new LevelAlreadyExistsException();
        
    }
    
    public void loadLevels() throws DataAccessException
    {
        
    }

    public void saveLevel() throws DataAccessException
    {
        
    }

    public boolean isLevelAlreadyExists(String name)
    {
        boolean res = false;
        
        for(int i = 0; i < this.list.size(); i++)
        {
            if(this.list.get(i).getNameLevel().equals(name))
                res= res || true;
        }
        return res;
    }



    
}
