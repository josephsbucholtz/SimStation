package SimStation.plague;

import SimStation.Agent;
import SimStation.Simulation;
import SimStation.SimulationPanel;

import mvc.AppPanel;
import mvc.Utilities;

import java.awt.*;

public class PlagueSimulation extends Simulation {
    public static int VIRULENCE = 50; // % chance of infection
    public static int RESISTANCE = 2; // % chance of resisting infection

    public void populate(){
        for (int i = 0; i < 50; i++){
            addAgent(new Host());
        }
    }
    //ToDo: implement this method
    @Override
    public Host getNeighbor(Agent current, int steps){
        int startingPoint = Utilities.rng.nextInt(getAgents().size());

        for (int offset = 0; offset < getAgents().size(); offset++){
            int index = (startingPoint + offset) % getAgents().size();
            Host neighbor = (Host)getAgents().get(index);
            int xcDifference = Math.abs(current.getXc() - neighbor.getXc());
            int ycDifference = Math.abs(current.getYc() - neighbor.getYc());

            if ((xcDifference != 0 && ycDifference != 0) && xcDifference < 10 || ycDifference < 10){
                return neighbor;
            }
            else {
                continue;
            }
        }
        return null;
    }

    @Override
    public String[] getStats(){
            String[] stats = new String[3];
            stats[0] = "#agents = " + this.size();
            stats[1] = "clock = " + this.getClock();
            stats[2] = "% infected = " + getPercentInfected();
            return stats;
    }
    //ToDo: not correct
    private double getPercentInfected(){
        int numberInfected = 0;
        for (int i = 0; i < getAgents().size(); i++){
            Host h = (Host) getAgents().get(i);
            if (h.getColor() == Color.RED){
                numberInfected++;
            }
        }
        return numberInfected / 50.0 * 100;
    }



    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PlagueFactory(Color.WHITE));
        panel.display();
    }

}
