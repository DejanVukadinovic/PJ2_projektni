package net.etf.unibl.pj2projektni;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SimulationPanel extends JPanel {
    ArrayList<List<Field>> map;

    SimulationPanel(){

    }
    SimulationPanel(ArrayList<List<Field>> map){
        this.map=map;
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        for (int i = 0; i < 10; i++) {
            this.add(new JButton("it do be"+i));

        }
    }
}
