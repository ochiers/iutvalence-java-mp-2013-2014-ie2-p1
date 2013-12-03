package fr.iutvalence.java.mp.BrickBreaker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * This class use a list in order to stock players and manage them
 * @author soulierc
 *
 */
public class ListPlayersStatistics implements PlayersStatistics
{

    // TODO (fix) write comment
    private List<Player> list;
    
    // TODO (fix) write comment
    public ListPlayersStatistics()
    {
        super();
        this.list = new ArrayList<Player>();
    }

    /**
     * Return the list used to store players
     * @return the list who stock players
     */
    public List<Player> getList()
    {
        return this.list;
    }
    
    /**
     * @see fr.iutvalence.java.mp.BrickBreaker.PlayersStatistics#addPlayer(fr.iutvalence.java.mp.BrickBreaker.Player)
     */
    public void addPlayer(Player player) throws DataAccessException, PlayerAlreadyExistsException
    {
        if(!isPlayerAlreadyExists(player))
        this.list.add(player);
        else
            throw new PlayerAlreadyExistsException();
    }

    /**
     * @see fr.iutvalence.java.mp.BrickBreaker.PlayersStatistics#updateScore(java.lang.String, int)
     */
    public boolean updateScore(String pseudo, int score) throws DataAccessException
    {
        boolean res = false;
        for(int i=0; i<this.list.size();i++)
        {
            Player p = (Player)(this.list.get(i));
            if(p.getPseudo().equals(pseudo))
            {
                p.setScore(score);
                res = true;
                break;
            }
        }
        return res;
    }

    /**
     * @see fr.iutvalence.java.mp.BrickBreaker.PlayersStatistics#updateNumberGame(java.lang.String)
     */
    public boolean updateNumberGame(String pseudo) throws DataAccessException
    {
        boolean res = false;
        for(int i=0; i<this.list.size();i++)
        {
            Player p = (Player)(this.list.get(i));
            if(p.getPseudo().equals(pseudo))
            {
                p.setGameNumber();
                res = true;
                break;
            }
        }
        return res;
    }

    /**
     * @see fr.iutvalence.java.mp.BrickBreaker.PlayersStatistics#loadPlayers()
     */
    public void loadPlayers() throws DataAccessException{}
    

    /**
     * @see fr.iutvalence.java.mp.BrickBreaker.PlayersStatistics#savePlayers()
     */
    public void savePlayers() throws DataAccessException{}

    
    /**
     * @see fr.iutvalence.java.mp.BrickBreaker.PlayersStatistics#isPlayerAlreadyExists(fr.iutvalence.java.mp.BrickBreaker.Player)
     */
    public boolean isPlayerAlreadyExists(Player p)
    {
        boolean res = false;
        
        for(int i = 0; i < this.list.size(); i++)
        {
            if(this.list.get(i).getPseudo().equals(p.getPseudo()))
                res= res || true;
        }
        
        return res;
    }

    /**
     * @see fr.iutvalence.java.mp.BrickBreaker.PlayersStatistics#bestScore()
     */
    public Player bestScore()
    {
        Iterator<Player> it = this.list.iterator();
        Player bestPlayer = (Player)it.next();
        while(it.hasNext())
        {
            Player currentPlayer = (Player)it.next();
            if(currentPlayer.getScore() > bestPlayer.getScore())
                bestPlayer = currentPlayer;
        }
        return bestPlayer;
    }

    
    /**
     * @see fr.iutvalence.java.mp.BrickBreaker.PlayersStatistics#worstScore()
     */
    public Player worstScore()
    {
        Iterator<Player> it = this.list.iterator();
        Player worstPlayer = (Player)it.next();
        while(it.hasNext())
        {
            Player currentPlayer = (Player)it.next();
            if(currentPlayer.getScore() < worstPlayer.getScore())
                worstPlayer = currentPlayer;
        }
        return worstPlayer;
    }
}
