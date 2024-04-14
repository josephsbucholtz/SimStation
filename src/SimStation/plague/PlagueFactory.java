package SimStation.plague;

import SimStation.SimulationFactory;
import SimStation.randomWalks.RandomWalksSimulation;
import mvc.Model;

import java.awt.*;

public class PlagueFactory extends SimulationFactory {
    public PlagueFactory(Color background){
        super(background);
    }
    public Model makeModel() { return new PlagueSimulation(); }
    public String getTitle() { return "Plague";}
}
