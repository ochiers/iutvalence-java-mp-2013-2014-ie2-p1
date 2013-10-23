package fr.iutvalence.java.mp.BrickBreaker;

public class Trajectory
{
    /**
     * Coeficient on vertical axis
     */
    private float coefA;
    
    /**
     * Coeficient on horizontal axis
     */
    private float coefB;
    
    /**
     * 
     * @param a
     * @param b
     */
    Trajectory(float a, float b)
    {
        this.coefA = a;
        this.coefB = b;
    }
    /**
     * Return the A coeficient
     * @return a coeficicent
     */
    public float getCoefA()
    {
        return coefA;
    }

    /**
     * Return the B coeficient
     * @return b coeficient
     */
    public float getCoefB()
    {
        return coefB;
    }
}
