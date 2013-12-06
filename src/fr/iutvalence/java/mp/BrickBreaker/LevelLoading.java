package fr.iutvalence.java.mp.BrickBreaker;

/**
 * @author ochiers
 *
 */
public interface LevelLoading
{
    
   
    /** 
     * @param brick
     * @throws DataAccessException
     * @throws LevelAlreadyExistsException
     */
    public void addLevel(Brick[] brick) throws DataAccessException, LevelAlreadyExistsException;

    /**
     * @throws DataAccessException
     */
    public void loadLevel() throws DataAccessException;

    /**
     * @throws DataAccessException
     */
    public void saveLevel() throws DataAccessException;

}
