package PrisonerDilemma;


import java.util.ArrayList;

public class AlwaysCheat extends Strategy {
    public AlwaysCheat(Prisoner prisoner) {
        super(prisoner);
        stratMove = false;
    }

    @Override
    public boolean cooperate(ArrayList<Boolean> data) {
        return stratMove;
    }
}
