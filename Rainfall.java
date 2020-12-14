package HW3;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.scene.layout.BorderPane;

import java.util.regex.Pattern;

public class Rainfall extends Application {
	
    private XYChart.Series<String, Number> rain;
    private CategoryAxis hAxis;
    private NumberAxis vAxis;
    private XYChart<String, Number> chart;
    private GridPane gp;
    private BorderPane bp;
    private VBox v1, v2;
    private Label l1, l2, l3, l4;
    private TextField tf1, tf2, tf3, tf4;
    private Button button;
    private Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception {

        MenuBar mb = createMenuBar(primaryStage);

        gp = new GridPane();
        v1 = new VBox(mb, gp);

        l1 = new Label("January: ");
        l2 = new Label("February: ");
        l3 = new Label("March: ");
        l4 = new Label("April: ");

        tf1 = new TextField();
        tf2 = new TextField();
        tf3 = new TextField();
        tf4 = new TextField();
        button = new Button("Submit");

        gp.addRow(0, l1, tf1);
        gp.addRow(1, l2, tf2);
        gp.addRow(2, l3, tf3);
        gp.addRow(3, l4, tf4);
        gp.addRow(4);
        gp.add(button, 1, 4);
        GridPane.setHalignment(button, HPos.CENTER);
        GridPane.setValignment(button, VPos.CENTER);

        gp.setPadding(new Insets(10));
        gp.setHgap(10);
        gp.setVgap(10);

        TextField[] tfArray = {tf1, tf2, tf3, tf4};
        Pattern p = Pattern.compile("((\\d*)|(\\d+\\.\\d*))");

        for (int i = 0; i < tfArray.length; i++) {
            tfArray[i].setTextFormatter(new TextFormatter<Double>(new DoubleStringConverter(), 0.0,
                    change -> {
                        String newText = change.getControlNewText();
                        if (p.matcher(newText).matches()) {
                            return change;
                        } else return null;
                    }));
            tfArray[i].setText("");
        }

        button.setOnAction(actionEvent -> {
            createNewChart(mb);
            primaryStage.setScene(new Scene(v2));
        });

        scene = new Scene(v1);

        primaryStage.setTitle("Total Rainfall");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private MenuBar createMenuBar(Stage primaryStage) {
        MenuBar menubar = new MenuBar();
        Menu menu1 = new Menu("File");
        Menu menu2 = new Menu("View");

        MenuItem menuItemNew = new MenuItem("New");
        MenuItem menuItemExit = new MenuItem("Exit");

        MenuItem menuItem1 = new MenuItem("Bar Plot");
        MenuItem menuItem2 = new MenuItem("Line Plot");
        MenuItem menuItem3 = new MenuItem("Area Plot");

        menuItemNew.setOnAction(actionEvent -> {
            createNewSettings(primaryStage, menubar);
        });

        menuItemExit.setOnAction(actionEvent -> {
            System.exit(0);
        });

        /* Other Charts */
        menuItem1.setOnAction(actionEvent -> {
            axis();
            getInput();
            chart = new BarChart<>(hAxis,vAxis);
            set();
            bp.setCenter(chart);
        });

        menuItem2.setOnAction(actionEvent -> {
            axis();
            getInput();
            chart = new LineChart<>(hAxis,vAxis);
            set();
            bp.setCenter(chart);
        });

        menuItem3.setOnAction(actionEvent -> {
            axis();
            getInput();
            chart = new AreaChart<>(hAxis,vAxis);
            set();
            bp.setCenter(chart);
        });

        menu1.getItems().addAll(menuItemNew, menuItemExit);
        menu2.getItems().addAll(menuItem1, menuItem2, menuItem3);

        menubar.getMenus().addAll(menu1, menu2);

        return menubar;
    }

    private void createNewSettings(Stage primaryStage, MenuBar menubar) {
        v1.getChildren().add(0, menubar);

        tf1.setText("");
        tf2.setText("");
        tf3.setText("");
        tf4.setText("");

        primaryStage.setScene(scene);
    }

    private void createNewChart(MenuBar menubar) {
        axis();
        getInput();

        chart = new BarChart<>(hAxis,vAxis);
        set();

        bp = new BorderPane();
        bp.setCenter(chart);
        v2.getChildren().addAll(menubar, bp);
    }

    private void set() {
        chart.setTitle("Inches of Rain Per Month");
        chart.getData().add(rain);
        chart.setLegendVisible(false);
    }

    private void axis() {
        v2 = new VBox();
        hAxis = new CategoryAxis();
        hAxis.setLabel("Months");

        vAxis = new NumberAxis();
        vAxis.setLabel("Rainfall");
        rain = new XYChart.Series<>();
    }

    @SuppressWarnings("unchecked")
	private void getInput() {
        if(!tf1.getText().equals(""))
            rain.getData().addAll(new XYChart.Data<>("January",Double.parseDouble(tf1.getText())));
        else
            rain.getData().addAll(new XYChart.Data<>("January",0));

        if(!tf2.getText().equals(""))
            rain.getData().addAll(new XYChart.Data<>("February",Double.parseDouble(tf2.getText())));
        else
            rain.getData().addAll(new XYChart.Data<>("February",0));

        if(!tf3.getText().equals(""))
            rain.getData().addAll(new XYChart.Data<>("March",Double.parseDouble(tf3.getText())));
        else
            rain.getData().addAll(new XYChart.Data<>("March",0));

        if(!tf4.getText().equals(""))
            rain.getData().addAll(new XYChart.Data<>("April",Double.parseDouble(tf4.getText())));
        else
            rain.getData().addAll(new XYChart.Data<>("April",0));
    }

    public static void main(String[] args) {
        launch(args);
    }
}