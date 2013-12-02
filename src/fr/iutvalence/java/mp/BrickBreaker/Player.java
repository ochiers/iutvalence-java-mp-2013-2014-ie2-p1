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
    private int gameNumber;
    
    /**
     * Define an unknown player
     */
    Player()
    {
        this.pseudo = "Unknown";
        this.score = 0;
    }
    
    Player(String name)
    {
        this.pseudo = name;
        this.score = 0;
    }
    
    public String toString()
    {
        return "Pseudo : " + this.pseudo + ", score : " + this.score + ", nbGame : " + this.gameNumber;
                
    }

    public String getPseudo()
    {
        return pseudo;
    }

    public void setPseudo(String pseudo)
    {
        if(!pseudo.equals(""))
        this.pseudo = pseudo;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        if(score >= 0)
        this.score = score;
    }

    public int getGameNumber()
    {
        return gameNumber;
    }

    public void setGameNumber()
    {
        this.gameNumber++;
    }

    public void setGameNumber(int a)
    {
        this.gameNumber = a;
        
    }
    
    
}
