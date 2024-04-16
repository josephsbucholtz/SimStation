package SimStation.plague;

import SimStation.Agent;
import SimStation.Simulation;
import SimStation.SimulationPanel;
import mvc.AppPanel;
import java.awt.*;

public class PlagueSimulation extends Simulation {
    public static int VIRULENCE = 50; // % chance of infection
    public static int RESISTANCE = 2; // % chance of resisting infection
    public static int percentInfected = 10;

    public void populate(){
        for (int i = 0; i < 50; i++){
            addAgent(new Host());
        }
    }

    @Override
    public String[] getStats() {
        String[] stats = new String[3];
        stats[0] = "#agents = " + this.size();
        stats[1] = "clock = " + this.getClock();
        stats[2] = "% infected = " + getPercentInfected();
        return stats;
    }

    private double getPercentInfected(){
        double numberInfected = 0;
        for (Agent a : getAgents()){
            Host h = (Host)a;
            if (h.getInfected()){
                numberInfected++;
            }
        }
        return (numberInfected / getAgents().size()) * 100;
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PlagueFactory(Color.WHITE));
        panel.display();
    }

}
