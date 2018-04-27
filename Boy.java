import greenfoot.*;

/**
 * Boy is the protagonist that want to get money to go to a concert
 * 
 * @author Sophie
 * @version 1.0
 */
public class Boy extends Actor
{
    private GreenfootImage imgRight = new GreenfootImage("boy.png");
    private GreenfootImage imgLeft = new GreenfootImage("boy2.png");

    private final int SPEED = 3;
    private final double JUMPING = 18;
    private final double GRAVITY=1;
    private double vSpeed = 0.0;
    private boolean shooting = false;
    private boolean facingRight = true;
    private int life = 10;

    private Counter myScore;

    public Boy(Counter sb)
    {
        myScore = sb;
    }

    public void act() 
    {
        checkForHorizontal();
        checkForVertical();
        movement();
        if(onGround()) {
            vSpeed = 0.0;
        } else {
            fall();
        }
        getMoney();
        hitAvoid();

    }  

    public void checkForHorizontal()
    {
        int yOffset = getImage().getHeight()/2;
        HorPlatform side = (HorPlatform)getOneObjectAtOffset(0,yOffset, HorPlatform.class);
        if(side!= null) {
            setLocation(getX()+ side.getSpeed(), getY());
        }
    }

    public void checkForVertical()
    {
        int yOffset = getImage().getHeight()/2;
        VertPlatform up = (VertPlatform)getOneObjectAtOffset(0,yOffset, VertPlatform.class);
        if(up!= null) {
            setLocation(getX(), getY()+ up.getSpeed());
        }
    }

    public void movement()
    {

        if(Greenfoot.isKeyDown("left")){
            setLocation(getX()-SPEED, getY());
            setImage(imgLeft);
            facingRight = false;
        }
        if(Greenfoot.isKeyDown("right")){
            setLocation(getX()+SPEED, getY());
            setImage(imgRight);
            facingRight= true;
        }
        if(Greenfoot.isKeyDown("up")) {
            jump();
        }
        if(Greenfoot.isKeyDown("space") && !shooting) {

            Greenfoot.playSound("shooting.wav");
            shooting= true;
            if( facingRight ) {
                getWorld().addObject( new Shooter(0) , getX(), getY() );
            } else {
                getWorld().addObject( new Shooter(180) , getX(), getY() );
            }

        }
        if(!Greenfoot.isKeyDown("space")) {
            shooting = false;

        }
    }

    public Counter getMyScore()
    {
        return myScore;
    }

    public boolean onGround()
    {
        int yOffset = getImage().getHeight()/2;
        return getOneObjectAtOffset(0,yOffset,Platforms.class)!=null;
    }

    public void fall()
    {
        vSpeed = vSpeed + GRAVITY;
        setLocation(getX(),(int)(getY()+vSpeed));
        if(getY()>getWorld().getHeight()-2) {
            getWorld().removeObject(this);
        }
    }

    public void jump()
    {
        if(onGround()) {
            vSpeed = -JUMPING;
            fall();
        }
    }

    public void getMoney()
    {
        Actor cash = getOneIntersectingObject(Money.class);
        if(cash !=null) {
            myScore.add(1);
            Greenfoot.playSound("success.wav");
            getWorld().removeObject(cash);
        }
        if( myScore.getValue() == 10 ) {
             Greenfoot.playSound("levelup.wav");
            Greenfoot.setWorld( new Level2(this) );
        }
        if( myScore.getValue() == 30 ) {
            Greenfoot.playSound("levelup.wav");
            Greenfoot.setWorld( new Level3(this) );
        }
        if( myScore.getValue() == 60 ) {
            getWorld().addObject( new Label("YOU WIN \n Your Final Score is " + myScore.getValue(), 40), getWorld().getWidth()/2, getWorld().getHeight()/2 );
            Greenfoot.playSound("fanfare.wav");
            Greenfoot.stop();
        }

    }

    public void hitAvoid()
    {
        if(isTouching(Avoid.class)) {
            Greenfoot.playSound("au.wav");
            setLocation(50,200);
            life = life -1;
            if(life == 0) {
                gameOver();
            }
        }
    }

    public void gameOver()
    {
        Label endGame = new Label("GAME OVER \n Your Final Score is " + myScore.getValue(), 40);
        Greenfoot.playSound("gameover.wav");
        getWorld().addObject( endGame, getWorld().getWidth()/2, getWorld().getHeight()/2);
        Greenfoot.stop();
    }

}
