import greenfoot.*;

/**
 * Write a description of class Level3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3 extends Levels
{
private Counter score;
    /**
     * Constructor for objects of class Level3.
     * 
     */
    public Level3 (Boy player)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
     addObject(new Grass(), 310,  575);
      addObject(player, 50, 260);
        score = player.getMyScore();
    addObject( score, 535, 34);
     addObject(new Platform2(), 45, 137);
     addObject(new Platform2(), 548, 137);
     addObject(new Platform2(), 45 , 433);
     addObject(new Platform2(), 548, 433);
     super.addMoney();
     addObject(new HorPlatform(), getWidth()/2 ,137);
     addObject(new HorPlatform(), getWidth()/2, 433);
     addObject(new VertPlatform(), 45, getHeight()/2 );
     addObject(new VertPlatform(), 548, getHeight()/2);
    
    }
    
    public void act()
    {
        super.act();
        addRocks();
    }
    
    public void addRocks()
    {
        if(Greenfoot.getRandomNumber(1000)<0.5) {
            addObject(new Rock(), Greenfoot.getRandomNumber(getWidth()), 0);
        }
    }
    
   
    }

