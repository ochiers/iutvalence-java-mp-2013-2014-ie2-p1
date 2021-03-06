package fr.iutvalence.java.mp.BrickBreaker;
import java.util.Random; 
/**
 * Define some tools that can be used in collisions algorithms
 * @author ochiers
 *
 */
public class Tools
{
    // TODO (fixed) write comment
    /**
     * The Random used to give us random numbers for tools
     */
    private static final Random rand = new Random();
    
    
    /**
     * Function who say if the number toCompare is between the number a and the
     * number b
     * 
     * @param toCompare
     *            Number to compare
     * @param a
     *            Bound of comparison
     * @param b
     *            Bound of comparison
     * @return true if the number is in, false otherwise
     */
    public static boolean isFloatBetween(float toCompare, float a, float b)
    {
        return (toCompare >= a && toCompare <= b) || (toCompare >= b && toCompare <= a);
    }
    
    /**
     * Get a float between two floats
     * @param a 
     *             Bound of comparison
     * @param b 
     *             Bound of comparison
     * @return A float between params a and b
     */
    public static float chooseRandomBetwwen(float a, float b)
    {
        float newNumber = Tools.rand.nextFloat();
        
        while(!Tools.isFloatBetween(newNumber,a,b))
        {
            newNumber = Tools.rand.nextFloat();
        }
        return newNumber;
    }
}
