/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lenovo
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class test extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
       Rectangle r= new Rectangle(200,200);
       r.setFill(Color.RED);
       Circle c = new Circle(20);
       c.setFill(Color.BROWN);
       Text t =new Text("Hello World");
       t.setFill(Color.BEIGE);
       GridPane gd=new GridPane();
       gd.add(c, 0, 0);
       gd.add(r, 0, 1);
       gd.add(t, 0, 2);
       
       Scene sc= new Scene(gd,400,400);
       primaryStage.setTitle("llll");
       primaryStage.setScene(sc);
       primaryStage.show();
       
      
    }
}
    

