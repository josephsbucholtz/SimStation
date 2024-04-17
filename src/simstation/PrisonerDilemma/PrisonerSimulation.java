package simstation.PrisonerDilemma;

import simstation.*;
import mvc.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class PrisonerSimulation extends Simulation {
    private final int SIZE = 40;
    public void populate() {
        for(int i=0; i<SIZE; i++) {
            Prisoner prisoner = new Prisoner();
            if(i<(SIZE / 4)) { prisoner.strategy = new AlwaysCheat();
                addAgent(prisoner); }

            else if(i<(SIZE / 2)) { prisoner.strategy = new AlwaysCooperate();
                addAgent(prisoner); }

            else if(i<((SIZE* 3) / 4)) { prisoner.strategy = new RandomlyCooperate();
                addAgent(prisoner); }

            else { prisoner.strategy = new TitForTat();
                addAgent(prisoner); }
        }
    }

    public String[] getStats() {
        String[] stats = new String[6];
        int alwaysCheatTotal=0;
        int alwaysCooperateTotal=0;
        int randomlyCooperateTotal=0;
        int titForTatFitnessTotal=0;
        List<Agent> agents = getAgents();
        List<Prisoner> prisoners = new ArrayList<>();

        for(int i=0; i<agents.size(); i++) {
            prisoners.add((Prisoner) (agents.get(i)));
            if(prisoners.get(i).strategy instanceof AlwaysCheat) {
                alwaysCheatTotal += prisoners.get(i).fitness;
            }
            else if(prisoners.get(i).strategy instanceof AlwaysCooperate) {
                alwaysCooperateTotal += prisoners.get(i).fitness;
            }
            else if(prisoners.get(i).strategy instanceof RandomlyCooperate) {
                randomlyCooperateTotal += prisoners.get(i).fitness;
            }
            else if(prisoners.get(i).strategy instanceof TitForTat) {
                titForTatFitnessTotal += prisoners.get(i).fitness;
            }
        }
        stats[0] = "Prisoners: " + prisoners.size();
        stats[1] = "Average of AlwaysCheat Strategy = " + String.format("%.2f", (double) alwaysCheatTotal/(SIZE/4));
        stats[2] = "Average of AlwaysCooperate Strategy = " + String.format("%.2f", (double) alwaysCooperateTotal/(SIZE / 4));
        stats[3] = "Average of RandomCooperate Strategy = " + String.format("%.2f", (double) randomlyCooperateTotal/(SIZE / 4));
        stats[4] = "Average of TitForTat strategy = " + String.format("%.2f", (double) titForTatFitnessTotal/(SIZE / 4));
        stats[5] = "Clock = " + this.getClock();
        return stats;
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PrisonerFactory(Color.GRAY));
        panel.display();
    }
}