package fr.iutvalence.java.mp.BrickBreaker;

import java.util.ArrayList;
import java.util.List;

/**
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
    public void updateScore(String pseudo, int score) throws ImpossibleDataAccess
    {
        for(int i=0; i<this.liste.size();i++)
        {
            Player p = (Player)(this.liste.get(i));
            if(p.pseudo.equals(pseudo))
            {
                p.score = score;
                break;
            }
        }
    }

    /**
     * @see fr.iutvalence.java.mp.BrickBreaker.StatisticsPlayer#updateNumberGame(java.lang.String)
     */
    public void updateNumberGame(String pseudo) throws ImpossibleDataAccess
    {
        for(int i=0; i<this.liste.size();i++)
        {
            Player p = (Player)(this.liste.get(i));
            if(p.pseudo.equals(pseudo))
            {
                p.gameNumber++;
                break;
            }
        }
    }

    /**
     * @see fr.iutvalence.java.mp.BrickBreaker.StatisticsPlayer#loadPlayer()
     */
    public void loadPlayer() throws ImpossibleDataAccess
    {
        
    }
    
    /**
     * @throws ImpossibleDataAccess
     */
    public void savePlayers() throws ImpossibleDataAccess
    {
        
    }

    @Override
    public boolean isPlayerAlreadyExists(Player p)
    {
        boolean res = false;
        
        for(int i = 0; i < this.liste.size(); i++)
        {
            if(this.liste.get(i).pseudo.equals(p.pseudo))
                res= res || true;
        }
        
        return res;
    }

}
