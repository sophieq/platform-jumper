import greenfoot.*;

/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends World
{

    /**
     * Constructor for objects of class Start.
     * 
     */
    public Start()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        addObject(new Label ("CHASING THE DREAM",60), getWidth()/2, 65);
        addObject(new Label ("Earn enough money in \n each level to level up \n \n WARNING: you only have 10 lives ",40), getWidth()/2, 250);
        addObject(new Label ("Press ENTER to Play",60), getWidth()/2, 450);
    }
    
    public void act()
    {
        addMoreTrees();
        if(Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(new Level1());
        }
    }
    
    public void addMoreTrees()
    {
        if(Greenfoot.getRandomNumber(1000) < 5 ) {
            addObject( new Tree(), 700, 525);
        }
    }
}
