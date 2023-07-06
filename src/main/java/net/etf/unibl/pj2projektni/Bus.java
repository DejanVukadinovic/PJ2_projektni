package net.etf.unibl.pj2projektni;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.List;
public class Bus extends Vehicle{
    private Passenger driver;
    private ArrayList<Passenger> passengers = new ArrayList<Passenger>();
    Bus(List<List<Field>> l, int ind, ArrayList<Boolean> r){
        super(l, ind, r);
        driver = new BusPassenger();
        Random rng = new Random();
        int num = rng.nextInt(51);
        for(int i=0;i<num;i++){
            Passenger p = new BusPassenger();
            passengers.add(p);
        }
    }
    public ArrayList<Passenger> getPassengers(){
        return passengers;
    }
    public void setPassengers(ArrayList<Passenger> arr){
        passengers = arr;
    }
    public Passenger getDriver(){
        return driver;
    }

}
