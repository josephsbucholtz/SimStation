package PrisonerDilemma;

import mvc.*;
import simstation.*;

import java.awt.*;

class PrisonerFactory extends SimulationFactory {
    public PrisonerFactory(Color background) {
        super(background);
    }

    public Model makeModel() { return new PrisonerSimulation(); }

    public String getTitle() { return "Prisoner Dilemma Tournament"; }
}