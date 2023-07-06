package net.etf.unibl.pj2projektni;
import javax.swing.*;

import java.awt.*;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;


public class SwingTest {
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


        JFrame frame = new JFrame();
        JButton btn = new JButton("it do be like that.");
        btn.setPreferredSize(new Dimension(200, 50));
        frame.setSize(800,920);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Naslov");
        System.out.println();
        //Car c1 = new Car(map, 1, r);
        //Thread t1 = new Thread(c1);
        //t1.start();
        JComponent pane = (JComponent)frame.getContentPane();

        for(int i= 0; i< map.size(); i++){
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout());
            panel.setPreferredSize(new Dimension(1920, 50));
            panel.setBackground(new Color(0x999999));


            for (int j = 0; j < 3; j++) {
                JButton fb = new JButton();
                fb.setPreferredSize(new Dimension(70,50));
                if(map.get(i).get(j) instanceof BorderField){
                    fb.setBackground(new Color(0x3291ff));
                }else if(map.get(i).get(j) instanceof CustomsField){
                    fb.setBackground(new Color(0xff9132));
                }

                if(map.get(i).get(j)!=null ){
                    Vehicle v = map.get(i).get(j).getVehicle();
                    if(v==null) {
                        fb.setText("FR");
                    }else{
                        if (v instanceof Car){
                            fb.setText("C");
                            fb.setBackground(new Color(0xFF0000));
                        }else  if (v instanceof Bus){
                            fb.setText("B");
                            fb.setBackground(new Color(0x00FF00));
                        }else  if (v instanceof Truck){
                            fb.setText("T");
                            fb.setBackground(new Color(0x0000FF));
                        }
                    }
                }

                panel.add(fb);
            }
            pane.add(panel);

        }
        pane.add(btn);
        frame.setVisible(true);

        while(true){
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){}
            pane.removeAll();
            pane.validate();
            frame.repaint();
            for(int i= 0; i< map.size(); i++){
                JPanel panel = new JPanel();
                panel.setLayout(new FlowLayout());
                panel.setPreferredSize(new Dimension(1920, 50));
                panel.setBackground(new Color(0x999999));


                for (int j = 0; j < 3; j++) {
                    JButton fb = new JButton();
                    fb.setPreferredSize(new Dimension(70,50));
                    if(map.get(i).get(j) instanceof BorderField){
                        fb.setBackground(new Color(0x3291ff));
                    }else if(map.get(i).get(j) instanceof CustomsField){
                        fb.setBackground(new Color(0xff9132));
                    }

                    if(map.get(i).get(j)!=null ){
                        Vehicle v = map.get(i).get(j).getVehicle();
                        if(v==null) {
                            fb.setText("FR");
                        }else{
                            if (v instanceof Car){
                                fb.setText("C");
                                fb.setBackground(new Color(0xFF0000));
                            }else  if (v instanceof Bus){
                                fb.setText("B");
                                fb.setBackground(new Color(0x00FF00));
                            }else  if (v instanceof Truck){
                                fb.setText("T");
                                fb.setBackground(new Color(0x0000FF));
                            }
                        }
                    }

                    panel.add(fb);
                }
                pane.add(panel);

            }
            pane.validate();
            frame.repaint();
        }

    }
}
