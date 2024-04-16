package SimStation.plague;

import SimStation.SimulationFactory;
import mvc.Model;
import mvc.View;

import java.awt.*;

public class PlagueFactory extends SimulationFactory {
    public PlagueFactory(Color background){
        super(background);
    }
    public Model makeModel() { return new PlagueSimulation(); }
    public View makeView(Model m){
        return new PlagueView(m, background);
    }
    public String getTitle() { return "Plague";}
}
