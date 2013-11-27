package fr.iutvalence.java.mp.BrickBreaker;

/**
 * Define a component of the game
 * @author soulierc
 *
 */
public class GameComponents
{

    /**
     * The collision box associated with this component
     * It's used to determinate collisions
     */
    protected CollisionBox collisionBox;
    
    /**
     * Create a new component at position pos
     * @param pos The position of this component
     */
    public GameComponents(Position pos)
    {
        this.collisionBox = new CollisionBox(pos,0,0);
    }
    
    /**
     * Create a new component at position pos with width and height equal to w and h
     * 
     * @param pos   The position of this component
     * @param w     The width of this component
     * @param h     The height of this component
     */
    public GameComponents(Position pos, int w, int h)
    {
        this.collisionBox = new CollisionBox(pos,w,h);
    }
    
    /**
     * Return the Collision box associated to this component
     * @return A CollisionBox associated with this component
     */
    public CollisionBox getCollisionBox()
    {
        return this.collisionBox;
    }
    
        
    
}
