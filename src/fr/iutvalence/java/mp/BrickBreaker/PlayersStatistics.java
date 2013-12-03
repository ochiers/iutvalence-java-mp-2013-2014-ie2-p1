package fr.iutvalence.java.mp.BrickBreaker;

/**
 * This class define function in order to manages statistics about players
 * @author soulierc
 *
 */
public interface PlayersStatistics
{
 
    // TODO (fix) finish writing comment
    /** The method who added a new pseudo of a new player in the list of player
     * @param player The played who will be added
     * @throws DataAccessException 
     * @throws PlayerAlreadyExistsException 
     */
    public void addPlayer(Player player) throws DataAccessException, PlayerAlreadyExistsException;
    
    // TODO (fix) finish writing comment
    /** The method who update the score of a player
     * @param pseudo The player's pseudo
     * @param score the best score of the player
     * @return true if the score has been updated, false however
     * @throws DataAccessException 
     */
    public boolean updateScore(String pseudo, int score) throws DataAccessException;
    
    // TODO (fix) finish writing comment
    /** 
     *This method update the number of game played by a player
     * @param pseudo The player's pseudo
     * @return true if the number of game has been updated, false however
     * @throws DataAccessException 
     */
    public boolean updateNumberGame(String pseudo) throws DataAccessException;
    
    // TODO (fix) finish writing comment
    /** 
     * This method load players into an "internal structure"
     * in order to manage more effectively the data
     * @throws DataAccessException 
     */
    public void loadPlayers() throws DataAccessException;
    
    
    // TODO (fix) finish writing comment
    /**
     * This method stock all players loaded to an "external structure"
     * @throws DataAccessException
     */
    public void savePlayers() throws DataAccessException;
    
    
    /**
     * This method return true if a player has been already loaded
     * @param p The player to check
     * @return true if player exist, false however
     */
    public boolean isPlayerAlreadyExists(Player p);
    
    
    /**
     * This method give the player who has hightest score
     * @return a player who have actually the best score
     */
    public Player bestScore();
    
    /**
     * This method give the player who has lowest score
     * @return a player who have actually the worst score
     */
    public Player worstScore();
        
}
