package fr.iutvalence.java.mp.BrickBreaker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * This class use a list in order to stock players and manage them
 * @author soulierc
 *
 */
public class StatisticsPlayerByList implements StatisticsPlayer
{

    /**
     * 
     */
    private List<Player> liste;
    
    
    public StatisticsPlayerByList()
    {
        super();
        this.liste = new ArrayList<Player>();
    }

    /**
     * Return the list used to store players
     * @return the list who stock players
     */
    public List<Player> getListe()
    {
        return this.liste;
    }
    
    /**
     * @see fr.iutvalence.java.mp.BrickBreaker.StatisticsPlayer#addPlayer(fr.iutvalence.java.mp.BrickBreaker.Player)
     */
    public void addPlayer(Player player) throws ImpossibleDataAccess, AlreadyExists
    {
        if(!isPlayerAlreadyExists(player))
        this.liste.add(player);
        else
            throw new AlreadyExists();
    }

    /**
     * @see fr.iutvalence.java.mp.BrickBreaker.StatisticsPlayer#updateScore(java.lang.String, int)
     */
    public boolean updateScore(String pseudo, int score) throws ImpossibleDataAccess
    {
        boolean res = false;
        for(int i=0; i<this.liste.size();i++)
        {
            Player p = (Player)(this.liste.get(i));
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
     * @see fr.iutvalence.java.mp.BrickBreaker.StatisticsPlayer#updateNumberGame(java.lang.String)
     */
    public boolean updateNumberGame(String pseudo) throws ImpossibleDataAccess
    {
        boolean res = false;
        for(int i=0; i<this.liste.size();i++)
        {
            Player p = (Player)(this.liste.get(i));
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
     * @see fr.iutvalence.java.mp.BrickBreaker.StatisticsPlayer#loadPlayers()
     */
    public void loadPlayers() throws ImpossibleDataAccess{}
    

    /**
     * @see fr.iutvalence.java.mp.BrickBreaker.StatisticsPlayer#savePlayers()
     */
    public void savePlayers() throws ImpossibleDataAccess{}

    
    /**
     * @see fr.iutvalence.java.mp.BrickBreaker.StatisticsPlayer#isPlayerAlreadyExists(fr.iutvalence.java.mp.BrickBreaker.Player)
     */
    public boolean isPlayerAlreadyExists(Player p)
    {
        boolean res = false;
        
        for(int i = 0; i < this.liste.size(); i++)
        {
            if(this.liste.get(i).getPseudo().equals(p.getPseudo()))
                res= res || true;
        }
        
        return res;
    }

    /**
     * @see fr.iutvalence.java.mp.BrickBreaker.StatisticsPlayer#bestScore()
     */
    public Player bestScore()
    {
        Iterator<Player> it = this.liste.iterator();
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
     * @see fr.iutvalence.java.mp.BrickBreaker.StatisticsPlayer#worstScore()
     */
    public Player worstScore()
    {
        Iterator<Player> it = this.liste.iterator();
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
