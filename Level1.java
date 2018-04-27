import greenfoot.*;

/**
 * Write a description of class World1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends Levels
{
private Counter theScore;
    public Level1()
    {    
        
        addObject(new Grass(), 310,  575);
        
        addObject(new Platform2(), 236, 183);
        addObject(new Platform2(), 351, 183);
        addObject(new Platform2(), 95, 316);
        addObject(new Platform2(), 505, 316);
        addObject(new Platform2(), 236, 407);
        addObject(new Platform2(), 351, 407);
        super.addMoney();
        addObject(new Tree(), 550, 525);
        theScore = new Counter("Money: ");
        addObject( theScore, 535, 34);
       addObject(new Boy(theScore), 50, 60);
    }
    
    public void act()
    {
        super.act();
     
       
    }
    
    
   

}