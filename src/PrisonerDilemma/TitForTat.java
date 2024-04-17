package PrisonerDilemma;

public class TitForTat extends Strategy {
    public boolean cooperate() {
        return prisoner.partnerCheated;
    }
}
