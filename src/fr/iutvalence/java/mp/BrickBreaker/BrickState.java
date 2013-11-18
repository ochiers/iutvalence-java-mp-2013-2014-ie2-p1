package fr.iutvalence.java.mp.BrickBreaker;

// TODO (fixed) finish writing comment (general description is missing)
/**
 * Define the different state that a brick can be
 * @author soulierc
 * 
 */
public enum BrickState
{
    /**
     * That is the normal state of a brick
     */
    NORMAL_STATE,

    /**
     * That is the second state of a brick That is when the brick was hit
     */
    TOUCHED_STATE,

    /**
     * That is the third state of a brick That is when the brick was hit
     */
    DAMAGED_STATE,

    /**
     * That is the laster state of a brick That is when the brick was hit for
     * the last time And then, it is delete of the screen
     */
    DESTROYED_STATE;

}
