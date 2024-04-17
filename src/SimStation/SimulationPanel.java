package SimStation;

import mvc.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Iterator;

public class SimulationPanel extends AppPanel {
    private JButton start;
    private JButton suspend;
    private JButton resume;
    private JButton stop;
    private JButton stats;

    public SimulationPanel(AppFactory factory){
        super(factory);

        start = new JButton("Start");
        suspend = new JButton("Suspend");
        resume = new JButton("Resume");
        stop = new JButton("Stop");
        stats = new JButton("Stats");

        start.addActionListener(this);
        suspend.addActionListener(this);
        resume.addActionListener(this);
        stop.addActionListener(this);
        stats.addActionListener(this);

        controlPanel.add(start);
        controlPanel.add(suspend);
        controlPanel.add(resume);
        controlPanel.add(stop);
        controlPanel.add(stats);

    }

    public void setModel(Model m) {
        super.setModel(m); // calling AppPanel.setModel(m)
        Simulation s = (Simulation)m;
        Iterator<Agent> it = s.iterator();
        while(it.hasNext()) {
            Thread t = new Thread(it.next());
            t.start(); // this will call Agent.run (see below)
        }
    }

}
