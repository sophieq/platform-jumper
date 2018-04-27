import greenfoot.*;

/**
 * Write a description of class Shooter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shooter extends Actor
{
    private int travel = 7;
   public Shooter(int angle)
    {
        setRotation(angle);
    }
    public void act() 
    {

       move(7);
        if(isAtEdge()) {
            getWorld().removeObject(this);
        } else {
           Rock hard = (Rock)getOneIntersectingObject(Rock.class);
            
            if(hard!=null) {
                hard.explode();
               getWorld().removeObject(this);  
        } else {
            Tree wood = (Tree)getOneIntersectingObject(Tree.class);
            if(wood!=null) {
                wood.explodeT();
               getWorld().removeObject(this); 
        }
    }    
}
}
}
