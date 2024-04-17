package SimStation.flocking;
import SimStation.SimulationFactory;
import mvc.*;
import java.awt.*;

public class FlockingFactory extends SimulationFactory {
    public FlockingFactory(Color background){
        super(background);
    }
    public Model makeModel() { return new FlockingSimulation(); }
    public String getTitle() { return "Flocking Simulator";}
}
