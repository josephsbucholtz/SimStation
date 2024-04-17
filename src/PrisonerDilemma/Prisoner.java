package PrisonerDilemma;

import simstation.*;
import mvc.Utilities;

public class Prisoner extends Agent {
    protected int fitness = 0;
    protected boolean partnerCheated = false;
    Strategy strategy;

    public Prisoner() {
        super();
        heading = Heading.random();
    }

    @Override
    public Heading getHeading() {
        return Heading.random();
    }

    public boolean cooperate() {
        return strategy.cooperate();
    }

    public void update() {
        Prisoner pris2 = (Prisoner) world.getNeighbor(this, 10);

        // Check if p2 is null
        if (pris2 == null) {
            return;
        }

        boolean coop1 = this.cooperate();
        boolean coop2 = pris2.cooperate();

        pris2.partnerCheated = coop1;
        this.partnerCheated = coop2;
        if(coop1 && coop2) { this.updateFitness(3); pris2.updateFitness(3); }
        else if(coop1 && !coop2) { this.updateFitness(0); pris2.updateFitness(5); }
        else if(!coop1 && coop2) { this.updateFitness(5); pris2.updateFitness(0); }
        else { this.updateFitness(1); pris2.updateFitness(1); }
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);
    }

    public void updateFitness(int amt) {
        fitness += amt;
    }

}