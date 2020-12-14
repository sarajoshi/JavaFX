package CS2450;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InClassEx9 extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane bp = new BorderPane();
		
		MenuBar menu = new MenuBar();
		Menu view = new Menu("View");
		menu.getMenus().add(view);
		Menu help = new Menu("Help");
		menu.getMenus().add(help);
		RadioMenuItem book = new RadioMenuItem("Books");
		RadioMenuItem movie = new RadioMenuItem("Movies");
		MenuItem exitItem = new MenuItem("Exit");
		MenuItem about = new MenuItem("About");
		book.setSelected(true);
		ToggleGroup textToggleGroup = new ToggleGroup();
		movie.setToggleGroup(textToggleGroup);
		view.getItems().addAll(book, movie, new SeparatorMenuItem(), exitItem); 
		help.getItems().add(about);
		bp.setTop(menu);
		
		ListView<String> books = new ListView<>();
		books.setPrefSize(100, 75);
		books.getItems().addAll( "The Shining", "It", "Frankenstein");
		VBox vbox = new VBox(books);
		vbox.setPadding(new Insets(10));
		vbox.setAlignment(Pos.CENTER);
		bp.setCenter(vbox);
		
		ListView<String> movies = new ListView<>();
		movies.setPrefSize(100, 75);
		VBox vbox2 = new VBox(movies);
		vbox2.setPadding(new Insets(10));
		vbox2.setAlignment(Pos.CENTER);
		movies.getItems().addAll( "Us", "Scream", "Friday the 13th");
		
		book.setOnAction(event -> {
			bp.setCenter(vbox);
		});
		
		movie.setOnAction(event -> {
			bp.setCenter(vbox2);
		});
		
		exitItem.setOnAction(event -> {
			System.exit(0);
		});
		
		about.setOnAction(event -> {
			Alert aboutInfo = new Alert(AlertType.INFORMATION, "Sara, Ronald, Kenneth, Sonal,\n and Alex made this on Oct 9, 2019");
			aboutInfo.show();
		});
		
		Scene myScene = new Scene(bp, 400, 200);
		primaryStage.setScene(myScene);
		primaryStage.show();
	}
}
