package PrisonerDilemma;

import mvc.*;
import PrisonerDilemma.*;
import simstation.*;
import java.awt.*;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;


public class PrisonerSimulation extends Simulation {
    public String[] getStats() {
        String[] stats = new String[4];
        stats[0] = "average always cheat fitness = ";
        stats[1] = "average always cooperate fitness = ";
        stats[2] = "average randomly cooperate fitness = ";
        stats[3] = "average tit-for-tat fitness = ";
        return stats;
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PrisonerFactory(Color.DARK_GRAY));
        panel.display();
    }
}
