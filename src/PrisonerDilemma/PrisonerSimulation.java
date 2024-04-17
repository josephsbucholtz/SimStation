package PrisonerDilemma;

import mvc.*;
import PrisonerDilemma.*;
import simstation.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;


public class PrisonerSimulation extends Simulation {
    private ArrayList<Integer> arr = new ArrayList<>();

    @Override
    public void populate() {
        for (int i = 0; i < 100; i++)
            addAgent(new Prisoner());
    }

    @Override
    public String[] getStats(List<Agent> agents) {
        int n = agents.size();
        if (n < 4) {
            return new String[]{"Insufficient agents for calculation"};
        }

        // Clear the ArrayList before populating with new fitness values
        arr.clear();

        for (Agent agent : agents) {
            Prisoner a = (Prisoner) agent;
            a.update();
            arr.add(a.fitness);
        }

        String[] stats = new String[4];
        stats[0] = "average of alwaysCheat strategy = " + calculateAverageFitness(arr, 0, n / 4);
        stats[1] = "average of alwaysCooperate strategy = " + calculateAverageFitness(arr, n / 4, n / 2);
        stats[2] = "average of randomlyCooperate strategy = " + calculateAverageFitness(arr, n / 2, (3 * n) / 4);
        stats[3] = "average of Tit-For-Tat strategy = " + calculateAverageFitness(arr, (3 * n) / 4, n);
        return stats;
    }

    private double calculateAverageFitness(ArrayList<Integer> arr, int startIndex, int endIndex) {
        double sum = 0;
        for (int i = startIndex; i < endIndex; i++) {
            sum += arr.get(i);
        }
        return sum / (endIndex - startIndex);
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PrisonerFactory(Color.DARK_GRAY));
        panel.display();
    }
}
