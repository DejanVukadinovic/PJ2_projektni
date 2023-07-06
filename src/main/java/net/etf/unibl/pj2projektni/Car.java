package net.etf.unibl.pj2projektni;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.List;
public class Car extends Vehicle{
    public Passenger driver;
    private ArrayList<Passenger> passengers = new ArrayList<Passenger>();
    Car(List<List<Field>> m, int id, ArrayList<Boolean> r){
        super(m, id, r);

        driver = new Passenger();
        Random rng = new Random();
        int num = rng.nextInt(4);
        for(int i=0;i<num;i++){
            Passenger p = new Passenger();
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
