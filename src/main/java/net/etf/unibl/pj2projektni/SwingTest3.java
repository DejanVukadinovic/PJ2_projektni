package net.etf.unibl.pj2projektni;

import javax.swing.*;
import java.util.*;

public class SwingTest3 {
    public static void main(String[] args){

        HashMap<Vehicle, ArrayList<Report>> reports = new HashMap<Vehicle, ArrayList<Report>>();
        ArrayList<Boolean> r = new ArrayList<Boolean>();
        r.add(true);

        ArrayList<List<Field>> map = new ArrayList<List<Field>>();

        List<Field> al1 = Collections.synchronizedList(Arrays.asList(new BorderField(false, 0, reports), new BorderField(false, 1, reports), new BorderField(true, 2, reports)));
        //List<Field> al1 = Collections.synchronizedList(Arrays.asList(new BorderField(), new BorderField()));
        //List<Field> al1 = Collections.synchronizedList(Arrays.asList(new BorderField()));

        List<Field> al2 = Collections.synchronizedList(Arrays.asList(null, new CustomsField(0), new CustomsField(true, 1)));
        //List<Field> al2 = Collections.synchronizedList(Arrays.asList(new CustomsField(), new CustomsField()));
        //List<Field> al2 = Collections.synchronizedList(Arrays.asList(new CustomsField()));

        map.add(al2);
        map.add(al1);
        for(int i=0;i<12;i++){
            List<Field> al = Collections.synchronizedList(Arrays.asList(null, new Field(), null));

            map.add(al);
        }
        for (int i = 0; i < 10; i++) {
            Car c1 = new Car(map, 1, r);
            Thread t2 = new Thread(c1);
            t2.start();
        }
        for (int i = 0; i < 10; i++) {
            Bus c1 = new Bus(map, 1, r);
            Thread t2 = new Thread(c1);
            t2.start();
        }
        JFrame frame = new JFrame();
        frame.setSize(500,900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SimulationPanelThread smp = new SimulationPanelThread(map, r);
        Thread t1 = new Thread(smp);
        t1.start();
        frame.add(smp);
        frame.setVisible(true);
        System.out.println("Printing something");
    }
}
