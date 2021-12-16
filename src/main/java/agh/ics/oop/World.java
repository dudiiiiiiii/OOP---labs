package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

import java.util.*;

public class World {
    public static List<Direction> change(String[] args){
        List<Direction> dir= new ArrayList<>();
        for(int i=0; i < args.length; i++){
            if(args[i].equals("f")){
                dir.add(Direction.FORWARD);
            }
            else if(args[i].equals("b")){
                dir.add(Direction.BACKWORD);
            }
            else if(args[i].equals("r")){
                dir.add(Direction.RIGHT);
            }
            else if(args[i].equals("l")){
                dir.add(Direction.LEFT);
            }
        }
        return dir;
    }
    public static void run(List<Direction> args){

        for (Direction x: args) {
            String message = switch (x){
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWORD -> "Zwierzak idzie do tyłu";
                case LEFT -> "Zewierzak idzie w lewo";
                case RIGHT -> "Zwierzak idzei w prawo";
                default -> "Błąd";
            };
            System.out.println(message);
        }
    }
    public static void main(String[] args) {
        try {
            System.out.println("----------------------");


            Application.launch(App.class, args);
        }
        catch(IllegalArgumentException argument) {
            System.out.println(argument);
        }

    }
}
