package simstation;

import java.util.*;
import mvc.*;

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

    public void setNeighbors(List<Agent> agents) {
        for(Agent agent : agents){
            agent.setNeighbors(agents);
        }
    }

    public int size(){
        return agents.size();
    }

    // provides agents with thread safe access to Console.stdout:
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

    public Agent getNeighbor(Agent current, int steps) {
        double minDistance = Double.MAX_VALUE;
        Agent nearestNeighbor = null;

        for (Agent agent : agents) {
            if (agent != current) {
                double distance = distance(agent, current);
                if (distance <= steps && distance < minDistance) {
                    minDistance = distance;
                    nearestNeighbor = agent;
                }
            }
        }

        return nearestNeighbor;
    }

    private double distance(Agent agent1, Agent agent2) {
        int dx = agent1.getXc() - agent2.getXc();
        int dy = agent1.getYc() - agent2.getYc();
        return Math.sqrt(dx * dx + dy * dy);
    }

}