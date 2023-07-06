package net.etf.unibl.pj2projektni;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Modal {
    public static void display(String title, String message){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        Label l1 = new Label();
        l1.setText(message);
        Button cb = new Button("Close");
        cb.setOnAction(e->window.close());
        VBox vb = new VBox();
        vb.getChildren().addAll(l1, cb);
        vb.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vb);
        window.setScene(scene);
        window.showAndWait();
    }
}
