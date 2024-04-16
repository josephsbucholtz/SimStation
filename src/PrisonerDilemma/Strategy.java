package PrisonerDilemma;
import mvc.*;

interface Strategy {
    boolean cooperate(boolean lastOpponentCooperated);
}

class AlwaysCooperateStrategy implements Strategy {
    public boolean cooperate(boolean lastOpponentCooperated) {
        return true;
    }
}

class AlwaysCheatStrategy implements Strategy {
    public boolean cooperate(boolean lastOpponentCooperated) {
        return false;
    }
}

class RandomCooperateStrategy implements Strategy {
    public boolean cooperate(boolean lastOpponentCooperated) {
        return Utilities.rng.nextBoolean();
    }
}

class TitForTatStrategy implements Strategy {
    public boolean cooperate(boolean lastOpponentCooperated) {
        return lastOpponentCooperated;
    }
}