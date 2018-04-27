import greenfoot.*;

/**
 * Write a description of class HorPlatform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HorPlatform extends Platforms
{
    private int speed = 2;
    private int leftTurn = 170;
    private int rightTurn = 420;
    public void act() 
    {
         setLocation ( getX() + speed, getY() );
        
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
        return (getX() <= leftTurn || getX() >= rightTurn);
    }
}
