package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class App extends Application implements IUpdateAnimals{
    private IWorldMap map;
    private GridPane gridPane = new GridPane();
    private HBox hbox = new HBox();

    public void createGrid(GridPane curr) throws FileNotFoundException {
        curr.setGridLinesVisible(false);
        curr.getColumnConstraints().clear();
        curr.getRowConstraints().clear();
        curr.getChildren().clear();

        curr.setGridLinesVisible(true);
        Vector2d top = this.map.up();
        Vector2d bottom = this.map.down();


        Integer width = top.x- bottom.x + 2;
        Integer height = top.y- bottom.y + 2;

        Label temp1 = new Label("y/x");
        curr.add(temp1,0 ,0);
        curr.setHalignment(temp1, HPos.CENTER);

        for(Integer i=1; i < height; i++) {
            Label temp = new Label(Integer.toString(top.y-i+1));
            curr.add(temp, 0, i);
            curr.getRowConstraints().add(new RowConstraints(40));
            curr.setHalignment(temp, HPos.CENTER);

        }

        for(Integer i =1; i< width; i++){
            Label temp = new Label(Integer.toString(bottom.x+i-1));
            curr.add(temp, i, 0);
            curr.setHalignment(temp, HPos.CENTER);
            curr.getColumnConstraints().add(new ColumnConstraints(40));
        }

        Map<Vector2d, Animal> animalList = this.map.getAnimalList();
        for(Vector2d key: animalList.keySet()){
            //Label temp = new Label(animalList.get(key).toString());
            GuiElementBox guiElementBox = new GuiElementBox(animalList.get(key));
            guiElementBox.addLabel(animalList.get(key));
            curr.add(guiElementBox.getVBox(), -bottom.x+key.x+1, top.y-key.y+1);
            curr.setHalignment(guiElementBox.getVBox(), HPos.CENTER);
        }

        List<Grass> grass = this.map.getGrass();
        for(Grass gr: grass){
            //Label temp = new Label("*");
            GuiElementBox guiElementBox = new GuiElementBox(gr);
            guiElementBox.addLabelGrass();
            curr.add(guiElementBox.getVBox(), -bottom.x + gr.getPosition().x+1, top.y-gr.getPosition().y+1);
            curr.setHalignment(guiElementBox.getVBox(), HPos.CENTER);
        }

        curr.getColumnConstraints().add(new ColumnConstraints(40));
        curr.getRowConstraints().add(new RowConstraints(40));

        this.gridPane = curr;
    }

    @Override
    public void init() throws FileNotFoundException {
        //String[] args = new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};


        IWorldMap map = new GrassField(15);
        this.map = map;

        List<Vector2d> positions = new ArrayList<>();
        positions.add(new Vector2d(2, 2));
        positions.add(new Vector2d(3, 4));

        SimulationEngine engine = new SimulationEngine(new ArrayList<>(), map, positions);
        //enegine.run();

        engine.setMoveDelay(300);
        engine.addObserver(this);
        Thread engineThread = new Thread(engine);
        VBox buttons = new VBox();
        Button startButton = new Button("Start");
        hbox.getChildren().add(gridPane);
        buttons.getChildren().add(startButton);
        hbox.getChildren().add(buttons);


        try {
            startButton.setOnAction((event) -> {
                String[] args = getParameters().getRaw().toArray(new String[0]);
                List<MoveDirection> directions = new OptionsParser().parse(args);
                engine.setMoves(directions);
                try {
                    createGrid(gridPane);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                gridPane.setGridLinesVisible(true);
                engineThread.start();

            });
        }
        catch(IllegalArgumentException except) {
            System.out.println("Illegal");
        }
    }




    @Override
    public void start(Stage primaryStage) throws Exception {

        Scene scene = new Scene(hbox, 600, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    @Override
    public void positionChanged() {
        Platform.runLater(()-> {
            try {
                createGrid(this.gridPane);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
    }
}
