package CS2450;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InClassEx4 extends Application {
	Label l = new Label("Dorm: ");
	ChoiceBox<String> cb = new ChoiceBox<>();
	Label l2 = new Label("Meal Plan: ");
	ChoiceBox<String> cb2 = new ChoiceBox<>();
	Button b = new Button("Submit");
	Label l3 = new Label("");
	String house;
	String meals;
	int housingprice;
	int mealprice;
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		cb.getItems().add("Allen Hall: $1,800 per semester");
		cb.getItems().add("Pike Hall: $2,200 per semester");
		cb.getItems().add("Farthing Hall: $2,800 per semester");
		cb.getItems().add("University Suites: $3,000 per semester");
		HBox h = new HBox(10, l, cb);

		house = cb.getSelectionModel().getSelectedItem();

		cb2.getItems().add("7 meals per week: $600 per semester");
		cb2.getItems().add("14 meals per week: $1,100 per semester");
		cb2.getItems().add("Unlimited Meals: $1,800 per semester");
		HBox h2 = new HBox(10, l2, cb2);

		meals = cb2.getSelectionModel().getSelectedItem();

		VBox v = new VBox(10, h, h2);

		GridPane gp = new GridPane();
		gp.add(v, 0, 0);
		gp.add(b, 0, 1);
		gp.add(l3, 0, 2);
		gp.setAlignment(Pos.CENTER);

		b.setOnAction(event -> {
			house = cb.getSelectionModel().getSelectedItem();
			meals = cb2.getSelectionModel().getSelectedItem();
			if (house == null || meals == null) {
				l3.setText("Please select a housing plan and meal plan");
			} else {
				if(house == "Allen Hall: $1,800 per semester") {
					 housingprice = 1800;
				} else if(house == "Pike Hall: $2,200 per semester") {
					housingprice = 2200;
				} else if(house == "Farthing Hall: $2,800 per semester") {
					housingprice = 2800;
				} else if(house == "University Suites: $3,000 per semester") {
					housingprice = 3000;
				}
				if(meals == "7 meals per week: $600 per semester") {
					mealprice = 600;
				} else if(meals == "14 meals per week: $1,100 per semester") {
					mealprice = 1100;
				} else if(meals == "Unlimited Meals: $1,800 per semester") {
					mealprice = 1800;
				}
				int total = housingprice + mealprice;
				l3.setText("Total semester charges: $" + total);
			}
		});

		Scene scene = new Scene(gp, 600, 200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("IN CLASS EXCERCISE 4");
		primaryStage.show();
	}
}