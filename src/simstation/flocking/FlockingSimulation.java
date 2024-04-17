package simstation.flocking;
import mvc.*;
import java.awt.*;
import simstation.*;

public class FlockingSimulation extends Simulation{
    public void populate(){
        for(int i = 0; i< 50; i++){
            addAgent(new Bird());
        }
    }
    @Override
    public String[] getStats(){
        String[] stats = new String[this.size()];
        for(int i =0; i<stats.length; i++){
            Bird agent = (Bird)getAgents().get(i);
            int j = i+1;
            stats[i] = "#birds @ speed " + j + " = " + agent.getSpeed();
        }
        return stats;
    }
    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new FlockingFactory(Color.DARK_GRAY));
        panel.display();
    }
}