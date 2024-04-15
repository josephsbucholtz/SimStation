package PrisonerDilemma;

import mvc.*;
import PrisonerDilemma.*;
import simstation.*;
import java.awt.*;
import java.util.Iterator;

public class PrisonerSimulation extends Simulation {

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PrisonerFactory(Color.DARK_GRAY));
        panel.display();
    }

}
