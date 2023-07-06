package net.etf.unibl.pj2projektni;

import java.util.ArrayList;
import java.util. Random;
import java.util.List;
public class Truck extends Vehicle{
    private Passenger driver;
    private ArrayList<Passenger> passengers = new ArrayList<Passenger>();
    private long declaredWeigth;
    private long actualWeight;
    private boolean needs_papers = false;

    Truck(List<List<Field>> l, int ind, ArrayList<Boolean> r){
        super(l, ind, r);
        driver = new Passenger();
        Random rng = new Random();
        int num = rng.nextInt(2);
        for(int i=0;i<num;i++){
            Passenger p = new Passenger();
            passengers.add(p);
        }
        declaredWeigth = Math.round(10000+Math.random()*8000);
        if(Math.random()<0.2){
            actualWeight = Math.round(declaredWeigth*(1+(Math.random()*0.3)));
        }else actualWeight = declaredWeigth;
        if(Math.random()>0.5) needs_papers = true;

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