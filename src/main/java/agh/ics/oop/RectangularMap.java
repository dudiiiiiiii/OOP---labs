package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap implements IWorldMap {
    private Vector2d lowerLeft;
    private Vector2d upperRight;

    public RectangularMap(int width, int height) {
        this.lowerLeft = new Vector2d(0,0);
        this.upperRight = new Vector2d(width, height);
    }

    public List<Animal> getAnimals() {
        return this.animals;
    }

    public String toString(){

        MapVisualizer mapcos = new MapVisualizer(this);
        System.out.println(mapcos.draw(this.lowerLeft, this.upperRight));
        return " ";
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return super.canMoveTo(position) && position.precedes(this.upperRight);
    }


}
