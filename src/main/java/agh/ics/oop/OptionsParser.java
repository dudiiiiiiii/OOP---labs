package agh.ics.oop;

import java.util.*;

public class OptionsParser {

    public static List<MoveDirection> parse(String[] args) {
        List<MoveDirection> moves = new ArrayList<>();
        for (String arg : args) {
            switch (arg) {
                case "f", "forward" -> moves.add(MoveDirection.FORWARD);
                case "b", "backword" -> moves.add(MoveDirection.BACKWORD);
                case "r", "right" -> moves.add(MoveDirection.RIGHT);
                case "l", "left" -> moves.add(MoveDirection.LEFT);
                default -> throw new IllegalArgumentException(arg + " is not legal move specification");
            }
        }
        return moves;
    }
}
