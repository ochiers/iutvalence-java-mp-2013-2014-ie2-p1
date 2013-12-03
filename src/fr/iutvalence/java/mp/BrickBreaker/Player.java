package fr.iutvalence.java.mp.BrickBreaker;
 
/**
 * Define what is a player
 * @author soulierc
 *
 */
public class Player
{
    
    /**
     *The pseudo of the player 
     */
    private String pseudo;
    
    /**
     *The score of the player 
     */
    private int score;
    
    /**
     *The number of game of the player 
     */
    // TODO (fixed) rename field
    private int numberOfGamesPlayed;
    
    /**
     * Define an unknown player
     */
    public Player()
    {
        this.pseudo = "Unknown";
        this.score = 0;
    }
    
    // TODO (fixed) write comment
    /**
     * Create a new player with a pseudo specified and, score and number of game played = 0
     * @param name The pseudo of the player
     */
    public Player(String name)
    {
        this.pseudo = name;
        this.score = 0;
    }
    
    
    /**
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        return "Pseudo : " + this.pseudo + ", score : " + this.score + ", nbGame : " + this.numberOfGamesPlayed;
                
    }

    // TODO (fixed) write comment
    /**
     * Get the pseudo of this player
     * @return The player's pseudo
     */
    public String getPseudo()
    {
        return pseudo;
    }

    // TODO (fixed) write comment
    /**
     * Set a new pseudo for this player
     * @param pseudo The new player's pseudo, if is empty : nothing is done
     */
    public void setPseudo(String pseudo)
    {
        if(!pseudo.equals(""))
        this.pseudo = pseudo;
    }

    // TODO (fixed) write comment
    /** Get the score of this player
     * @return The player's score
     */
    public int getScore()
    {
        return score;
    }

    // TODO (fixed) write comment
    /**
     * Set the score of this player
     * @param score The new player's score, if is negative : nothing is done
     */
    public void setScore(int score)
    {
        if(score >= 0)
        this.score = score;
    }

    // TODO (fixed) write comment
    // TODO (fixed) rename method
    /** Get the number of games played by this player
     * @return The player's games played
     */
    public int getGameNumber()
    {
        return numberOfGamesPlayed;
    }

    // TODO (fixed) write comment
    // TODO (fixed) rename method
    /**
     * Increments the number of games played by this player
     */
    public void setNumberOfGamesPlayed()
    {
        this.numberOfGamesPlayed++;
    }

    // TODO (fixed) write comment
    // TODO (fixed) rename method
    /** Set the number of games played by this player
     * @param a The new number of games played by this player
     */
    public void setNumberOfGamesPlayed(int a)
    {
        this.numberOfGamesPlayed = a;      
    }
       
}
