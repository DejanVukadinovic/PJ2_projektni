package net.etf.unibl.pj2projektni;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SwingTest2 {
    public static void main(String[] args){

        ArrayList<List<Field>> map = new ArrayList<List<Field>>();

        List<Field> al1 = Collections.synchronizedList(Arrays.asList(new BorderField(0), new BorderField(1), new BorderField(true, 2)));
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

        JFrame f = new JFrame();
        f.setSize(800,900);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        SimulationPanel sp = new SimulationPanel(map);
        sp.setSize(800,900);
        JScrollPane jsc = new JScrollPane(sp, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        f.add(sp);
        f.setVisible(true);
        //Bus c1 = new Bus(map, 1);
        //Thread t1 = new Thread(c1);
        //t1.start();
        while (true){
            try {
                Thread.sleep(500);

                sp.removeAll();
                sp.revalidate();
            }catch (InterruptedException e){}

        }
    }
}
