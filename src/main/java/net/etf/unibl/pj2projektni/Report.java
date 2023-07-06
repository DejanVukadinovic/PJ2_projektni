package net.etf.unibl.pj2projektni;

import java.io.Serializable;

public class Report implements Serializable {
    private String content;
    Report(){}
    Report(String content){
        this.content = content;
    }
}
