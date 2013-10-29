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
     * Create a new trajectory with given coefficients a and b
     * @param a
     * @param b
     */
    Trajectory(float a, float b)
    {
        this.aCoefficient = a;
        this.bCoefficient = b;
    }

    // TODO (fixed) write comment
    /**
     * Set the opposite aCoefficient
     */
    public void reverseACoefficient()
    {
        this.aCoefficient = -this.aCoefficient;
    }

    // TODO (fixed) write comment
    /**
     * Set the opposite bCoefficient
     */
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

    // TODO (fixed) finish writing comment
    /**
     * Returns a description of the trajectory as an ASCII string whose format
     * is "Coef A : Trajectory's A coefficicent, Coef B: " Trajectory's B coefficicent"
     * 
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        return "Coef A : " + this.aCoefficient + ", Coef B: " + this.bCoefficient;

    }
}
