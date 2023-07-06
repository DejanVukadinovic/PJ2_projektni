package net.etf.unibl.pj2projektni;

import java.util.Random;
public class BusPassenger extends Passenger{
    private Bag bag;
    BusPassenger(){
        Random rng = new Random();
        int rand = rng.nextInt(10);
        if(rand<7) bag = new Bag();
        else bag = null;
    }
    public Bag getBag(){
        return bag;
    }
}
