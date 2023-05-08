package com.example.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class UI extends Application {
    @Override
    public void start(Stage pealava) throws IOException {
        GridPane mängulaud = new GridPane();
        mängulaud.setAlignment(Pos.CENTER);
        mängulaud.setHgap(10);
        mängulaud.setVgap(10);
        mängulaud.setPadding(new Insets(25,25,25,25));
        mängulaud.setVgap(5);
        mängulaud.setHgap(5);

        Text ühed = new Text("Ühed");
        Text kahed = new Text("kahed");
        Text kolmed = new Text("kolmed");
        Text neljad = new Text("neljad");
        Text viied = new Text("viied");
        Text kuued = new Text("kuued");
        mängulaud.add(ühed,0,0);
        mängulaud.add(kahed,0,1);
        mängulaud.add(kolmed,0,2);
        mängulaud.add(neljad,0,3);
        mängulaud.add(viied,0,4);
        mängulaud.add(kuued,0,5);



        // 1. mängija punktid
        Button p1_yks = new Button("Mängija 1");

        Button p1_kaks = new Button("Mängija 1");

        Button p1_kolm = new Button("Mängija 1");

        Button p1_neli = new Button("Mängija 1");

        Button p1_viis = new Button("Mängija 1");

        Button p1_kuus = new Button("Mängija 1");



        // 2. mängija punktid
        Button p2_yks = new Button("Mängija 2");
        Button p2_kaks = new Button("Mängija 2");
        Button p2_kolm = new Button("Mängija 2");
        Button p2_neli = new Button("Mängija 2");
        Button p2_viis = new Button("Mängija 2");
        Button p2_kuus = new Button("Mängija 2");

        mängulaud.add(p1_yks,1,0);
        mängulaud.add(p1_kaks,1,1);
        mängulaud.add(p1_kolm,1,2);
        mängulaud.add(p1_neli,1,3);
        mängulaud.add(p1_viis,1,4);
        mängulaud.add(p1_kuus,1,5);


        mängulaud.add(p2_yks,2,0);
        mängulaud.add(p2_kaks,2,1);
        mängulaud.add(p2_kolm,2,2);
        mängulaud.add(p2_neli,2,3);
        mängulaud.add(p2_viis,2,4);
        mängulaud.add(p2_kuus,2,5);


        HBox main = new HBox(20);
        main.setAlignment(Pos.CENTER);
        main.getChildren().addAll(mängulaud);

        Scene scene = new Scene(main,500,500);
        pealava.setTitle("Yatzy");
        pealava.setScene(scene);
        pealava.show();
    }

    class nupumuutmine extends Button {
        TextField tf = new TextField();

        public nupumuutmine(String text) {
            setText(text);
            setOnMouseClicked(e -> {
                tf.setText(getText());
                setText("");
                setGraphic(tf);
            });
        }
    }

    public static void main(String[] args) {
        launch();
    }
}