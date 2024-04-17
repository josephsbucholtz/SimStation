package PrisonerDilemma;

public abstract class Strategy {
    Prisoner prisoner = new Prisoner();
    public abstract boolean cooperate();
}