package SimStation.randomWalks;

import mvc.*;
import SimStation.*;
import java.awt.*;
import java.util.Iterator;
public class RandomWalksSimulation extends Simulation {
    public void populate() {
        for(int i = 0; i < 15; i++)
            addAgent(new Drunk());
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new RandomWalksFactory(Color.DARK_GRAY));
        panel.display();
    }

}
