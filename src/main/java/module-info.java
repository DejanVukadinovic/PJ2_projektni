module net.etf.unibl.pj2projektni {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens net.etf.unibl.pj2projektni to javafx.fxml;
    exports net.etf.unibl.pj2projektni;
}