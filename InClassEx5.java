package CS2450;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Optional;


public class InClassEx5 extends Application {
    TextField nameT= new TextField();
    TextField passT= new TextField();
    TextField rePassT= new TextField();

    Button submit= new Button("Submit");
    @Override
    public void start(Stage primaryStage) throws Exception{
        TextFieldListener listener = new TextFieldListener();
        primaryStage.setTitle("ICE 4");
        GridPane gridPane= new GridPane();

        Label label1 = new Label("Create an account");
        Label name= new Label("User Name");
        Label pass= new Label("Password");
        Label rePass= new Label("Re-enter Password");

        submit.setDisable(true);
        Button quit= new Button("Quit");
        quit.setOnAction(QuitHandler);

        gridPane.addRow( 0, label1);
        gridPane.addRow( 1, name, nameT);
        gridPane.addRow( 2, pass, passT);
        gridPane.addRow( 3, rePass, rePassT);
        gridPane.addRow( 4,submit, quit);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.setPadding( new Insets(50));
        gridPane.setVgap( 10);
        gridPane.setHgap( 10);
        nameT.textProperty().addListener(listener);
        passT.textProperty().addListener(listener);
        rePassT.textProperty().addListener(listener);

        submit.setOnAction(SubmitHandler);

        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private class TextFieldListener implements ChangeListener<String>
    {
        @Override
        public void changed(ObservableValue<? extends String> source, String oldValue, String
                newValue)
        {
            String nameValue = nameT.getText();
            String passV = passT.getText();
            String rePassV = rePassT.getText();
            submit.setDisable(nameValue.trim().equals( "") || passV.trim().equals( "")|| rePassV.trim().equals( ""));
        }
    };
    @SuppressWarnings("unused")
	private EventHandler<ActionEvent> SubmitHandler = event -> {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setHeaderText("Account Created!");
        Optional<ButtonType> result = alert.showAndWait();

    };
    private EventHandler<ActionEvent> QuitHandler = event -> {
        Alert quitAlert = new Alert(Alert.AlertType.CONFIRMATION);
        quitAlert.setTitle("QUIT");
        quitAlert.setHeaderText("Are you sure?");
        Optional<ButtonType> result = quitAlert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK)
           System.exit(0);
    };
    public static void main(String[] args) {
        launch(args);
    }
}