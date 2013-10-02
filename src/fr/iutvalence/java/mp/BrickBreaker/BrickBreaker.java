package fr.iutvalence.java.mp.BrickBreaker;

// TODO (fix) write a "real" comment
/**
 * Main class
 * @author ochiers
 * 
 */

public class BrickBreaker
{
    // TODO (fix) write a comment
    public static void main(String[]args)
    {
        // tests 
        
        Game newGame = new Game();
        for(int i = 0; i<10; i++)
        {
            System.out.println(newGame.tabBrick[i].toString());
        }
    }
}
