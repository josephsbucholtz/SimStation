package simstation;
import mvc.*;

public abstract class SimulationFactory implements AppFactory{
    public Model makeModel() { return new Simulation(); }

    public View makeView(Model model) {
        return new SimulationView(model);
    }

    public String[] getEditCommands() { return new String[] {"Start, Suspend, Resume, Stop, Stats"}; }

    // source added 3/15 to support text fields
    public Command makeEditCommand(Model model, String type, Object source) {
        if (type == "Start")
            return new StartCommand(model);
        if (type == "Suspend")
            return new SuspendCommand(model);
        if (type == "Resume")
            return new ResumeCommand(model);
        if (type == "Stop")
            return new StopCommand(model);
        if (type == "Stats")
            return new StatsCommand(model);
        return null;

    }

    //public String getTitle() { return "Stack Calculator"; }

    public String[] getHelp() {
        return new String[] {"Start: starts the simulation",
                "Suspend: suspends the simulation",
                "Resume: resumes the simulation",
                "Stop: stops the simulation",
                "Stats: shows the time and number of agents"};
    }

    public String about() {
        return "SimStation version 1.0. Copyright 2020 by Maik Designs";
    }

}
