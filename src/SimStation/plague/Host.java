package SimStation.plague;

import SimStation.Agent;
import SimStation.Heading;
import SimStation.Simulation;
import mvc.Utilities;

import java.awt.*;

import static SimStation.plague.PlagueSimulation.*;


public class Host extends Agent {
    private Heading heading;
    private boolean infected;
    private boolean resistant;

    public Host() {
        super("Plague Host");
        heading = Heading.random();
        int initialInfected = Utilities.rng.nextInt(100);
        int resistantChance = Utilities.rng.nextInt(100);
        if (initialInfected < percentInfected) {
            if (resistantChance < RESISTANCE) {
                infected = false;
                resistant = true;
            }
            else {
                infected = true;
            }
        }
        else {
            infected = false;
        }
    }

    public Heading getHeading(){
        return heading;
    }

    public boolean getInfected(){
        return infected;
    }

    public void update(){
        //When this host is infected, find a nearby neighbor
        //If neighbor isn't infected and isn't resistant, there is a 50% chance that neighbor will be infected
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        Host partner = world.getNeighbor(this, 10);
        if (this.infected && partner != null){
                int infectionChance = Utilities.rng.nextInt(100);
                if (infectionChance < VIRULENCE && !(partner.resistant) && !(partner.getInfected())){
                    partner.infected = true;
                }
        }
        move(steps);
    }
}
