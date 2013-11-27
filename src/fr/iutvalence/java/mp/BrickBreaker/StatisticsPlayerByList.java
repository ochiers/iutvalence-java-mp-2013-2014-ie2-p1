package fr.iutvalence.java.mp.BrickBreaker;

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
    List liste;
    
    /**
     * @see fr.iutvalence.java.mp.BrickBreaker.StatisticsPlayer#addPlayer(fr.iutvalence.java.mp.BrickBreaker.Player)
     */
    public void addPlayer(Player player) throws ImpossibleDataAccess, AlreadyExists
    {
        this.liste.add(player);
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
     * @see fr.iutvalence.java.mp.BrickBreaker.StatisticsPlayer#loadPlayer(java.lang.String)
     */
    public void loadPlayer(String pseudo) throws ImpossibleDataAccess
    {
        
    }

}
