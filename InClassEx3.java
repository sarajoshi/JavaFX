package CS2450;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InClassEx3 extends Application {
	Label acura = new Label("Acura");
	Label nissan = new Label("Nissan");
	Label toyota = new Label("Toyota");
	Button remove_acura = new Button("Remove");
	Button remove_nissan = new Button("Remove");
	Button remove_toyota = new Button("Remove");
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
	}
}