import greenfoot.*;

/**
 * Write a description of class VertPlatform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VertPlatform extends Platforms
{

    private int speed = 2;
    private int goingUp = 170;
    private int goingDown = 400;

    public void act() 
    {
        setLocation ( getX(), getY() + speed );
        if (atTurningPoint()) {
            speed = -speed;
        }
    }    

    public int getSpeed()
    {
        return speed;
    }

    public boolean atTurningPoint()
    {
        return (getY() <= goingUp || getY() >= goingDown);
    }
}    

