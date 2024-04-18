package simstation;

import mvc.*;
import java.awt.*;

public abstract class SimulationFactory implements AppFactory {
    public abstract Model makeModel();
    protected Color background;

    public SimulationFactory(Color background) {
        this.background = background;
    }

    @Override
    public View makeView(Model m) {
        return new SimulationView(m, background);
    }

    @Override
    public String getTitle() {
        return "SimStation";
    }

    @Override
    public String[] getHelp() {
        return new String[]{
                "Click on Start button to start simulation",
                "Click on Suspend button to suspend simulation",
                "Click on Resume button to resume simulation",
                "Click on Stop button to stop simulation",
                "Click on Stats button to show the number of agents and time of simulation"
        };
    }

    @Override
    public String about() {
        return "SimStation Version 1.0";
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        switch (type){
            case "Start": {
                return new StartCommand(model);
            }
            case "Suspend": {
                return new SuspendCommand(model);
            }
            case "Resume": {
                return new ResumeCommand(model);
            }
            case "Stop": {
                return new StopCommand(model);
            }
            case "Stats": {
                return new StatsCommand(model);
            }
            default: return null;
        }
    }

    @Override
    public String[] getEditCommands() {
        return new String[] {"Start", "Suspend", "Resume", "Stop", "Stats"};
    }
}