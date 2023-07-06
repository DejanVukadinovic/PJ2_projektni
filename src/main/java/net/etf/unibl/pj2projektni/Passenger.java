package net.etf.unibl.pj2projektni;

import java.util.Random;
public class Passenger {

    protected boolean documentation_valid = true;

    public Passenger() {
        super();
        Random rng = new Random();
        int rand = rng.nextInt(100);
        if (rand < 4) {
            documentation_valid = false;
        }
    }

    public boolean getDocumentation() {
        return documentation_valid;
    }
}

