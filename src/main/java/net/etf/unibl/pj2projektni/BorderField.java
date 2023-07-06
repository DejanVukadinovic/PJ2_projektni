package net.etf.unibl.pj2projektni;

import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class BorderField extends Field {
    boolean truckOnly = false;
    ArrayList<Vehicle> tlv = new ArrayList<Vehicle>();
    ArrayList<Passenger> passengers = new ArrayList<Passenger>();
    ArrayList<Passenger> stayingPassengers = new ArrayList<Passenger>();
    private int id;
    private Boolean avaliable = true;
    private File config = new File("borderConfig.txt");
    private HashMap<Vehicle, ArrayList<Report>> reports;

    BorderThread br = new BorderThread(tlv, avaliable, passengers, id, stayingPassengers, reports);
    BorderField(int id){
        //tlv.add(null);
        this.id=id;
        Thread bt = new Thread(br);
        bt.setDaemon(true);
        bt.start();
        //tp.setValue(false);
    }
    BorderField(boolean t, int id){
        truckOnly = t;
        this.id=id;
        Thread bt = new Thread(br);
        bt.setDaemon(true);
        bt.start();
        //tp.setValue(false);


    }
    BorderField(boolean t, int id, File f){
        truckOnly = t;
        this.id=id;
        this.config = f;
        Thread bt = new Thread(br);
        bt.setDaemon(true);
        bt.start();
        //tp.setValue(false);


    }
    BorderField(boolean t, int id, File f, HashMap<Vehicle, ArrayList<Report>> reports){
        truckOnly = t;
        this.id=id;
        this.config = f;
        Thread bt = new Thread(br);
        bt.setDaemon(true);
        bt.start();
        //tp.setValue(false);
        this.reports = reports;


    }
    BorderField(boolean t, int id, HashMap<Vehicle, ArrayList<Report>> reports){
        truckOnly = t;
        this.id=id;
        Thread bt = new Thread(br);
        bt.setDaemon(true);
        bt.start();
        //tp.setValue(false);
        this.reports = reports;


    }
    public boolean isAvaliable(Vehicle v){
        try{

            if(config.exists()){
                FileReader fr = new FileReader(config);
                int i, ind=0;
                while((i = fr.read())!=-1){
                    if(ind==id){
                        if(i==0){
                            return false;
                        }
                        break;
                    }ind++;
                }}
        }catch(IOException e){}
        if((truckOnly && v instanceof Truck) || (!truckOnly && !(v instanceof Truck))){
            //return (tp.getValue());
            return passengers.size()==0;
        }return false;
    }
    public void setVehicle(Vehicle v){
        vehicle=v;


        if(v!=null){
            avaliable=false;
            passengers.add(v.getDriver());
            for(Passenger p : v.getPassengers()){
                passengers.add(p);
            }
            tlv.add(v);

        }
    }
    public boolean canAdvance(){

        return passengers.size()==0;
    }
    public boolean removeYourself(){
        if(passengers.size()==0 && !stayingPassengers.isEmpty()){
            System.out.println("remaining: "+stayingPassengers.size());
            System.out.println("vehicle: "+(stayingPassengers.get(0) == vehicle.getDriver()));
            if(stayingPassengers.get(0) == vehicle.getDriver()){
                stayingPassengers.clear();
                return false;
            }

            stayingPassengers.clear();
        }
        return true;
    }
}