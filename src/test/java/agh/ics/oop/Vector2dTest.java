package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Vector2dTest {
    @Test
    void testequals(){
        Assertions.assertEquals(true, new Vector2d(1,2).equals(new Vector2d(1, 2)));
        Assertions.assertEquals(false, new Vector2d(1,2).equals(new Vector2d(1,3)));
    }
    @Test
    void testtoString(){
        Assertions.assertEquals("(1,2)", new Vector2d(1,2).toString());
    }
    @Test
    void testprecedes(){
        Assertions.assertEquals(true, new Vector2d(1,2).precedes(new Vector2d(1,2)));
        Assertions.assertEquals(true, new Vector2d(1,2).precedes(new Vector2d(2,2)));
        Assertions.assertEquals(true, new Vector2d(1,2).precedes(new Vector2d(1,5)));
        Assertions.assertEquals(true, new Vector2d(1,2).precedes(new Vector2d(7,5)));
        Assertions.assertEquals(false, new Vector2d(1,2).precedes(new Vector2d(0,2)));
        Assertions.assertEquals(false, new Vector2d(1,2).precedes(new Vector2d(1,1)));
        Assertions.assertEquals(false, new Vector2d(1,2).precedes(new Vector2d(0,0)));
    }
    @Test
    void testfollows(){
        Assertions.assertEquals(true, new Vector2d(1,2).follows(new Vector2d(1,2)));
        Assertions.assertEquals(false, new Vector2d(1,2).follows(new Vector2d(2,2)));
        Assertions.assertEquals(false, new Vector2d(1,2).follows(new Vector2d(1,5)));
        Assertions.assertEquals(false, new Vector2d(1,2).follows(new Vector2d(7,5)));
        Assertions.assertEquals(true, new Vector2d(1,2).follows(new Vector2d(0,2)));
        Assertions.assertEquals(true, new Vector2d(1,2).follows(new Vector2d(1,1)));
        Assertions.assertEquals(true, new Vector2d(1,2).follows(new Vector2d(0,0)));
    }
    @Test
    void testupperRight() {
        Assertions.assertEquals(true, new Vector2d(1,2).equals(new Vector2d(1,0).upperRight(new Vector2d(0,2))));
        Assertions.assertEquals(false, new Vector2d(0,0).equals(new Vector2d(1,0).upperRight(new Vector2d(0,2))));
        Assertions.assertEquals(true, new Vector2d(1,2).equals(new Vector2d(1,2).upperRight(new Vector2d(-4,-2))));
    }
    @Test
    void testlowerLeft() {
        Assertions.assertEquals(true, new Vector2d(1,2).equals(new Vector2d(1,5).lowerLeft(new Vector2d(9,2))));
        Assertions.assertEquals(false, new Vector2d(0,0).equals(new Vector2d(-1,0).lowerLeft(new Vector2d(0,-2))));
        Assertions.assertEquals(true, new Vector2d(-1,-2).equals(new Vector2d(-1,-2).lowerLeft(new Vector2d(4,2))));
    }
    @Test
    void testadd(){
        Assertions.assertEquals(true, new Vector2d(1,2).equals(new Vector2d(1,0).add(new Vector2d(0,2))));
        Assertions.assertEquals(false, new Vector2d(1,2).equals(new Vector2d(1,0).add(new Vector2d(1,2))));
    }
    @Test
    void testsubstract(){
        Assertions.assertEquals(true, new Vector2d(1,2).equals(new Vector2d(1,2).subtract(new Vector2d(0,0))));
        Assertions.assertEquals(false, new Vector2d(1,2).equals(new Vector2d(1,0).add(new Vector2d(1,2))));
    }
    @Test
    void testoppsite(){
        Assertions.assertEquals(true, new Vector2d(1,2).equals(new Vector2d(-1,-2).opposite()));
        Assertions.assertEquals(true, new Vector2d(0,0).equals(new Vector2d(0,0).opposite()));
        Assertions.assertEquals(true, new Vector2d(-6,-4).equals(new Vector2d(6,4).opposite()));
        Assertions.assertEquals(false, new Vector2d(162,-342).equals(new Vector2d(-43,-56).opposite()));
    }
}
