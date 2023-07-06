package net.etf.unibl.pj2projektni;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

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

        VBox vb = new VBox();
        for(int i = 0; i<map.size();i++){
            HBox vb1 = new HBox();

            for(int j=0;j<map.get(i).size();j++){
                Button nb = new Button();

                if(map.get(i).get(j) instanceof BorderField){
                    nb.setText("B");
                }else if(map.get(i).get(j) instanceof CustomsField){
                    nb.setText("CF");
                }else if(map.get(i).get(j)==null){
                    nb.setText("null");
                }
                else{
                    nb.setText("NB");
                }
                String mess = i+ " "+j;
                nb.setOnAction(e->{
                    Modal m = new Modal();
                    m.display("bus", String.valueOf(mess));
                });
                vb1.getChildren().add(nb);

            }
            vb.getChildren().add(vb1);
        }


        stage.setTitle("Hello! world");
        //stage.setScene(scene);
        Scene sc2 = new Scene(vb, 400, 400);
        stage.setScene(sc2);
        stage.show();
        Label l = new Label("Hello");
        vb.getChildren().add(l);


    }

    public static void main(String[] args) {
        launch();
    }
}