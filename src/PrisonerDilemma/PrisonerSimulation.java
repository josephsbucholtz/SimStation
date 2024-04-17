package PrisonerDilemma;

import mvc.*;
import PrisonerDilemma.Prisoner;
import simstation.*;
import java.awt.*;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;


public class PrisonerSimulation extends Simulation {

//    public void populate() {
//        for(int i = 0; i < 100; i++)
//            addAgent(new Prisoner());
//    }
//

    public String[] getStats(List<Agent> agents) {
        
        for(Agent agent : agents){
            Prisoner a = (Prisoner) agent;
            a.update();
            int a_fit = a.updateFitness();
        }
        String[] stats = new String[4];
        stats[0] = "average  of alwaysCheat strategy = ";
        stats[1] = "average of alwaysCooperate strategy = ";
        stats[2] = "average randomlyCooperate strategy = ";
        stats[3] = "average of Tit-For-Tat strategy = ";
        return stats;
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PrisonerFactory(Color.DARK_GRAY));
        panel.display();
    }
}
