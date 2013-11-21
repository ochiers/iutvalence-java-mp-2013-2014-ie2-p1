package fr.iutvalence.java.mp.BrickBreaker;

/**
 * Define what is a player
 * @author soulierc
 *
 */
public class Player
{
    /**
     * The unique identifiant of the player
     */
    long id;
    
    /**
     *The pseudo of the player 
     */
    String pseudo;
    
    /**
     *The score of the player 
     */
    long score;
    
    /**
     * Define an unknown player, his id is 1 by default
     */
    Player()
    {
        this.id = 1;
        this.pseudo = "Unknown";
        this.score = 0;
        
    }
    
    Player(String name, long id)
    {
        this.id = id;
        this.pseudo = name;
        this.score = 0;
    }
    
    private void updateScore(long id, long score)
    {
        //Connection 
    }
    
    
}
