package SimStation;

import mvc.Publisher;
import mvc.Utilities;

import java.awt.*;
import java.io.Serializable;

import static mvc.AppPanel.FRAME_HEIGHT;
import static mvc.AppPanel.FRAME_WIDTH;

public abstract class Agent extends Publisher implements Runnable, Serializable {
    protected String name;
    protected int xc;
    protected int yc;
    protected boolean suspended, stopped;
    transient protected Thread myThread;
    protected Simulation world;


    public Agent(String name){
        this.name = name;
        xc = Utilities.rng.nextInt(FRAME_WIDTH / 2);
        yc = Utilities.rng.nextInt(FRAME_HEIGHT);
        suspended = false;
        stopped = false;
        myThread = null;
    }

    public int getXc() {
        return xc;
    }

    public int getYc() {
        return yc;
    }

    public void setSimulation(Simulation world) { this.world = world; }
    public String getName() { return name; }
    public synchronized String toString() {
        String result = name;
        if (stopped) result += " (stopped)";
        else if (suspended) result += " (suspended)";
        else result += " (running)";
        return result;
    }
    // thread stuff:
    public synchronized boolean isStopped() { return stopped; }
    public synchronized void start(){suspended = false; stopped = false;}
    public synchronized void suspend() { suspended = true; }
    public synchronized boolean isSuspended() { return suspended;  }
    public synchronized void resume() { notify(); }
    public synchronized void stop() { stopped = true; }
    // wait for me to die:
    public synchronized void join() {
        try {
            if (myThread != null) myThread.join();
        } catch(InterruptedException e) {
            world.println(e.getMessage());
        }
    }
    // wait for notification if I'm not stopped and I am suspended
    private synchronized void checkSuspended() {
        try {
            while(!stopped && suspended) {
                wait();
                suspended = false;
            }
        } catch (InterruptedException e) {
            world.println(e.getMessage());
        }
    }

    //These can be overridden in subclasses if needed.
    public void onStart(){}
    public void onInterrupted(){}
    public void onExit(){}

//At strategic places Agent.run calls empty methods: onStart, onInterrupted, and OnExit.
    public void run() {
        onStart();
        myThread = Thread.currentThread();
        while (!isStopped()) {
            try {
                update();
                Thread.sleep(20);
                checkSuspended();
            } catch(InterruptedException e) {
                onInterrupted();
                world.println(e.getMessage());
            }
        }
        onExit();
        world.println(name + " stopped");
    }

    public void move(int steps){
        Heading direction = this.getHeading();
        while (steps > 0){
            steps--;
            switch (direction){
                case NORTH:
                    yc -= 1;
                    break;
                case EAST:
                    xc += 1;
                    break;
                case SOUTH:
                    yc += 1;
                    break;
                case WEST:
                    xc -= 1;
                    break;
            }
            // Check for wrapping around the screen on the x-axis
            if (xc >= FRAME_WIDTH / 2) {
                xc = 1;
            } else if (xc < 0) {
                xc = FRAME_WIDTH / 2 - 1;
            }

            // Check for wrapping around the screen on the y-axis
            if (yc >= FRAME_HEIGHT) {
                yc = 1;
            } else if (yc < 0) {
                yc = FRAME_HEIGHT - 1;
            }
            world.changed();
        }
    }

    public Heading getHeading(){
        return null;
    }

    public abstract void update();

}
