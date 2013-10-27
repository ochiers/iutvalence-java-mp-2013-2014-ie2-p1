package fr.iutvalence.java.mp.BrickBreaker;

/**
 * Define a trajectory of a moving object;
 * 
 * @author soulierc
 * 
 */
public class Trajectory
{
    /**
     * Coefficient on vertical axis
     */
    private float aCoefficient;

    /**
     * Coefficient on horizontal axis
     */
    private float bCoefficient;

    // TODO (fix) finish writing comment
    /**
     * 
     * @param a
     * @param b
     */
    Trajectory(float a, float b)
    {
        this.aCoefficient = a;
        this.bCoefficient = b;
    }

    // TODO (fix) write comment
    public void reverseACoefficient()
    {
        this.aCoefficient = -this.aCoefficient;
    }

    // TODO (fix) write comment
    public void reverseBCoefficient()
    {
        this.bCoefficient = -this.bCoefficient;
    }

    /**
     * Return the A coeficient
     * 
     * @return a coeficicent
     */
    public float getACoefficient()
    {
        return aCoefficient;
    }

    /**
     * Return the B coeficient
     * 
     * @return b coeficient
     */
    public float getBCoefficient()
    {
        return bCoefficient;
    }

    // TODO (fix) finish writing comment
    /**
     * Returns a description of the trajectory as an ASCII string whose format
     * is ...
     * 
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        return "Coef A : " + this.aCoefficient + ", Coef B: " + this.bCoefficient;

    }
}
