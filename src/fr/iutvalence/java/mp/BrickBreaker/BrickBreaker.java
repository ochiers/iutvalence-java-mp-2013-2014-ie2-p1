// TODO (fixed) package name is not as expected (should be fr.iutvalence.java.mp.<projectName>)
package fr.iutvalence.java.mp.BrickBreaker;

// TODO (fixed) comments should be written in english
/**
 * Main class
 * @author ochiers
 * // TODO (fixed) the class comment is misplaced (must be placed before @author)
 */

// TODO (fixed) the class must be renamed (english) 
public class BrickBreaker
{
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
