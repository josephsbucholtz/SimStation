package SimStation.randomWalks;

import mvc.*;
import SimStation.*;
import java.awt.*;
import java.util.Iterator;

class RandomWalksFactory extends SimulationFactory {
    public RandomWalksFactory(Color background){
        super(background);
    }
    public Model makeModel() { return new RandomWalksSimulation(); }
    public String getTitle() { return "Random Walks";}
}
