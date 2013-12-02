package fr.iutvalence.java.mp.BrickBreaker;

public interface StatisticsPlayer
{
    
    /** The method who added a new pseudo of a new player in the list of player
     * @param pseudo the string who define the player's name
     */
    public void addPlayer(Player player) throws ImpossibleDataAccess, AlreadyExists;
    
    /** The method who update the best score of a player
     * @param score the best score of the player
     */
    public void updateScore(String pseudo, int score) throws ImpossibleDataAccess;
    
    /** 
     * @param pseudo
     */
    public void updateNumberGame(String pseudo) throws ImpossibleDataAccess;
    
    /** 
     * @param pseudo
     * @return
     */
    public void loadPlayer() throws ImpossibleDataAccess;
    
    
    /**
     * @throws ImpossibleDataAccess
     */
    public void savePlayers() throws ImpossibleDataAccess;
    
    
    public boolean isPlayerAlreadyExists(Player p);
}
