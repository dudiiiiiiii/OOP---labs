package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AnimalMapTest {
    @Test
    void stayIn(){
        String[] args = new String[]{"f", "f","f", "f","f", "f","f", "f"};
        List<MoveDirection> directions = new OptionsParser().parse(args);

        IWorldMap map = new RectangularMap(10, 5);
        List<Vector2d> positions = new ArrayList<>();
        positions.add(new Vector2d(2,2));
        positions.add(new Vector2d(3,4));
        IEngine engine = new SimulationEngine(directions, (RectangularMap) map, positions);
        engine.run();
        //System.out.println(((RectangularMap) map).getAn().get(0).getPosition());
        //Assertions.assertTrue(((RectangularMap) map).getAnimals().get(0).isAt(new Vector2d(2,5)));
        //Assertions.assertTrue(((RectangularMap) map).getAnimals().get(1).isAt(new Vector2d(3,5)));
    }
}
