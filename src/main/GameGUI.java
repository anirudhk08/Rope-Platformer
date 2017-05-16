package main;

/**
 * Created by Aubhro Sengupta on 5/4/2017.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class GameGUI extends Application implements EventHandler<ActionEvent>
{
    private Button button;

	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
    public void start(Stage s) throws Exception
    {
        s.setTitle("Hello, World!");

        button = new Button();
        button.setText("Hello Button");
        button.setOnAction((ActionEvent event) -> doS());

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 500, 250);
        s.setScene(scene);


        s.show();
    }

    public void doS() {
        System.out.println("did");
    }

}
