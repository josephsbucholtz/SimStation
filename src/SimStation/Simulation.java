package SimStation;

import SimStation.plague.Host;
import mvc.Model;
import mvc.Utilities;

import java.util.*;

public class Simulation extends Model {
    private List<Agent> agents;
    transient private Timer timer; // timers aren't serializable
    private int clock;

    public Simulation(){
        agents = new ArrayList<Agent>();
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public int size(){
        return agents.size();
    }

    public synchronized void println(String msg) {
        System.out.println(msg);
    }

    public synchronized Iterator<Agent> iterator() {
        return agents.iterator();
    }
    public void addAgent(Agent a) {
        agents.add(a);
        a.setSimulation(this);
    }

    public synchronized void remAgent(Agent a){
        agents.remove(a);
        a.stop();
    }

    //To be overridden in subclasses
    public void populate(){}

    public Host getNeighbor(Agent current, int steps){
        int startingPoint = Utilities.rng.nextInt(getAgents().size());

        for (int offset = 0; offset < getAgents().size(); offset++){
            int index = (startingPoint + offset) % getAgents().size();
            Host neighbor = (Host)getAgents().get(index);
            int xcDifference = Math.abs(current.getXc() - neighbor.getXc());
            int ycDifference = Math.abs(current.getYc() - neighbor.getYc());

            if ((xcDifference != 0 && ycDifference != 0) && xcDifference < 10 || ycDifference < 10){
                return neighbor;
            }
            else {
                continue;
            }
        }
        return null;
    }
    public String[] getStats(){
        String[] stats = new String[2];
        stats[0] = "#agents = " + this.size();
        stats[1] = "clock = " + this.getClock();
        return stats;
     }

    public void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
    }

    public void stopTimer() {
        timer.cancel();
        timer.purge();
    }

    public int getClock(){
        return clock;
    }
    private class ClockUpdater extends TimerTask {
        public void run() {
            clock++;
        }
    }

}
