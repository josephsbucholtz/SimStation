package SimStation;

import mvc.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

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

}
