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
    String pseudo;
    
    /**
     *The score of the player 
     */
    int score;
    
    /**
     *The number of game of the player 
     */
    int gameNumber;
    
    /**
     * Define an unknown player, his id is 1 by default
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
}
