package CS2450;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InClassEx1 extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		Button button1 = new Button("Button 1");
		Button button2 = new Button("Button 2");
		Button button3 = new Button("Button 3");
		Button button4 = new Button("Button 4");
		Button button5 = new Button("Button 5");
		Button button6 = new Button("Button 6");
		HBox hbox = new HBox(10, button1, button2, button3);
		hbox.setAlignment(Pos.CENTER);
		HBox hbox2 = new HBox(10, button4, button5, button6);
		hbox.setAlignment(Pos.CENTER);

		VBox vbox = new VBox(20, hbox, hbox2);
		vbox.setPadding(new Insets(20));
		vbox.setAlignment(Pos.CENTER);
		Scene myScene = new Scene(vbox);

		primaryStage.setScene(myScene);
		primaryStage.setTitle("Layout Demo");
		primaryStage.show();

	}
}
