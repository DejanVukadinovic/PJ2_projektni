package net.etf.unibl.pj2projektni;

import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class CustomsField extends Field {

    boolean truckOnly = false;
    ArrayList<Vehicle> tlv = new ArrayList<Vehicle>();
    ArrayList<Passenger> passengers = new ArrayList<Passenger>();
    ArrayList<Boolean> blockers = new ArrayList<Boolean>();
    private File config = new File("borderConfig.txt");
    private int id;

    Boolean avaliable = true;
    CustomsThread br = new CustomsThread(tlv, avaliable, passengers, blockers);

    CustomsField(int id) {
        //tlv.add(null);
        Thread bt = new Thread(br);
        this.id=id;
        bt.setDaemon(true);
        bt.start();
    }

    CustomsField(boolean t, int id) {
        truckOnly = t;
        this.id=id;
        Thread bt = new Thread(br);
        bt.setDaemon(true);
        bt.start();

    }
    CustomsField(boolean t, int id, File f) {
        truckOnly = t;
        this.id=id;
        this.config = f;
        Thread bt = new Thread(br);
        bt.setDaemon(true);
        bt.start();

    }

    public boolean isAvaliable(Vehicle v) {
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
        if (
                (truckOnly && v instanceof Truck) || (!truckOnly && !(v instanceof Truck))
        ) {
            return blockers.size()==0;
        }
        return false;
    }

    public void setVehicle(Vehicle v) {
        vehicle = v;
        if (v != null) {
            blockers.add(true);
            passengers.add(v.getDriver());
            for (Passenger p : v.getPassengers()) {
                passengers.add(p);
            }
            tlv.add(v);
        }
    }

    public boolean canAdvance() {

        return blockers.size()==0;
    }
}

