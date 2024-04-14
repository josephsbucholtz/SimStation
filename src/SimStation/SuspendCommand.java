package SimStation;

import mvc.*;

public class SuspendCommand extends Command{
    public SuspendCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() throws Exception {
        if (!(model instanceof Simulation)){
            throw new Exception("Model must instantiate Simulation");
        }
        Simulation sim = (Simulation)model;
        sim.stopTimer();
        for (Agent a : sim.getAgents()) {
            a.suspend();
        }
    }
}