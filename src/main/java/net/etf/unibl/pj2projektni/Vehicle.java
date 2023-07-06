package net.etf.unibl.pj2projektni;

import java.util.ArrayList;
import java.util.List;

abstract class Vehicle implements Runnable {

    public Passenger d = new Passenger();

    public abstract Passenger getDriver();

    public abstract ArrayList<Passenger> getPassengers();

    abstract public void setPassengers(ArrayList<Passenger> arr);


    List<List<Field>> map;
    int position;
    int field_no = 1;
    int id = 0;
    ArrayList<Boolean> running;

    Vehicle(List<List<Field>> m) {
        map = m;
        position = map.size() - 1;
    }

    Vehicle(List<List<Field>> m, int id, ArrayList<Boolean> running) {
        map = m;
        position = map.size() - 1;
        this.id = id;
        this.running = running;
    }

    public void run() {
        while (true) {
            if (!running.isEmpty()) {


                synchronized (map) {

                    if (map.get(position).get(field_no).canAdvance() && map.get(position).get(field_no).removeYourself()) {
                        map.get(position).get(field_no).setVehicle(null);
                        break;
                    }


                    if (map.get(position).get(field_no).canAdvance() && !map.get(position).get(field_no).removeYourself()) {
                        if (position == 0) {
                            map.get(0).get(field_no).setVehicle(null);
                            break;
                        }
                        int i = 0;

                        for (Field f : map.get(position - 1)) {
                            if (f != null && f.isAvaliable(this)) {
                                f.setVehicle(this);
                                map.get(position).get(field_no).setVehicle(null);
                                position--;
                                field_no = i;
                                break;
                            }
                            i++;
                        }
                    }
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}

