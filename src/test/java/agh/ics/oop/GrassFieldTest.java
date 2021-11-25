package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GrassFieldTest {
    @Test
    void pos(){
        String[] args = new String[]{"f", "f","f", "f","f", "f","f", "f"};
        List<MoveDirection> directions = new OptionsParser().parse(args);

        IWorldMap map = new GrassField( 5);
        List<Vector2d> positions = new ArrayList<>();
        positions.add(new Vector2d(2,2));
        positions.add(new Vector2d(3,4));
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        Assertions.assertTrue(((GrassField) map).getAn().get(0).isAt(new Vector2d(2,6)));
        Assertions.assertTrue(((GrassField) map).getAn().get(1).isAt(new Vector2d(3,8)));
    }
}
