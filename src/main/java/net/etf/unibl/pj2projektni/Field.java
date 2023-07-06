package net.etf.unibl.pj2projektni;

public class Field{
    protected Vehicle vehicle;
    public boolean isAvaliable( Vehicle v){

        if(vehicle==null) {
            return true;
        }

        return false;
    }
    public void setVehicle(Vehicle v){
        vehicle=v;
    }
    public Vehicle getVehicle(){
        return vehicle;
    }
    public boolean canAdvance(){
        return true;
    }

    public boolean removeYourself(){
        return false;
    }
}
