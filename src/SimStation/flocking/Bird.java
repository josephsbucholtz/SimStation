package SimStation.flocking;
import SimStation.*;
import mvc.*;
public class Bird extends Agent {
    public int speed;
    Heading heading;
    public Bird(){
        super("Flocking Agent");
        heading = Heading.random();
        speed = Utilities.rng.nextInt(25) + 1;
    }
    public int getSpeed(){
        return speed;
    }
    @Override
    public Heading getHeading(){
        return heading;
    }

    public void update(){
        // cast neighbor here which matches it for each customization
        Bird neighbor = (Bird) world.getNeighbor(this, 10);
        if(neighbor != null){
            heading = neighbor.heading;
            speed = neighbor.speed;
        }
        else{
            heading = Heading.random();
        }
        move(speed);
    }
}