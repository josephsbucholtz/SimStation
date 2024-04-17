package PrisonerDilemma;
import simstation.*;
import mvc.*;
import PrisonerDilemma.*;

import java.util.ArrayList;


class Prisoner extends Agent {
    protected int fitness = 0;
    protected boolean partnerCheated = false;
    private Strategy strategy;
    private ArrayList<Boolean> data;
    private PrisonerSimulation simulation;

    public Prisoner(PrisonerSimulation simulation) {
        super("Prisoner");
        this.strategy = null;
        data = new ArrayList<>();
        this.simulation = simulation;
    }

    public void addFitness(int fitness) {
        this.fitness += fitness;
    }

    public int getFitness() {
        return fitness;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public ArrayList<Boolean> getData() {
        return data;
    }

    public Boolean strategy() {
        return strategy.cooperate(getData());
    }

    public void addData(Boolean tradeRes) {
        data.add(tradeRes);
    }

    public void trade(Prisoner neighbor) {
        Boolean prisStrat1 = strategy();
        Boolean prisStrat2 = neighbor.strategy();

        if(!prisStrat1 && prisStrat2) {
            addFitness(5);
            neighbor.addFitness(0);
        } else if(prisStrat1 && prisStrat2) {
            addFitness(3);
            neighbor.addFitness(3);
        } else if(prisStrat1) {
            addFitness(0);
            neighbor.addFitness(5);
        } else {
            addFitness(1);
            neighbor.addFitness(1);
        }

        addData(prisStrat2);
        neighbor.addData(prisStrat1);
    }

    @Override
    public void update() {
        PrisonerSimulation prison = (PrisonerSimulation) simulation;
        Prisoner neighbor = (Prisoner) prison.getNeighbor(this, 5);

        if(neighbor != null)
            trade(neighbor);

        simulation.changed();
    }

    public void updateFitness(int amt) {
        fitness += amt;
    }
}