package SimStation.randomWalks;

import mvc.*;
import SimStation.*;


class Drunk extends Agent {
    private Heading heading;

    public Drunk() {
        super("Random Walk Agent");
        heading = Heading.random();
    }
    @Override
    public Heading getHeading(){
        return heading;
    }
    public void update() {
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);
    }

}
