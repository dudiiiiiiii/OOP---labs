package agh.ics.oop;

import java.util.*;

public class OptionsParser {

    public static List<MoveDirection> parse(String[] args) {
        List<MoveDirection> moves = new ArrayList<>();
        for(int i=0; i < args.length; i++){
            if(args[i].equals("f") || args[i].equals("forward")){
                moves.add(MoveDirection.FORWARD);
            }
            else if(args[i].equals("b") || args[i].equals("backword")){
                moves.add(MoveDirection.BACKWORD);
            }
            else if(args[i].equals("r") || args[i].equals("right")){
                moves.add(MoveDirection.RIGHT);
            }
            else if(args[i].equals("l") || args[i].equals("left")){
                moves.add(MoveDirection.LEFT);
            }
        }
        return moves;
    }
}
