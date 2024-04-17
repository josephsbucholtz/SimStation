package simstation.flocking;
import mvc.*;
import java.awt.*;
import simstation.*;

public class FlockingFactory extends SimulationFactory{
    public FlockingFactory(Color background){
        super(background);
    }
    public Model makeModel() { return new FlockingSimulation(); }
    public String getTitle() { return "Flocking Simulator";}
}