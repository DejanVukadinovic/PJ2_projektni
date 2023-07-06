package net.etf.unibl.pj2projektni;
import java.util.Random;

public class Bag {
    private boolean is_allowed = true;
    Bag(){
        Random rng = new Random();
        int rand = rng.nextInt(10);
        if(rand==5) is_allowed=false;
    }
    public boolean process(){
        return is_allowed;
    }
}
