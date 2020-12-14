package CS2450;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InClassEx2 extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) throws Exception {
		Label l1 = new Label("Please enter the following:");
		Label l2 = new Label("Name");
		Label l3 = new Label("Phone #");
		Label l4 = new Label("Email");
		
		Button button1 = new Button("Submit");
		Button button2 = new Button("Cancel");
		
		TextField tf1 = new TextField();
		TextField tf2 = new TextField();
		TextField tf3 = new TextField();
		
		VBox v1 = new VBox(22, l2, l3, l4);
		VBox v2 = new VBox(10, tf1, tf2, tf3);
		
		HBox hbox = new HBox(10, v1, v2);
		HBox submit = new HBox(10, button1);
		HBox cancel = new HBox(10, button2);
		hbox.setAlignment(Pos.CENTER);
		submit.setAlignment(Pos.CENTER);
		cancel.setAlignment(Pos.CENTER);
		
		GridPane gp = new GridPane();
		gp.add(l1, 0, 0);
		gp.add(hbox, 1, 0);
		gp.add(submit, 0, 2);
		gp.add(cancel, 1, 2);
		gp.setHgap(10);
		gp.setVgap(10);
		gp.setPadding(new Insets(20));
		
		Scene scene = new Scene(gp, 450, 200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("IN CLASS EXCERCISE 2");
		primaryStage.show();
	}
}
