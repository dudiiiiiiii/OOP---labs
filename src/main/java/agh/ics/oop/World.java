package agh.ics.oop;

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
            System.out.println("System wystartował");
            String[] xd = {"f", "f", "b", "r", "r", "l"};
            List<Direction> xD = change(xd);
            run(change(args));
            System.out.println("System zakończył działanie");

            System.out.println("----------------------");
            args = new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
            List<MoveDirection> directions = new OptionsParser().parse(args);
            //sprawdź czy dobrze jak idzie w w lewo w dół daleko

            IWorldMap map = new GrassField(5);
            List<Vector2d> positions = new ArrayList<>();
            positions.add(new Vector2d(2, 2));
            positions.add(new Vector2d(3, 4));

            IEngine enegine = new SimulationEngine(directions, map, positions);
            enegine.run();
            System.out.println(map.toString());
        }
        catch(IllegalArgumentException argument) {
            System.out.println(argument);
        }

    }
}
