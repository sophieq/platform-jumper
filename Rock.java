import greenfoot.*;

/**
 * Write a description of class Rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rock extends Avoid
{
    /**
     * Act - do whatever the Rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(), getY()+2);
        if(isAtEdge()) {
            getWorld().removeObject(this);
        }
    }   
    
    public void explode()
    {
       
        for(int x=0; x<15; x++) {
            getWorld().addObject(new RockD(), getX(), getY() );
        }
        Greenfoot.playSound("Explosion.wav");
        getWorld().removeObject(this);

    }
}
