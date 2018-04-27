import greenfoot.*;

/**
 * Write a description of class RockD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RockD extends Actor
{
    private int speed;
    public RockD()
    {
        GreenfootImage img = getImage();
        int x = Greenfoot.getRandomNumber(50) + 1;
        int y = Greenfoot.getRandomNumber(50) + 1;
        img.scale(x,y);
        setRotation(Greenfoot.getRandomNumber(360));
        speed = Greenfoot.getRandomNumber(15) + 5;
    }

    public void act() 
    {
        move(speed);
        if(isAtEdge()) {
            getWorld().removeObject(this);
        }
    }    
}    
