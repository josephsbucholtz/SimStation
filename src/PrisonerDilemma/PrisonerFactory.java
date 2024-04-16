package PrisonerDilemma;

import mvc.*;
import PrisonerDilemma.PrisonerSimulation;
import simstation.*;
import java.awt.*;
import java.util.Iterator;

class PrisonerFactory extends SimulationFactory {
    public PrisonerFactory(Color background){
        super(background);
    }
    public Model makeModel() { return new PrisonerSimulation(); }
    public String getTitle() { return "Prisoner Dilemma Tournament";}
}