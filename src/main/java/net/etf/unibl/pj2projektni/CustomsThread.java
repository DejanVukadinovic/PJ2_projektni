package net.etf.unibl.pj2projektni;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomsThread implements Runnable {

    ArrayList<Vehicle> tlv;
    Boolean avaliable;
    ArrayList<Passenger> passengers;
    ArrayList<Boolean> blockers;

    CustomsThread(
            ArrayList tlv,
            Boolean avaliable,
            ArrayList<Passenger> pass,
            ArrayList<Boolean> bl
    ) {
        this.tlv = tlv;
        this.avaliable = avaliable;
        this.passengers = pass;
        blockers=bl;
    }

    private boolean processDriver(BusPassenger p) {
        if(p.getBag()==null) return true;
        if (!(p.getBag().process())) return false;
        return true;
    }

    private void processPassengers() {
        while (passengers.size() > 0) {
            try{


            BusPassenger bp = (BusPassenger)passengers.remove(0);
                bp.getBag();
            }catch (ClassCastException e){}
        }
    }

    public void run() {
        while (true) {

            synchronized (tlv) {
                if (tlv.size() > 0 && passengers.size() > 0 && blockers.size()>0) {
                    synchronized (tlv){
                        Vehicle v = tlv.remove(0);
                        if (v instanceof Bus) {
                            try{
                                //System.out.println(
                                  //      "Processing: " + processDriver((BusPassenger) passengers.remove(0))
                                //);
                                processDriver((BusPassenger) passengers.remove(0));
                            }catch (ClassCastException e){}

                            processPassengers();
                        } else if (v instanceof Car) {
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                            }
                        }

                        blockers.remove(0);
                        avaliable = true;
                    }
                }
            }
        }
    }
}

