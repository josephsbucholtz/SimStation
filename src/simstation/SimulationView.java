package simstation;
import mvc.*;
import java.awt.*;
import java.util.List;

public class SimulationView extends View{
    protected List<Agent> agents;
    public SimulationView(Model model, Color backgroundColor){
        super(model);
        Simulation sim = (Simulation)model;
        agents = sim.getAgents();
        setBackground(backgroundColor);
    }

    protected void paintComponent(Graphics gc){
        //draw a filled rectangle for each agent
        super.paintComponent(gc);
        Color oldColor = gc.getColor();
        gc.setColor(Color.WHITE);
        Simulation sim = (Simulation) model;
        for (Agent a : sim.getAgents()){
            int xc = a.xc;
            int yc = a.yc;
            int rectSize = 8;
            gc.fillRect(xc, yc, rectSize, rectSize);
        }
        gc.setColor(oldColor);

    }

    @Override
    public void update() {
        repaint();

    }
}