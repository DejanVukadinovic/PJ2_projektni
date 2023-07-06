package net.etf.unibl.pj2projektni;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ReportFactory {
    public static String submitReport(String content){
        Report r = new Report(content);
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(r.toString()+".txt"));) {
            oos.writeObject(r);
        }catch (IOException e){

        }
        return "Hello world";
    }
}
