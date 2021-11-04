package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class AnimalTest {
    @Test
    void stayintest(){
        Animal tester = new Animal();
        String[] first = {"f", "f", "f", "f", "f", "f", "f", "f", "l", "l"};
        for(MoveDirection x: OptionsParser.parse(first)){
            tester.move(x);
        }
        Assertions.assertEquals(true, tester.isAt(new Vector2d(2,4)));
        Assertions.assertEquals(true, tester.orient(MapDirection.SOUTH));

        Animal tester1 = new Animal();
        String[] second = {"b", "b", "b", "b", "b", "b", "b", "b", "b", "r"};
        for(MoveDirection x: OptionsParser.parse(second)){
            tester1.move(x);
        }
        Assertions.assertEquals(true, tester1.isAt(new Vector2d(2,0)));
        Assertions.assertEquals(true, tester1.orient(MapDirection.EAST));

        Animal tester2 = new Animal();
        String[] third = {"l", "r", "f", "b", "l", "l", "f", "f", "l", "f", "f", "f", "r", "b", "b", "r"};
        for(MoveDirection x: OptionsParser.parse(third)){
            tester2.move(x);
        }
        Assertions.assertEquals(true, tester2.isAt(new Vector2d(4,2)));
        Assertions.assertEquals(true, tester2.orient(MapDirection.WEST));
    }
}
