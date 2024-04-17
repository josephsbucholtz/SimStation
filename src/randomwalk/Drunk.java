package randomwalk;

import mvc.*;
import simstation.*;
import java.awt.*;
import java.util.Iterator;

class Drunk extends Agent {
    private Heading heading;
    private int steps;

    public Drunk() {
        super();
        heading = Heading.random();
    }
    @Override
    public Heading getHeading(){
        return heading;
    }
    public void update() {
        heading = Heading.random();
        steps = Utilities.rng.nextInt(10) + 1;
        move(steps);
    }

}