package CS2450_HW1;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Assignment1 extends Application {
	double days;
	double totalAirfare = 1;
	double milesDriven = 1;
	double register;
	double lodge;
	double foodCost;
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		Label daysOnTrip = new Label("Number of days on trip: ");
		TextField daysOnTripTF = new TextField();
		daysOnTripTF.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
					daysOnTripTF.setText(oldValue);
				}
			}
		});

		Label transportationCost = new Label("Transportation Cost (pick one)");
		Label air = new Label("Airfare");
		Label or = new Label("OR");
		Label mile = new Label("Miles Driven");
		TextField airfare = new TextField();
		TextField miles = new TextField();
		VBox labels = new VBox(10, air, or, mile);
		VBox transportation = new VBox(15, airfare, miles);
		airfare.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
					airfare.setText(oldValue);
				}
			}
		});
		miles.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
					miles.setText(oldValue);
				}
			}
		});

		Label confReg = new Label("Conference Registration Cost:");
		TextField cr = new TextField();
		cr.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
					cr.setText(oldValue);
				}
			}
		});

		Label lodg = new Label("Lodging Cost (per night):");
		TextField lc = new TextField();
		lc.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
					lc.setText(oldValue);
				}
			}
		});

		Label food = new Label("Food Cost (total):");
		TextField fc = new TextField();
		fc.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
					fc.setText(oldValue);
				}
			}
		});

		Button submit = new Button("Submit");

		GridPane gp = new GridPane();
		gp.add(daysOnTrip, 0, 0);
		gp.add(daysOnTripTF, 2, 0);

		gp.add(transportationCost, 0, 1);
		gp.add(labels, 0, 2);
		gp.add(transportation, 2, 2);

		gp.add(confReg, 0, 3);
		gp.add(cr, 2, 3);

		gp.add(lodg, 0, 4);
		gp.add(lc, 2, 4);

		gp.add(food, 0, 5);
		gp.add(fc, 2, 5);

		gp.add(submit, 1, 6);

		Label text = new Label("");
		Label anotherText = new Label("");
		VBox v = new VBox(10, gp, text, anotherText);

		gp.setVgap(10);
		gp.setAlignment(Pos.CENTER);
		v.setAlignment(Pos.CENTER);

		submit.setOnAction(event -> {
			if(airfare.getText().isEmpty() == false && miles.getText().isEmpty() == false) {
				text.setText("Please enter either miles OR airfare for transportation cost");

			} else if(daysOnTripTF.getText().isEmpty() | cr.getText().isEmpty() | lc.getText().isEmpty() | fc.getText().isEmpty()) {
				text.setText("Please fill out all necessary fields");
			} else {
				if(airfare.getText().isEmpty() == true) {
					totalAirfare = 0;
				} else if(miles.getText().isEmpty() == true) {
					System.out.println("here");
					milesDriven = 0;
				}
				days = Double.parseDouble(daysOnTripTF.getText());
				if(totalAirfare != 0) {
					totalAirfare = Double.parseDouble(airfare.getText());
				} else if(milesDriven != 0) {
					milesDriven = Double.parseDouble(miles.getText());
				}
				register = Double.parseDouble(cr.getText());
				lodge = Double.parseDouble(lc.getText());
				foodCost = Double.parseDouble(fc.getText());

				double total = totalAirfare + (milesDriven*.42) + register + (days * lodge) + foodCost;
				double owedFood = foodCost - (days*47);
				if(owedFood < 0) {
					owedFood = 0;
				}
				double owedLodge = (lodge * days) - (days * 195);
				if(owedLodge < 0) {
					owedLodge = 0;
				}
				double owedMiles = milesDriven * 0.58;
				double totalOwed = totalAirfare + owedFood + owedLodge + owedMiles;
				text.setText("Total costs for the trip: $" + total);
				anotherText.setText("Total owed: $" + totalOwed);
			}
		});

		Scene scene = new Scene(v, 500, 350);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Expense Report");
		primaryStage.show();
	}
}
