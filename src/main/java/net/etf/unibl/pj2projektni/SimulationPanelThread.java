package net.etf.unibl.pj2projektni;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SimulationPanelThread extends JPanel implements Runnable {
    ArrayList<List<Field>> map;
    private ArrayList<Boolean> running;
    SimulationPanelThread(){}
    SimulationPanelThread(ArrayList<List<Field>> map, ArrayList<Boolean> r){
        this.map=map;
        this.running = r;
    }
    @Override
    public void run() {
        ArrayList<ArrayList<JButton>> buttons = new ArrayList<ArrayList<JButton>>();
        JButton btn = new JButton("button");
        btn.addActionListener(e->{
            JFrame modal = new JFrame();
            modal.setSize(200,100);
            modal.add(new Label("text"));
            modal.setVisible(true);
        });
        this.add(btn);
        for(int i= 0; i< map.size(); i++){
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout());
            panel.setPreferredSize(new Dimension(1920, 50));
            panel.setBackground(new Color(0x999999));

            ArrayList<JButton> jblist = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                JButton fb = new JButton();

                if(map.get(i).get(j)!=null){
                    final Vehicle prv = map.get(i).get(j).getVehicle();
                    final boolean avaliale = map.get(i).get(j).canAdvance();
                    final int fi = i, fj = j;
                    fb.addActionListener(e->{
                        JFrame modal = new JFrame();
                        modal.setSize(200,100);
                        try {
                            modal.add(new Label(map.get(fi).get(fj).getVehicle().toString()));

                        }catch (NullPointerException exception){}
                        modal.setVisible(true);
                    });
                }

                jblist.add(fb);
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
            buttons.add(jblist);
            this.add(panel);
        }
        while(true){
        btn.setText("button "+Math.random());
            for (int i = 0; i < map.size(); i++) {
                for (int j = 0; j < 3; j++) {
                    Field f = map.get(i).get(j);
                    JButton fb = buttons.get(i).get(j);
                    if(f!=null){
                        Vehicle v = map.get(i).get(j).getVehicle();
                        if(v!=null){
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
                        }else{
                            fb.setText("FR");
                            fb.setBackground(new Color(0xeeeeee));

                        }
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
