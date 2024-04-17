package PrisonerDilemma;

import java.util.ArrayList;

public class AlwaysCooperate extends Strategy {

    public AlwaysCooperate(Prisoner prisoner) {
        super(prisoner);
        stratMove = true;
    }

    @Override
    public boolean cooperate(ArrayList<Boolean> data) {
        return stratMove;
    }
}
