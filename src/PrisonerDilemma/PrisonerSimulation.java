package PrisonerDilemma;

import mvc.*;
import simstation.*;
import java.awt.*;



public class PrisonerSimulation extends Simulation {
    private final int SIZE = 100;

    private int cheatStratSize;
    private int coopStratSize;
    private int randomStratSize;
    private int ti4tatStratSize;


    public PrisonerSimulation() {
        super();
        coopStratSize = 0;
        cheatStratSize = 0;
        randomStratSize = 0;
        ti4tatStratSize = 0;
    }

    @Override
    public void populate() {

        Prisoner prisoner = new Prisoner(this);

        for(int i = 0; i < SIZE; i++) {

            switch (Utilities.rng.nextInt(4)) {

                case 0:
                    prisoner = new Prisoner(this);
                    prisoner.setStrategy(new AlwaysCooperate(prisoner));
                    addAgent(prisoner);
                    coopStratSize++;
                    break;
                case 1:
                    prisoner = new Prisoner(this);
                    prisoner.setStrategy(new AlwaysCheat(prisoner));
                    addAgent(prisoner);
                    cheatStratSize++;
                    break;
                case 2:
                    prisoner = new Prisoner(this);
                    prisoner.setStrategy(new RandomlyCooperate(prisoner));
                    addAgent(prisoner);
                    randomStratSize++;
                    break;
                case 3:
                    prisoner = new Prisoner(this);
                    prisoner.setStrategy(new TitForTat(prisoner));
                    addAgent(prisoner);
                    ti4tatStratSize++;
                    break;

            }

        }

    }

    public String[] getStats() {
        double coopAverage = 0, cheatAverage = 0, randomAverage = 0, titfortatAverage = 0;

        for(int i = 0; i < SIZE; i++) {

            Prisoner prisoner = (Prisoner) getAgents().get(i);

            if(prisoner.getStrategy().getClass().equals((new AlwaysCooperate(prisoner)).getClass())) {
                coopAverage += prisoner.getFitness();
            } else if(prisoner.getStrategy().getClass().equals((new AlwaysCheat(prisoner)).getClass())) {
                cheatAverage += prisoner.getFitness();
            } else if(prisoner.getStrategy().getClass().equals((new RandomlyCooperate(prisoner)).getClass())) {
                randomAverage += prisoner.getFitness();
            } else if(prisoner.getStrategy().getClass().equals((new TitForTat(prisoner)).getClass())) {
                titfortatAverage += prisoner.getFitness();
            }

        }
        String[] stats = new String[4];
        stats[0] = "average of alwaysCheat strategy = " + cheatAverage;
        stats[1] = "average of alwaysCooperate strategy = " + coopAverage;
        stats[2] = "average of randomlyCooperate strategy = " + randomAverage;
        stats[3] = "average of Tit-For-Tat strategy = " + titfortatAverage;
        return stats;
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PrisonerFactory(Color.DARK_GRAY));
        PrisonerSimulation simulation = new PrisonerSimulation();
        panel.display();
    }
}
