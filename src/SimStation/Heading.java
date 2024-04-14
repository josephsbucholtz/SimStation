package SimStation;

import mvc.Utilities;

public enum Heading {
    NORTH, EAST, SOUTH, WEST;

    public static Heading parse(String heading){
        if (heading.equalsIgnoreCase("north")) return NORTH;
        if (heading.equalsIgnoreCase("south")) return SOUTH;
        if (heading.equalsIgnoreCase("east")) return EAST;
        if (heading.equalsIgnoreCase("west")) return WEST;
        Utilities.error("Invalid heading" + heading);
        return null;
    }
    public static Heading random(){
        int rand = Utilities.rng.nextInt(4);
        if (rand == 0) return NORTH;
        if (rand == 1) return SOUTH;
        if (rand == 2) return EAST;
        return WEST;
    }
}
