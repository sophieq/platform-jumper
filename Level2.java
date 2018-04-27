import greenfoot.*;

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends Levels
{
private Counter score;
    public Level2(Boy player)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.

        addObject(new Grass(), 310,  575);
        addObject(player, 50, 60);
        score = player.getMyScore();
    addObject( score, 535, 34 );
        addObject(new Platform2(), 25, getHeight()/2);
        addObject(new Platform2(), 575, getHeight()/2);
        addObject(new Platform2(), 200, 153);
        addObject(new Platform2(), 400, 153);
        addObject(new Platform2(), 200, 430);
        addObject(new Platform2(), 400, 430);
        addObject(new HorPlatform(), getWidth()/2, getHeight()/2);
        super.addMoney();
        addObject(new Tree(), 550, 525);
        addObject(new Rock(), getWidth()/2, 0);
      
        
    }

    public void act()
    {
        addRocks();
        super.act();
    }

    public void addRocks()
    {
        if(Greenfoot.getRandomNumber(1000)<5) {
            addObject(new Rock(), Greenfoot.getRandomNumber(getWidth()), 0);
        }
    }
    
    
    

}

