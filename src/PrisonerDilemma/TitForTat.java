package PrisonerDilemma;

import java.util.ArrayList;

public class TitForTat extends Strategy {

    public TitForTat(Prisoner prisoner) {
        super(prisoner);
    }

    @Override
    public boolean cooperate(ArrayList<Boolean> data) {
        if (data.size() == 0) {
            return false;
        }

        if (data.get(data.size() - 1)) {
            return true;
        }
        else {
            return false;
        }
    }
}
