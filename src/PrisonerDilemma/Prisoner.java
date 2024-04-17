package PrisonerDilemma;
import simstation.*;
import java.util.List;
import java.util.Random;


class Prisoner extends Agent {
    protected int fitness = 0;
    protected boolean partnerCheated = false;
    private Strategy strategy;
    private List<Prisoner> neighbors;

    public Prisoner() {
        super("Prisoner");
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public boolean cooperate() {
        return strategy.cooperate(partnerCheated);
    }

    public void update() {
        if (neighbors.isEmpty()) {
            // No neighbor, so nothing to update
            return;
        }

        Prisoner opponent = neighbors.get(new Random().nextInt(neighbors.size()));
        boolean opponentCooperated = opponent.cooperate();

        if (cooperate() && opponentCooperated) {
            // Both prisoners cooperated
            fitness += 3;
            opponent.fitness += 3;
        } else if (!cooperate() && opponentCooperated) {
            // Current prisoner cheated, opponent cooperated
            fitness += 5;
            opponent.fitness += 0;
        } else if (cooperate() && !opponentCooperated) {
            // Current prisoner cooperated, opponent cheated
            fitness += 0;
            opponent.fitness += 5;
        } else {
            // Both prisoners cheated
            fitness += 1;
            opponent.fitness += 1;
        }

        partnerCheated = !opponentCooperated;
    }


    public int updateFitness() {
        return fitness;
    }
}