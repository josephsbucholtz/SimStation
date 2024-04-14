package SimStation.plague;

import SimStation.Agent;
import SimStation.Simulation;
import SimStation.SimulationView;
import mvc.Model;

import java.awt.*;

public class PlagueView extends SimulationView {

    public PlagueView(Model model, Color backgroundColor) {
        super(model, backgroundColor);
    }

    @Override
    protected void paintComponent(Graphics gc){
        //draw a filled rectangle for each agent
        super.paintComponent(gc);
        Color oldColor = gc.getColor();
        Simulation sim = (Simulation) model;
        for (Agent a : sim.getAgents()){
            Host h = (Host) a;
            int xc = h.getXc();
            int yc = h.getYc();
            int rectSize = 8;

            gc.setColor(h.getColor());
            gc.fillRect(xc, yc, rectSize, rectSize);
        }
        System.out.println("PlagueView's paintComponent");
        gc.setColor(oldColor);
    }

    @Override
    public void update() {
        repaint();
    }
}
