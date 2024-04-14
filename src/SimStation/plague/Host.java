package SimStation.plague;

import SimStation.Agent;
import SimStation.Heading;
import mvc.Utilities;

import java.awt.*;

import static SimStation.plague.PlagueSimulation.RESISTANCE;
import static SimStation.plague.PlagueSimulation.VIRULENCE;


public class Host extends Agent {
    protected Color color;

    private Heading heading;

    public Host() {
        super("Plague Host");
        heading = Heading.random();
        color = Color.GREEN;
    }

    public Heading getHeading(){
        return heading;
    }

    private void setHostColor(){
        int infectionChance = Utilities.rng.nextInt(100);
        if (infectionChance < VIRULENCE){
            this.color = Color.RED;
        }
        else {
            this.color = Color.GREEN;
        }
    }

    public Color getColor(){
        return color;
    }

    public void update(){
        heading = Heading.random();
        setHostColor();
        int steps = Utilities.rng.nextInt(10) + 1;
        Host partner = (Host) world.getNeighbor(this, 10);
        if (partner != null){
            //There is a 2% chance of resisting the infection
            int resistance = Utilities.rng.nextInt(100);
            if (resistance >= 2){
                partner.color = Color.RED;
//                System.out.println(partner.color);
            }
        }
        move(steps);

    }
}
