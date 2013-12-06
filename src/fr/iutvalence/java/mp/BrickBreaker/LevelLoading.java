package fr.iutvalence.java.mp.BrickBreaker;

/**
 * @author ochiers
 *
 */
public interface LevelLoading
{
    
    /**
     * @param name
     * @param brick
     * @throws DataAccessException
     * @throws LevelAlreadyExistsException
     */
    public void addLevel(Level level) throws DataAccessException, LevelAlreadyExistsException;

    /**
     * @throws DataAccessException
     */
    public void loadLevel() throws DataAccessException;

    /**
     * @throws DataAccessException
     */
    public void saveLevel() throws DataAccessException;
    
    public boolean isLevelAlreadyExists(String name);

}
