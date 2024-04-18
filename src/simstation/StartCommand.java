package simstation;
import mvc.*;

public class StartCommand extends Command{
    public StartCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() throws Exception {
        if (!(model instanceof Simulation sim)){
            throw new Exception("Model must instantiate Simulation");
        }

        sim.getAgents().clear();
        sim.populate();
        sim.startTimer();
        for (Agent a : sim.getAgents()) {
            Thread thread = new Thread(a);
            a.start();
            thread.start();
        }

    }
}
