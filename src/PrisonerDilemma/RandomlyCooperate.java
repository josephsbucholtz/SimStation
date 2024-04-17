package PrisonerDilemma;

import mvc.*;

import java.util.ArrayList;

public class RandomlyCooperate extends Strategy {

    public RandomlyCooperate(Prisoner prisoner) {
        super(prisoner);
    }

    @Override
    public boolean cooperate(ArrayList<Boolean> data) {
        return Utilities.rng.nextBoolean();
    }
}
