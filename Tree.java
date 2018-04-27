import greenfoot.*;

/**
 * Write a description of class Tree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tree extends Avoid
{
    /**
     * Act - do whatever the Tree wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX()-3, getY());
        if(getX()<5) {
            getWorld().removeObject(this);
        }
    }    
    
     public void explodeT()
    {
       
        for(int x=0; x<15; x++) {
            getWorld().addObject(new TreeD(), getX(), getY() );
        }
        Greenfoot.playSound("Explosion.wav");
        getWorld().removeObject(this);

    }
}
