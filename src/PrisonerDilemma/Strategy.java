package PrisonerDilemma;

import java.util.ArrayList;

public abstract class Strategy {
    private Prisoner prisoner;
    protected boolean stratMove;

    public Strategy (Prisoner prisoner) {
        this.prisoner = prisoner;
    }
    public abstract boolean cooperate(ArrayList<Boolean> data);
}
