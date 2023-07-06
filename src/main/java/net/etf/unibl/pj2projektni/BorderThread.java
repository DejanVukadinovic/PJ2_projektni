package net.etf.unibl.pj2projektni;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class BorderThread implements Runnable {

    ArrayList<Vehicle> tlv;
    Boolean avaliable;
    ArrayList<Passenger> passengers;
    ArrayList<Passenger> stayingPassengers;
    private int id;
    private HashMap<Vehicle, ArrayList<Report>> reports;

    BorderThread(
            ArrayList tlv,
            Boolean avaliable,
            ArrayList<Passenger> pass,
            int id,
            ArrayList<Passenger> stpass,
            HashMap<Vehicle, ArrayList<Report>> reports
    ) {
        this.tlv = tlv;
        this.avaliable = avaliable;
        this.passengers = pass;
        this.id = id;
        this.stayingPassengers = stpass;
        this.reports = reports;
    }

    private boolean processDriver(Passenger p) {
        if (!(p.getDocumentation())) {
            System.out.println("Driver failed");
            stayingPassengers.add(new Passenger());
            ReportFactory.submitReport("Border: "+p.toString());

            return false;
        }
        stayingPassengers.add(p);
        return true;
    }

    private void processPassengers() {
        while (passengers.size() > 0) {
            Passenger pass = passengers.remove(0);
            if (pass.getDocumentation()){
                stayingPassengers.add(pass);
            }else{
                ReportFactory.submitReport("Border: "+pass.toString());
            }
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){}
        }
    }

    public void run() {
        while (true) {
            // System.out.println("Thread: "+tlv.size());

            synchronized (tlv) {
                if (tlv.size() > 0 && passengers.size() > 0) {
                    Vehicle v = tlv.remove(0);
                    processDriver(passengers.remove(0));
                    processPassengers();

                    avaliable = true;
                }
            }
        }
    }
}

