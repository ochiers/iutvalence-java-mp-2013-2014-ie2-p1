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
    // TODO (fix) rename field
    private int gameNumber;
    
    /**
     * Define an unknown player
     */
    public Player()
    {
        this.pseudo = "Unknown";
        this.score = 0;
    }
    
    // TODO (fix) write comment
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
        return "Pseudo : " + this.pseudo + ", score : " + this.score + ", nbGame : " + this.gameNumber;
                
    }

    // TODO (fix) write comment
    public String getPseudo()
    {
        return pseudo;
    }

    // TODO (fix) write comment
    public void setPseudo(String pseudo)
    {
        if(!pseudo.equals(""))
        this.pseudo = pseudo;
    }

    // TODO (fix) write comment
    public int getScore()
    {
        return score;
    }

    // TODO (fix) write comment
    public void setScore(int score)
    {
        if(score >= 0)
        this.score = score;
    }

    // TODO (fix) write comment
    // TODO (fix) rename method
    public int getGameNumber()
    {
        return gameNumber;
    }

    // TODO (fix) write comment
    // TODO (fix) rename method
    public void setGameNumber()
    {
        this.gameNumber++;
    }

    // TODO (fix) write comment
    // TODO (fix) rename method
    public void setGameNumber(int a)
    {
        this.gameNumber = a;      
    }
       
}
