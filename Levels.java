import greenfoot.*;

/**
 * Write a description of class Levels here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Levels extends World
{

    /**
     * Constructor for objects of class Levels.
     * 
     */
    public Levels()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        
    }

    public void addMoney() 
    {
        for(int p=0; p<5; p=p+1) {
            int x= Greenfoot.getRandomNumber ( getWidth() );
            int y= Greenfoot.getRandomNumber (getHeight());
            if(y<500) {
                addObject(new Money(), x,y);
            }
        }

    }

    public void act()
    {
        addMoreMoney();
        addMoreTrees();
    }

    public void addMoreMoney()
    {
        if(Greenfoot.getRandomNumber(100) < 0.1 ) {
            addObject( new Money(), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()-100));
        }
    }
 
    
    public void addMoreTrees()
    {
        if(Greenfoot.getRandomNumber(1000) < 5 ) {
            addObject( new Tree(), 700, 525);
        }
    }

}
